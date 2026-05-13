package tyradexteam.tyradex.models.dtos.units;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tyradexteam.tyradex.models.dtos.NameDTO;

/**
 * Entity representing a resistance with the name of the type, and the multiplier of the resistance.
 */
@Getter
@Setter
@Builder
public class ResistanceUnitDTO {

    /**
     * Name of the type of the resistance.
     */
    @JsonProperty("name")
    private NameDTO name;

    /**
     * Multiplier (0, 0.25, 0.5, 1, 1.5, 2, 4) of the resistance.
     */
    @JsonProperty("multiplier")
    private Number multiplier;
}
