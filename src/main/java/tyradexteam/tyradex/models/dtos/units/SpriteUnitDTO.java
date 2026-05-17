package tyradexteam.tyradex.models.dtos.units;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity representing a sprite unit, which includes regular and shiny versions of the sprite.
 */
@Getter
@Setter
@Builder
public class SpriteUnitDTO {

    /**
     * Represent the regular sprite of the entity
     */
    @JsonProperty("regular")
    private String regular;

    /**
     * Represent the shiny sprite of the entity
     */
    @JsonProperty("shiny")
    private String shiny;
}
