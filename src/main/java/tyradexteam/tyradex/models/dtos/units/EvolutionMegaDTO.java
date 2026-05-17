package tyradexteam.tyradex.models.dtos.units;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tyradexteam.tyradex.models.dtos.NameDTO;

/**
 * Class to represent the Mega Evolution of a Pokemon, with its name, the orbe needed to evolve and its sprites.
 */
@Getter
@Setter
@Builder
public class EvolutionMegaDTO {
    /**
     * The name of the orbe for the mega evolution of a Pokemon
     */
    @JsonProperty("orbe")
    private String orbe;

    /**
     * The name of the mega-evolution in different languages
     */
    @JsonProperty("name")
    private NameDTO name;

    /**
     * Sprites of the Mega Evolution of a Pokemon
     */
    @JsonProperty("sprites")
    private SpriteUnitDTO sprites;

}
