package tyradexteam.tyradex.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * DTO representing a Pokemon generation with its Pokedex ID range.
 */
@Getter
@Setter
@AllArgsConstructor
@JsonPropertyOrder({"generation", "from", "to"})
public class GenerationInfoDTO {

    /**
     * The generation number (1–9).
     */
    @JsonProperty("generation")
    private Integer generation;

    /**
     * The first Pokedex ID of this generation.
     */
    @JsonProperty("from")
    private Integer from;

    /**
     * The last Pokedex ID of this generation.
     */
    @JsonProperty("to")
    private Integer to;
}
