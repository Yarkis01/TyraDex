from fastapi import FastAPI, Request, HTTPException
from fastapi.staticfiles import StaticFiles
from fastapi.templating import Jinja2Templates
from fastapi.responses import PlainTextResponse, JSONResponse, RedirectResponse

from unidecode import unidecode

import markdown
import httpx
import json
import os
import re

from routers import pokemon, generations, types

app = FastAPI(
    docs_url="/swagger",
    redoc_url="/redoc",
    title="Tyradex",
    description="Une API Pokémon en français.",
    version="1.0.0",
    license_info={
        "name": "MIT",
        "url": "https://github.com/Yarkis01/TyraDex/blob/main/LICENSE",
    },
    terms_of_service="https://tyradex.vercel.app/docs",
)

templates = Jinja2Templates(
    directory="templates", context_processors=[lambda request: {"unidecode": unidecode}]
)
app.mount("/assets", StaticFiles(directory="assets"), name="assets")

# Ajout des routes
API_V1_PREFIX = "/api/v1"
app.include_router(pokemon.router, prefix=API_V1_PREFIX, tags=["Pokémon"])
app.include_router(generations.router, prefix=API_V1_PREFIX, tags=["Générations"])
app.include_router(types.router, prefix=API_V1_PREFIX, tags=["Types"])


@app.get("/", include_in_schema=False)
async def _home(request: Request):
    """Retourne la page d'accueil."""
    pokemon = json.load(open("data/pokemon/pokemon.json", encoding="utf8"))
    return templates.TemplateResponse(
        request=request,
        name="views/homepage.jinja",
        context={"total_pkm": len(pokemon) - 1},
    )


@app.get("/docs", include_in_schema=False)
@app.get("/docs/{path:path}", include_in_schema=False)
async def _docs(request: Request, path: str = None):
    """Retourne la page de documentation."""
    path = "./docs/index.md" if path is None else f"./docs/{path}.md"

    if os.path.exists(path) is False:
        raise HTTPException(status_code=404, detail="La page demandée n'existe pas.")

    return templates.TemplateResponse(
        request=request,
        name="views/docs.jinja",
        context={
            "markdown": markdown.markdown(
                open(path, encoding="utf-8").read(),
                extensions=["fenced_code", "tables"],
            ),
            "navbar": markdown.markdown(
                open("./docs/navbar.md", encoding="utf-8").read()
            ),
        },
    )


@app.get("/dex", include_in_schema=False)
@app.get("/dex/{pokemon}", include_in_schema=False)
@app.get("/dex/{pokemon}/{forme}", include_in_schema=False)
async def _dex(request: Request, pokemon: str = None, forme: str = None):
    """Retourne la page du Pokédex."""
    data = json.load(open("data/pokemon/pokemon.json", encoding="utf8"))

    if not pokemon or not re.match("^[a-zA-Z0-9-_.À-ÖØ-öø-ÿ]+$", pokemon):
        return templates.TemplateResponse(
            request=request,
            name="views/dex.jinja",
            context={
                "erreur": bool(pokemon),
                "pokemon": None,
                "forme": None,
                "data": data,
            },
        )

    newPokemon = unidecode(pokemon.lower().replace(" ", ""))
    if newPokemon != pokemon:
        return RedirectResponse(url=f"/dex/{newPokemon}", status_code=303)

    url = f"{request.base_url}api/v1/pokemon/{pokemon}"
    if forme:
        forme = forme.lower()
        url += f"/{forme}"

    async with httpx.AsyncClient() as client:
        try:
            response = await client.get(url, timeout=10)
            response.raise_for_status()
        except Exception as e:
            return templates.TemplateResponse(
                request=request,
                name="views/dex.jinja",
                context={
                    "erreur": True,
                    "pokemon": None,
                    "forme": None,
                    "data": data,
                },
            )

    return templates.TemplateResponse(
        request=request,
        name="views/dex.jinja",
        context={
            "erreur": False,
            "pokemon": response.json(),
            "forme": forme,
            "data": data,
            "data_region": json.load(
                open("data/pokemon/formes_regionales.json", encoding="utf8")
            ),
        },
    )


@app.get("/robots.txt", response_class=PlainTextResponse, include_in_schema=False)
async def _robots():
    """Retourne le fichier robots.txt."""
    return open("robots.txt", "r").read()


@app.exception_handler(404)
async def _404(request: Request, exc: HTTPException):
    return (
        JSONResponse(
            (
                {"status": 404, "message": "Impossible de trouver la page demandée."}
                if exc.detail == "Not Found"
                else exc.detail
            ),
            status_code=404,
        )
        if request.url.path.startswith("/api")
        else templates.TemplateResponse(
            request=request, name="views/404.jinja", context={"exc": exc}
        )
    )


if __name__ == "__main__":
    import uvicorn

    uvicorn.run(app)
