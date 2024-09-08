from pydantic import BaseModel, Field

from models.utils import (
    NameModel,
    ResistanceModel,
)


class SimpleSpriteModel(BaseModel):
    """Représente un sprite simple."""

    regular: str
    shiny: str | None


class DetailledSpriteModel(SimpleSpriteModel):
    """Représente un sprite détaillé."""

    gmax: SimpleSpriteModel | None


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

    pre: list[PokemonEvolutionModel] | None
    next_: list[PokemonEvolutionModel] | None = Field(alias="next")
    mega: list[MegaEvolutionModel] | None


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
    sprites: DetailledSpriteModel | None
    types: list[SimpleTypeModel] | None
    talents: list[TalentModel] | None
    stats: StatsModel | None
    resistances: list[ResistanceModel] | None
    evolution: EvolutionModel | None
    height: str | None
    weight: str | None
    egg_groups: list[str] | None
    sexe: SexeModel | None
    catch_rate: int | None
    level_100: int | None
    formes: list[RegionalFormModel] | None
