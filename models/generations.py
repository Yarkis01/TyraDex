from pydantic import BaseModel, Field


class SimpleGenerationModel(BaseModel):
    """Modèle pour les générations."""

    generation: int
    from_: int = Field(alias="from")
    to: int
