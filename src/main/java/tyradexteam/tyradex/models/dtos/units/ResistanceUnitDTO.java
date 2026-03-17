package tyradexteam.tyradex.models.dtos.units;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tyradexteam.tyradex.models.dtos.NameDTO;

/**
 * La classe ResistanceUnitDTO représente une unité de résistance d'un personnage dans le jeu.
 * Elle contient le nom de la résistance et son multiplicateur.
 */
@Getter
@Setter
@Builder
public class ResistanceUnitDTO {
    /**
     * Le nom de la résistance, représenté par un objet NameDTO qui contient
     * les noms de la résistance dans différentes langues (français, anglais, japonais).
     */
    @JsonProperty("name")
    private NameDTO name;

    /**
     * Le multiplicateur de la résistance, qui indique à quel point le personnage est résistant
     * à un certain type d'attaque (par exemple, 0.5 pour une résistance normale, 0 pour une immunité, etc.).
     */
    @JsonProperty("multiplier")
    private Number multiplier;
}
