from flask          import Flask, render_template, request
from flask_restful  import Api
from flask_minify   import Minify
from flask_squeeze  import Squeeze
from flask_cors     import CORS
from flask_assets   import Environment, Bundle

from resources.pokemon import Pokemon, Generation

import datetime, json

app = Flask(__name__, static_folder = "assets")
api = Api(app, "/api/v1")

config = {
    "COMPRESS_MINIFY_CSS": False,
    "COMPRESS_MINIFY_JS" : False,
}

app.config.from_mapping(config)

bundles = {
    "base_css": Bundle(
        "css/fonts.css",
        "css/base.css",
        "css/responsive.css",
        output = "css/styles.css"
    ),
    "homepage_css": Bundle(
        "css/homepage/styles.css",
        "css/homepage/animation.css",
        "css/homepage/responsive.css",
        output = "css/homepage.css"
    ),
    "404_css": Bundle(
        "css/404/animation.css",
        "css/404/styles.css",
        output = "css/404_erreur.css"
    )
}

assets = Environment(app)
assets.register(bundles)

CORS(app)
Squeeze(app)
Minify(app = app, html = True, js = True, cssless = True)

@app.route("/")
def _home():
    pokemon = json.load(open("data/pokemon.json", encoding = "utf8"))
    return render_template("views/homepage.jinja", date = datetime.date.today(), total_pkm = (len(pokemon) - 1), base_url = f"{request.base_url}", css_file = "homepage_css")

@app.errorhandler(404)
def _page_not_found(error):
    return render_template("views/404.jinja", date = datetime.date.today(), css_file = "404_css"), 404

api.add_resource(Pokemon, "/pokemon", "/pokemon/<string:pokemon>", "/pokemon/<string:pokemon>/<string:forme>")
api.add_resource(Generation, "/gen", "/gen/<string:gen>")

if __name__ == "__main__":
    app.run(debug = True)