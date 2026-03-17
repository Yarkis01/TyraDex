package tyradexteam.tyradex.models.dtos.units;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SpriteUnitDTO {
    /**
     * L'URL du sprite régulier du personnage.
     */
    @JsonProperty("regular")
    private String regular;

    /**
     * L'URL du sprite brillant (shiny) du personnage.
     */
    @JsonProperty("shiny")
    private String shiny;
}
