from fastapi import APIRouter, HTTPException
from typing import Union
import json

JSON_pokemon = json.load(open("data/pokemon/pokemon.json", encoding="utf8"))
JSON_pokemon_to_id = json.load(open("data/pokemon/pokemon_to_id.json", encoding="utf8"))
JSON_forme_pokemon = json.load(
    open("data/pokemon/formes_regionales.json", encoding="utf8")
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


@router.get("/pokemon", summary="Obtenir la liste des différents Pokémon")
async def _pokemons():
    """Permet d'obtenir la liste des différents Pokémon."""
    return JSON_pokemon


@router.get("/pokemon/{pokemon}", summary="Obtenir les informations d'un Pokémon")
async def _pokemon(pokemon: Union[str, int]):
    """
    Permet d'obtenir les informations d'un Pokémon.

    | Nom | Obligatoire | Type | Description |
    |---|---|---|---|
    | pokemon | Requis | `Int` ou `String` | Correspond à l'identifiant du Pokémon dans le Pokédex National ou son nom. |
    """
    pokemon_id = __get_pokemon_id(pokemon)

    if pokemon_id == -1 or pokemon_id > len(JSON_pokemon) - 1:
        raise HTTPException(
            status_code=404,
            detail=NOT_FOUND,
        )

    return JSON_pokemon[pokemon_id]


@router.get(
    "/pokemon/{pokemon}/{region}",
    summary="Obtenir les informations sur une forme régionale",
)
async def _pokemon_regionale(pokemon: Union[str, int], region: str):
    """
        Permet d'obtenir les informations sur une forme régionale d'un Pokémon.

    | Nom | Obligatoire | Type | Description |
    |---|---|---|---|
    | pokemon | Requis | `Int` ou `String` | Correspond à l'identifiant du Pokémon dans le Pokédex National ou son nom. |
    | region | Optionnel | `String` | Correspond à la région du Pokémon. <br>Permet de récupèrer les informations sur une forme régionale d'un Pokémon. |
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

    return JSON_forme_pokemon[region][str(pokemon_id)]
