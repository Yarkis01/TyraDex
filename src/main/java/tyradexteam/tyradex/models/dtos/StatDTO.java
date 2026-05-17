package tyradexteam.tyradex.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity representing a stat of a Pokemon
 */
@Getter
@Setter
@Builder
public class StatDTO {
    /**
     * Heal point of the Pokemon
     */
    @JsonProperty("hp")
    private Integer hp;

    /**
     * Attack of the Pokemon
     */
    @JsonProperty("atk")
    private Integer atk;

    /**
     * Defense of the Pokemon
     */
    @JsonProperty("def")
    private Integer def;

    /**
     * Special attack of the Pokemon
     */
    @JsonProperty("spe_atk")
    private Integer spAtk;

    /**
     * Special defense of the Pokemon
     */
    @JsonProperty("spe_def")
    private Integer spDef;

    /**
     * Speed of the Pokemon
     */
    @JsonProperty("vit")
    private Integer speed;
}
