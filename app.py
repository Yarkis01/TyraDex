from flask          import Flask, render_template, send_file, request
from flask_restful  import Api
from flask_minify   import Minify
from flask_squeeze  import Squeeze
from flask_cors     import CORS

from resources.pokemon import Pokemon, Generation

import datetime, json

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
    return render_template("views/homepage.jinja", date = datetime.date.today(), total_pkm = (len(pokemon) - 1), base_url = f"{request.base_url}", css_file = "homepage.css")

@app.route('/robots.txt')
def _robots():
    return send_file("robots.txt")

@app.errorhandler(404)
def _page_not_found(error):
    return render_template("views/404.jinja", date = datetime.date.today(), css_file = "404.css"), 404

api.add_resource(Pokemon, "/pokemon", "/pokemon/<string:pokemon>", "/pokemon/<string:pokemon>/<string:forme>")
api.add_resource(Generation, "/gen", "/gen/<string:gen>")

if __name__ == "__main__":
    app.run(debug = True)