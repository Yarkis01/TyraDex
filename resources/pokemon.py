from flask_restful import Resource
from typing import Union
import json

JSON_pokemon       = json.load(open("data/pokemon/pokemon.json", encoding="utf8"))
JSON_pokemon_to_id = json.load(open("data/pokemon/pokemon_to_id.json", encoding="utf8"))
JSON_forme_pokemon = json.load(open("data/pokemon/formes_regionales.json", encoding="utf-8"))

class Pokemon(Resource):
    def get(self, pokemon: Union[str, int] = None, forme: str = None) -> dict:
        if pokemon is None:
            return JSON_pokemon

        pokemon_id = int(pokemon) if pokemon.isdigit() else JSON_pokemon_to_id.get(str(pokemon).lower(), -1)

        if pokemon_id == -1 or pokemon_id > len(JSON_pokemon) - 1:
            return {
                "status" : 404,
                "message": "Impossible de trouver le Pokémon dans la base de données."
            }
        
        if forme is None or forme not in JSON_forme_pokemon:
            return JSON_pokemon[pokemon_id]
        
        return JSON_forme_pokemon[forme][str(pokemon_id)] if str(pokemon_id) in JSON_forme_pokemon[forme] else {"status": 404, "message": "Impossible de trouver la forme régionale du Pokémon demandé."}

class Generation(Resource):
    def get(self, gen: str = None) -> dict:
        if gen is not None:
            formes_regionales = []

            if gen in JSON_forme_pokemon["region"]:
                for region in JSON_forme_pokemon["region"][gen]:
                    formes_regionales.extend(
                        JSON_forme_pokemon[region][pkm]
                        for pkm in JSON_forme_pokemon[region]
                    )

            return ([pkm for pkm in JSON_pokemon if str(pkm["generation"]) == gen and pkm["pokedexId"] != 0] + formes_regionales) or {
                "status": 404,
                "message": "Impossible d'afficher cette génération, car elle n'existe pas.",
            }

        generations = {}
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

        return list(generations.values())