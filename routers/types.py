from fastapi import APIRouter, HTTPException
from typing import Union
import json

JSON_types = json.load(open("data/types/types.json", encoding="utf8"))
JSON_types_to_id = json.load(open("data/types/types_id.json", encoding="utf8"))[
    "types_to_id"
]
JSON_id_to_types = json.load(open("data/types/types_id.json", encoding="utf8"))[
    "id_to_type"
]
JSON_pokemon = json.load(open("data/pokemon/pokemon.json", encoding="utf8"))
JSON_forme_pokemon = json.load(
    open("data/pokemon/formes_regionales.json", encoding="utf-8")
)

NOT_FOUND = {
    "status": 404,
    "message": "Impossible de trouver le type demandé dans la base de données.",
}

router = APIRouter()


def __get_type(type: Union[str, int]) -> int:
    """
    Permet de récupérer l'identifiant d'un type.

    Args:
        type (Union[str, int]): Le type à convertir.

    Returns:
        int: L'identifiant du type ou -1 si le type n'existe pas.
    """
    return int(type) if type.isdigit() else JSON_types_to_id.get(str(type).lower(), -1)


def __get_pokemon_by_type(first_type: int, second_type: int = None) -> list:
    """
    Permet de récupérer la liste des Pokémon ayant un type donné.

    Args:
        first_type (int): Le premier type.
        second_type (int): Le deuxième type. Par défaut, `None`.

    Returns:
        list: La liste des Pokémon ayant le type donné.
    """
    pokemons = []

    for pokemon in JSON_pokemon:
        if pokemon["pokedex_id"] == 0:
            continue

        types = [t["name"].lower() for t in pokemon["types"]]
        first_type_match = JSON_id_to_types[first_type] in types
        second_type_match = (
            second_type is not None and JSON_id_to_types[second_type] in types
        )

        if first_type_match and (second_type is None or second_type_match):
            pokemons.append(pokemon)

    return {"pokemons": pokemons}


@router.get("/types", summary="Obtenir la liste des types")
async def _types():
    """Permet d'obtenir la liste de tous les types."""
    return JSON_types


@router.get(
    "/types/{type}",
    summary="Obtenir les informations sur un type",
)
async def _type(type: Union[str, int]):
    """
    Permet d'obtenir des informations sur un type spécifique.

    | Nom | Obligatoire | Type | Description |
    |---|---|---|---|
    | type | Requis | `Int` ou `String` | Correspond à l'identifiant du type, ou bien son nom anglais ou français. |
    """
    type_id = __get_type(type)

    if type_id < 0 or type_id > len(JSON_types) - 1:
        raise HTTPException(status_code=404, detail={**NOT_FOUND, **{"type": type}})

    return {**JSON_types[type_id], **__get_pokemon_by_type(type_id)}


@router.get(
    "/types/{first_type}/{second_type}",
    summary="Obtenir les informations sur un type double",
)
async def _double_types(first_type: Union[str, int], second_type: Union[str, int]):
    """
    Permet d'obtenir des informations sur un type double spécifique.

    | Nom | Obligatoire | Type | Description |
    |---|---|---|---|
    | first_type | Requis | `Int` ou `String` | Correspond à l'identifiant du type, ou bien son nom anglais ou français. |
    | second_type | Requis | `Int` ou `String` | Correspond au deuxième type souhaité. |
    """
    first_type_id = __get_type(first_type)
    second_type_id = __get_type(second_type)

    if first_type_id < 0 or first_type_id > len(JSON_types) - 1:
        raise HTTPException(
            status_code=404, detail={**NOT_FOUND, **{"type": first_type}}
        )

    if second_type_id < 0 or second_type_id > len(JSON_types) - 1:
        raise HTTPException(
            status_code=404, detail={**NOT_FOUND, **{"type": second_type}}
        )

    first_type_json = JSON_types[first_type_id]
    second_type_json = JSON_types[second_type_id]

    return {
        "id": [first_type_id, second_type_id],
        "name": {
            "fr": [first_type_json["name"]["fr"], second_type_json["name"]["fr"]],
            "en": [first_type_json["name"]["en"], second_type_json["name"]["en"]],
            "jp": [first_type_json["name"]["jp"], second_type_json["name"]["jp"]],
        },
        "sprites": [first_type_json["sprites"], second_type_json["sprites"]],
        "resistances": [
            {
                "name": first_type_json["resistances"][i]["name"],
                "multiplier": (
                    int(
                        first_type_json["resistances"][i]["multiplier"]
                        * second_type_json["resistances"][i]["multiplier"]
                    )
                    if (
                        first_type_json["resistances"][i]["multiplier"]
                        * second_type_json["resistances"][i]["multiplier"]
                    )
                    % 1
                    == 0
                    else first_type_json["resistances"][i]["multiplier"]
                    * second_type_json["resistances"][i]["multiplier"]
                ),
            }
            for i in range(len(first_type_json["resistances"]))
        ],
        "pokemons": __get_pokemon_by_type(first_type_id, second_type_id),
    }
