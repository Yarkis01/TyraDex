from flask_restful import Resource
from typing import Union
import json

JSON_pokemon       = json.load(open("data/pokemon.json", encoding="utf8"))
JSON_pokemon_to_id = json.load(open("data/pokemon_to_id.json", encoding="utf8"))

class Pokemon(Resource):
    def get(self, pokemon: Union[str, int] = None) -> dict:
        if pokemon is None:
            return JSON_pokemon

        try: pokemon_id = int(pokemon)
        except Exception:
            pokemon = str(pokemon).lower()
            if pokemon in JSON_pokemon_to_id:
                pokemon_id = JSON_pokemon_to_id[pokemon]
            else:
                pokemon_id = -1

        if pokemon_id == -1 or pokemon_id > len(JSON_pokemon) - 1:
            return {
                "status" : 404,
                "message": "Impossible de trouver le Pokémon dans la base de données."
            }
        
        return JSON_pokemon[pokemon_id]