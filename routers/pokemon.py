from fastapi import APIRouter, HTTPException
from typing import Union
import json

from models.pokemon import PokemonModel

JSON_pokemon = json.load(open("data/pokemon/pokemon.json", encoding="utf8"))
JSON_pokemon_to_id = json.load(open("data/pokemon/pokemon_to_id.json", encoding="utf8"))
JSON_forme_pokemon = json.load(
    open("data/pokemon/formes_regionales.json", encoding="utf8")
)
JSON_pokemon_resistances = json.load(
    open("data/pokemon/pokemon_resistances.json", encoding="utf8")
)

NOT_FOUND = {
    "status": 404,
    "message": "Impossible de trouver le Pokémon dans la base de données.",
}

router = APIRouter()


def __get_pokemon_id(pokemon: Union[str, int]) -> int:
    """
    Permet de récupérer l'identifiant d'un Pokémon.

    Args:
        pokemon (Union[str, int]): Le nom ou l'identifiant du Pokémon.

    Returns:
        int: L'identifiant du Pokémon ou -1 si le Pokémon n'existe pas.
    """
    return (
        int(pokemon)
        if pokemon.isdigit()
        else JSON_pokemon_to_id.get(str(pokemon).lower(), -1)
    )


@router.get(
    "/pokemon",
    summary="Obtenir la liste des différents Pokémon",
    response_model=list[PokemonModel],
)
async def _pokemons():
    """Permet d'obtenir la liste des différents Pokémon."""
    return JSON_pokemon


@router.get(
    "/pokemon/{pokemon}",
    summary="Obtenir les informations d'un Pokémon",
    response_model=PokemonModel,
)
async def _pokemon(pokemon: Union[str, int], talent: str = None):
    """
    Permet d'obtenir les informations d'un Pokémon.

    Paramètres (path) :
    | Nom | Type | Description |
    |---|---|---|
    | pokemon | `Int` ou `String` | Correspond à l'identifiant du Pokémon dans le Pokédex National ou son nom. |

    Paramètres (query) :
    | Nom  | Type | Description |
    |---|---|---|
    | talent | `String` | Correspond au talent du Pokémon. <br>Permet de récupérer les résistances du Pokémon en fonction de son talent. |
    """
    pokemon_id = __get_pokemon_id(pokemon)

    if pokemon_id == -1 or pokemon_id > len(JSON_pokemon) - 1:
        raise HTTPException(
            status_code=404,
            detail=NOT_FOUND,
        )

    data = JSON_pokemon[pokemon_id]

    if (
        talent
        and any(t["name"].lower() == talent.lower() for t in data["talents"])
        and (
            (str(pokemon_id) in JSON_pokemon_resistances)
            and (talent in JSON_pokemon_resistances[str(pokemon_id)])
        )
    ):
        data["resistances"] = JSON_pokemon_resistances[str(pokemon_id)][talent]

    return data


@router.get(
    "/pokemon/{pokemon}/{region}",
    summary="Obtenir les informations sur une forme régionale",
    response_model=PokemonModel,
)
async def _pokemon_regionale(pokemon: Union[str, int], region: str, talent: str = None):
    """
    Permet d'obtenir les informations sur une forme régionale d'un Pokémon.

    Paramètres (path) :
    | Nom | Type | Description |
    |---|---|---|
    | pokemon | `Int` ou `String` | Correspond à l'identifiant du Pokémon dans le Pokédex National ou son nom. |
    | region | `String` | Correspond à la région du Pokémon. <br>Permet de récupèrer les informations sur une forme régionale d'un Pokémon. |

    Paramètres (query):
    | Nom | Type | Description |
    |---|---|---|
    | talent | `String` | Correspond au talent du Pokémon. <br>Permet de récupérer les résistances du Pokémon en fonction de son talent. |
    """
    pokemon_id = __get_pokemon_id(pokemon)

    if pokemon_id == -1 or pokemon_id > len(JSON_pokemon) - 1:
        raise HTTPException(
            status_code=404,
            detail=NOT_FOUND,
        )

    if (
        region not in JSON_forme_pokemon
        or str(pokemon_id) not in JSON_forme_pokemon[region]
    ):
        raise HTTPException(
            status_code=404,
            detail={
                "status": 404,
                "message": "La forme régionale demandée n'existe pas.",
            },
        )

    data = JSON_forme_pokemon[region][str(pokemon_id)]

    if (
        talent
        and any(t["name"].lower() == talent.lower() for t in data["talents"])
        and (
            (str(pokemon_id) in JSON_pokemon_resistances["region"][region.lower()])
            and (
                talent
                in JSON_pokemon_resistances["region"][region.lower()][str(pokemon_id)]
            )
        )
    ):
        print("hello")
        data["resistances"] = JSON_pokemon_resistances["region"][region.lower()][
            str(pokemon_id)
        ][talent]

    return data
