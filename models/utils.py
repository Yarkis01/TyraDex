from pydantic import BaseModel


class NameModel(BaseModel):
    """Représente un nom multilingue."""

    fr: str
    en: str
    jp: str


class DoubleNameModel(BaseModel):
    """Représente un nom multilingue."""

    fr: list[str]
    en: list[str]
    jp: list[str]


class ResistanceModel(BaseModel):
    """Représente une résistance."""

    name: str
    multiplier: float
