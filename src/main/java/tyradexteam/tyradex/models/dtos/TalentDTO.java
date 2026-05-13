package tyradexteam.tyradex.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity representing a talent of a Pokemon, which includes its name and whether it is a hidden talent (tc = true) or not (tc = false).
 */
@Getter
@Setter
@Builder
public class TalentDTO {
    /**
     * Name of the talent in different languages (French, English, Japanese)
     */
    @JsonProperty("name")
    private NameDTO name;

    /**
     * If the talent is an hidden talent (tc = true) or not (tc = false)
     */
    @JsonProperty("tc")
    private Boolean tc;
}
