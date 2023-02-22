from flask          import Flask, render_template, send_file, request, abort
from flask_restful  import Api
from flask_minify   import Minify
from flask_squeeze  import Squeeze
from flask_cors     import CORS

from resources.pokemon import Pokemon, Generation

import json, os, markdown

app = Flask(__name__, static_folder = "assets")
api = Api(app, "/api/v1")

config = {
    "COMPRESS_MINIFY_CSS": False,
    "COMPRESS_MINIFY_JS" : False,
}

app.config.from_mapping(config)

CORS(app)
Squeeze(app)
Minify(app = app, html = True, js = True, cssless = True)

@app.route("/")
def _home():
    pokemon = json.load(open("data/pokemon.json", encoding = "utf8"))
    return render_template("views/homepage.jinja", total_pkm = (len(pokemon) - 1), base_url = f"{request.base_url}", css_file = "homepage.css")

@app.route('/docs')
@app.route('/docs/<path:path>')
def _docs(path: str = None):
    path = "./docs/index.md" if path is None else f"./docs/{path}.md"
    return render_template('views/docs.jinja', markdown = markdown.markdown(open(path, encoding="utf-8").read()), navbar = markdown.markdown(open("./docs/navbar.md", encoding="utf-8").read()), css_file = "documentation.css") if os.path.exists(path) else abort(404)

@app.route('/robots.txt')
def _robots():
    return send_file("robots.txt")

@app.errorhandler(404)
def _page_not_found(error):
    return render_template("views/404.jinja", css_file = "404.css"), 404

api.add_resource(Pokemon, "/pokemon", "/pokemon/<string:pokemon>", "/pokemon/<string:pokemon>/<string:forme>")
api.add_resource(Generation, "/gen", "/gen/<string:gen>")

if __name__ == "__main__":
    app.run(debug = True)