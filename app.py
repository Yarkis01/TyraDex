from flask import Flask, render_template, send_file, request, abort
from flask_restful import Api
from flask_minify import Minify
from flask_squeeze import Squeeze
from flask_cors import CORS

from resources.moves   import Moves
from resources.pokemon import Pokemon, Generation
from resources.types import Types

import json, os, markdown

app = Flask(__name__, static_folder="assets")
api = Api(app, "/api/v1")

config = {
    "COMPRESS_MINIFY_CSS": False,
    "COMPRESS_MINIFY_JS": False,
}

app.config.from_mapping(config)

CORS(app)
Squeeze(app)
Minify(app=app, html=True, js=True, cssless=True)


@app.route("/")
def _home():
    pokemon = json.load(open("data/pokemon/pokemon.json", encoding="utf8"))
    return render_template("views/homepage.jinja", total_pkm=(len(pokemon) - 1))


@app.route("/docs")
@app.route("/docs/<path:path>")
def _docs(path: str = None):
    path = "./docs/index.md" if path is None else f"./docs/{path}.md"
    return (
        render_template(
            "views/docs.jinja",
            markdown=markdown.markdown(
                open(path, encoding="utf-8").read(),
                extensions=["fenced_code", "tables"],
            ),
            navbar=markdown.markdown(open("./docs/navbar.md", encoding="utf-8").read()),
        )
        if os.path.exists(path)
        else abort(404)
    )


@app.route("/openapi.<string:extension>")
def _open_api(extension: str):
    if extension.lower() == "json":
        return send_file(
            "./data/openapi/openapi.json", mimetype="text/json", as_attachment=False
        )

    return send_file(
        "./data/openapi/openapi.yml", mimetype="text/yaml", as_attachment=False
    )


@app.route("/robots.txt")
def _robots():
    return send_file("robots.txt")


@app.errorhandler(404)
def _page_not_found(error):
    return render_template("views/404.jinja"), 404


api.add_resource(
    Pokemon,
    "/pokemon",
    "/pokemon/<string:pokemon>",
    "/pokemon/<string:pokemon>/<string:forme>",
)
api.add_resource(Generation, "/gen", "/gen/<string:gen>")
api.add_resource(Types, "/types", "/types/<string:first_type>",  "/types/<string:first_type>/<string:second_type>")

if __name__ == "__main__":
    app.run(debug=True)
