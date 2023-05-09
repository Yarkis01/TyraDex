from flask_restful import Resource
from typing import Union
import json

JSON_types         = json.load(open("data/types/types.json", encoding="utf8"))
JSON_types_to_id   = json.load(open("data/types/types_id.json", encoding="utf8"))["types_to_id"]
JSON_id_to_types   = json.load(open("data/types/types_id.json", encoding="utf8"))["id_to_type"]
JSON_pokemon       = json.load(open("data/pokemon/pokemon.json", encoding="utf8"))
JSON_forme_pokemon = json.load(open("data/pokemon/formes_regionales.json", encoding="utf-8"))

NOT_FOUND = {
    "status" : 404,
    "message": "Impossible de trouver le type demandé dans la base de données."
}

class Types(Resource):
    def get(self, first_type: Union[str, int] = None, second_type: Union[str, int] = None) -> dict:
        if not first_type:
            return JSON_types

        first_type_id = int(first_type) if first_type.isdigit() else JSON_types_to_id.get(str(first_type).lower(), -1)
        if first_type_id == -1:
            return {**NOT_FOUND, **{"type": first_type}}
        
        if second_type:
            second_type_id = int(second_type) if second_type.isdigit() else JSON_types_to_id.get(str(second_type).lower(), -1)
            if second_type_id == -1:
                return {**NOT_FOUND, **{"type": second_type}}

        if not second_type or first_type_id == second_type_id:
            json = JSON_types[first_type_id]
            json["pokemons"] = [
                pokemon
                for pokemon in JSON_pokemon
                if pokemon["pokedexId"] != 0
                and (
                    str(pokemon["types"][0]["name"]).lower() == JSON_id_to_types[first_type_id]
                    or (
                        len(pokemon["types"]) > 1
                        and str(pokemon["types"][1]["name"]).lower() == JSON_id_to_types[first_type_id]
                    )
                )
            ]
            return json
        
        first_type_json  = JSON_types[first_type_id]
        second_type_json = JSON_types[second_type_id]
        
        return {
            "id": [first_type_id, second_type_id],
            "name": {
                "fr": [first_type_json["name"]["fr"], second_type_json["name"]["fr"]],
                "en": [first_type_json["name"]["en"], second_type_json["name"]["en"]],
                "jp": [first_type_json["name"]["jp"], second_type_json["name"]["jp"]]
            },
            "sprites": [
                first_type_json["sprites"],
                second_type_json["sprites"]
            ],
            "resistances": [
                {
                    "name": first_type_json["resistances"][i]["name"],
                    "multiplier": int(first_type_json["resistances"][i]["multiplier"] * second_type_json["resistances"][i]["multiplier"])
                    if (first_type_json["resistances"][i]["multiplier"] * second_type_json["resistances"][i]["multiplier"]) % 1 == 0
                    else first_type_json["resistances"][i]["multiplier"] * second_type_json["resistances"][i]["multiplier"]
                } for i in range(len(first_type_json["resistances"]))
            ],
            "pokemons": [
                pokemon
                for pokemon in JSON_pokemon
                if pokemon["pokedexId"] != 0
                and len(pokemon["types"]) > 1
                and
                (
                    (
                        str(pokemon["types"][0]["name"]).lower() == JSON_id_to_types[first_type_id]
                        and str(pokemon["types"][1]["name"]).lower() == JSON_id_to_types[second_type_id]
                    )
                    or
                    (
                        str(pokemon["types"][0]["name"]).lower() == JSON_id_to_types[second_type_id]
                        and str(pokemon["types"][1]["name"]).lower() == JSON_id_to_types[first_type_id]
                    )
                )
            ]
        }