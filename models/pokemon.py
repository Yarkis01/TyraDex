from pydantic import BaseModel, Field
from typing import Union


from models.utils import (
    NameModel,
    ResistanceModel,
)


class SimpleSpriteModel(BaseModel):
    """Représente un sprite simple."""

    regular: str
    shiny: Union[str, None]


class DetailledSpriteModel(SimpleSpriteModel):
    """Représente un sprite détaillé."""

    gmax: Union[SimpleSpriteModel, None]


class TalentModel(BaseModel):
    """Représente un talent."""

    name: str
    tc: bool


class StatsModel(BaseModel):
    """Représente les statistiques d'un Pokémon."""

    hp: int
    atk: int
    defense: int = Field(alias="def")
    spe_atk: int
    spe_def: int
    vit: int


class PokemonEvolutionModel(BaseModel):
    """Représente une évolution d'un Pokémon."""

    pokedex_id: int
    name: str
    condition: str


class MegaEvolutionModel(BaseModel):
    """Représente une méga-évolution d'un Pokémon."""

    orbe: str
    sprites: SimpleSpriteModel


class EvolutionModel(BaseModel):
    """Représente les évolutions d'un Pokémon."""

    pre: Union[list[PokemonEvolutionModel], None]
    next_: Union[list[PokemonEvolutionModel], None] = Field(alias="next")
    mega: Union[list[MegaEvolutionModel], None]


class SexeModel(BaseModel):
    """Représente les taux de sexe d'un Pokémon."""

    male: float
    female: float


class RegionalFormModel(BaseModel):
    """Représente une forme régionale d'un Pokémon."""

    region: str
    name: NameModel


class SimpleTypeModel(BaseModel):
    """Représente un type."""

    name: str
    image: str


class PokemonModel(BaseModel):
    """Représente un Pokémon."""

    pokedex_id: int
    generation: int
    category: str
    name: NameModel
    sprites: Union[DetailledSpriteModel, None]
    types: Union[list[SimpleTypeModel], None]
    talents: Union[list[TalentModel], None]
    stats: Union[StatsModel, None]
    resistances: Union[list[ResistanceModel], None]
    evolution: Union[EvolutionModel, None]
    height: Union[str, None]
    weight: Union[str, None]
    egg_groups: Union[list[str], None]
    sexe: Union[SexeModel, None]
    catch_rate: Union[int, None]
    level_100: Union[int, None]
    formes: Union[list[RegionalFormModel], None]
