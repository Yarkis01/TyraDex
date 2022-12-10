from flask_restful import Resource
from typing import Union
import json, contextlib

JSON_pokemon       = json.load(open("data/pokemon.json", encoding="utf8"))
JSON_pokemon_to_id = json.load(open("data/id_to_pokemon.json", encoding="utf8"))

class Pokemon(Resource):
    def get(self, pokemon: Union[str, int]) -> dict:
        with contextlib.suppress(ValueError):
            pokemon = int(pokemon)
            if str(pokemon) in JSON_pokemon_to_id:
                pokemon = JSON_pokemon_to_id[str(pokemon)]

        if pokemon.lower() not in JSON_pokemon:
            return {
                "status": 404,
                "error" : "Impossible de trouver le Pokémon dans la base de données."
            }

        return JSON_pokemon[pokemon.lower()]