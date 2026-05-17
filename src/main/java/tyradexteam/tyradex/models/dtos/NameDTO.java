package tyradexteam.tyradex.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity representing a name of something (Pokemon, talent, etc...) in different languages (French, English, Japanese).
 */
@Getter
@Setter
@Builder
public class NameDTO {
    /**
     * Name in French
     */
    @JsonProperty("fr")
    private String fr;

    /**
     * Name in English
     */
    @JsonProperty("en")
    private String en;

    /**
     * Name in Japanese
     */
    @JsonProperty("jp")
    private String jp;
}
