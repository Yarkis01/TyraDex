from fastapi import APIRouter, HTTPException
import json


JSON_pokemon = json.load(open("data/pokemon/pokemon.json", encoding="utf8"))
JSON_forme_pokemon = json.load(
    open("data/pokemon/formes_regionales.json", encoding="utf8")
)

router = APIRouter()


@router.get("/gen", summary="Obtenir la liste des différentes générations")
async def _gen():
    """Permet d'obtenir la liste des différentes générations."""
    generations = {}

    for pkm in JSON_pokemon:
        if pkm["pokedex_id"] == 0:
            continue

        if pkm["generation"] not in generations:
            generations[pkm["generation"]] = {
                "generation": pkm["generation"],
                "from": pkm["pokedex_id"],
                "to": pkm["pokedex_id"],
            }
        else:
            generations[pkm["generation"]]["to"] = pkm["pokedex_id"]

    return generations


@router.get("/gen/{gen_id}", summary="Obtenir les informations d'une génération")
async def _gen_id(gen_id: int):
    """
    Permet d'obtenir les informations d'une génération.

    | Nom | Obligatoire | Type | Description |
    |---|---|---|---|
    | gen_id | Requis | `Int` | Correspond au numéro de la génération. |
    """
    generation = [
        pkm
        for pkm in JSON_pokemon
        if pkm["pokedex_id"] != 0 and pkm["generation"] == gen_id
    ]

    if str(gen_id) in JSON_forme_pokemon["region"]:
        for region in JSON_forme_pokemon["region"][str(gen_id)]:
            generation.extend(JSON_forme_pokemon[region].values())

    if not generation:
        raise HTTPException(
            status_code=404,
            detail={
                "status": 404,
                "message": "La génération demandée n'existe pas.",
            },
        )

    return generation
