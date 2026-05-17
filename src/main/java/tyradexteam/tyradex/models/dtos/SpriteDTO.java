package tyradexteam.tyradex.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tyradexteam.tyradex.models.dtos.units.SpriteUnitDTO;

/**
 * Sprites of a Pokemon
 */
@Getter
@Setter
@Builder
public class SpriteDTO {
    /**
     * Basics sprites
     */
    @JsonUnwrapped
    private SpriteUnitDTO sprites;

    /**
     * Gmax sprites if there is a Gmax form for the Pokemon
     */
    @JsonProperty("gmax")
    private SpriteUnitDTO gmax;
}
