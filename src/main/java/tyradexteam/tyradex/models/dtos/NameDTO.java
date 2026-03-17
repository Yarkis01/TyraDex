package tyradexteam.tyradex.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Représente les noms d'une entité dans différentes langues (français, anglais, japonais).
 */
@Getter
@Setter
@Builder
public class NameDTO {
    @JsonProperty("fr")
    private String fr;

    @JsonProperty("en")
    private String en;

    @JsonProperty("jp")
    private String jp;
}
