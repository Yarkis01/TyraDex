from pydantic import BaseModel, Field

from models.utils import NameModel, DoubleNameModel, ResistanceModel
from models.pokemon import PokemonModel


class SingleTypeModel(BaseModel):
    """Modèle de données pour un type simple."""

    id_: int = Field(alias="id")
    name: NameModel
    sprites: str
    resistances: list[ResistanceModel]


class SingleTypeWithPokemonModel(SingleTypeModel):
    """Modèle de données pour un type simple avec les Pokémon associés."""

    pokemons: list[PokemonModel] | None


class DoubleTypeModel(BaseModel):
    """Modèle de données pour un type double."""

    id_: list[int] = Field(alias="id")
    name: DoubleNameModel
    sprites: list[str]
    resistances: list[ResistanceModel]


class DoubleTypeWithPokemonModel(DoubleTypeModel):
    """Modèle de données pour un type double avec les Pokémon associés."""

    pokemons: list[PokemonModel] | None
