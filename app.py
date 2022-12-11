from flask import Flask, redirect
from flask_restful import Api

from resources.pokemon import Pokemon

app = Flask(__name__, static_folder = "assets")
api = Api(app, "/api/v1")

@app.route("/")
def _home():
    return "Hello World!"

@app.errorhandler(404)
def _page_not_found(error):
    return redirect("/")

api.add_resource(Pokemon, "/pokemon", "/pokemon/<string:pokemon>")

if __name__ == '__main__':
    app.run(debug = True)