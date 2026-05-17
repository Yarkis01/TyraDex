package tyradexteam.tyradex.models.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
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
     * Generation where the talent was appeared.
     */
    @JsonProperty("generation")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer generation;

    /**
     * If the talent is an hidden talent (tc = true) or not (tc = false)
     */
    @JsonProperty("tc")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Boolean tc;

    /**
     * Effect of the talent on the stadium, can be null
     */
    @JsonProperty("effet_terrain")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String effectTerrain;

    /**
     * Effect of the talent in the fight, can be null
     */
    @JsonProperty("effet_combat")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String effectFight;
}
