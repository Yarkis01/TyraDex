package tyradexteam.tyradex.models.dtos.units;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tyradexteam.tyradex.models.dtos.PokemonDTO;

/**
 * Class to represent an evolution of a Pokemon, with its condition and the Pokemon associated to this evolution.
 */
@Getter
@Setter
@Builder
public class EvolutionUnitDTO {

    /**
     * Condition of evolution, which can be a level, an item, a location, etc. It describes how the Pokémon evolves to the next stage.
     */
    private String condition;

    /**
     * The pokemon associated to the evolution.
     */
    @JsonUnwrapped
    @JsonIgnoreProperties({"level_100", "catch_rate", "egg_groups", "height", "weight", "evolution", "resistances","talents","stats"})
    private PokemonDTO pokemon;
}
