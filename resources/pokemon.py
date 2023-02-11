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

class Generation(Resource):
    def get(self, gen: Union[str, int]) -> dict:
        try:
            gen = int(gen)

            data = [pkm for pkm in JSON_pokemon if pkm["generation"] == gen]

            if len(data) == 0:
                data = {
                    "status" : 404,
                    "message": "Impossible d'afficher cette génération, car elle n'existe pas."
                }
        except Exception:
            if gen.lower() == "list" or gen.lower() == "liste":
                generations = {}
                data = []

                for pkm in JSON_pokemon:
                    if pkm["pokedexId"] == 0:
                        continue

                    if pkm["generation"] not in generations:
                        generations[pkm["generation"]] = {
                            "generation": pkm["generation"],
                            "from": pkm["pokedexId"],
                            "to": pkm["pokedexId"]
                        }
                    else:
                        generations[pkm["generation"]]["to"] = pkm["pokedexId"]

                for gen in generations.values():
                    data.append(gen)

            else:
                data = {
                    "status" : 404,
                    "message": "Impossible d'afficher cette génération, car elle n'existe pas."
                }

        return data