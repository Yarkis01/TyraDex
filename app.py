from flask          import Flask, render_template, redirect, request
from flask_restful  import Api
from flask_minify   import Minify
from flask_cors     import CORS

from resources.pokemon import Pokemon, Generation

import datetime, json

app = Flask(__name__, static_folder = "assets")
api = Api(app, "/api/v1")
CORS(app)
Minify(app = app, html = True, js = True, cssless = True)

@app.route("/")
def _home():
    pokemon = json.load(open("data/pokemon.json", encoding = "utf8"))
    return render_template("views/homepage.jinja", date = datetime.date.today(), total_pkm = (len(pokemon) - 1), base_url = f"{request.base_url}")

@app.errorhandler(404)
def _page_not_found(error):
    return render_template("views/404.jinja", date = datetime.date.today())

api.add_resource(Pokemon, "/pokemon", "/pokemon/<string:pokemon>", "/pokemon/<string:pokemon>/<string:forme>")
api.add_resource(Generation, "/gen", "/gen/<string:gen>")

if __name__ == "__main__":
    app.run(debug = True)