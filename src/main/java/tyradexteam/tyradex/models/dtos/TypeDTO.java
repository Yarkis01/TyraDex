package tyradexteam.tyradex.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Type of a Pokemon with the name, and the image of the type (for example, the image of the fire type is a flame).
 */
@Getter
@Setter
@Builder
public class TypeDTO {
    /**
     * Name of the type (in different languages)
     */
    @JsonProperty("name")
    private NameDTO name;

    /**
     * The image of the type (for example, the image of the fire type is a flame)
     */
    @JsonProperty("image")
    private String image;
}
