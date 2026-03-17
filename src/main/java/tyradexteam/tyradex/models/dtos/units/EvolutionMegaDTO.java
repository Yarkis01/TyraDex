package tyradexteam.tyradex.models.dtos.units;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * La classe EvolutionMegaDTO représente les informations spécifiques à l'évolution méga d'un personnage dans le jeu.
 * Elle contient une propriété "orbe" qui indique l'orbe nécessaire pour effectuer l'évolution méga.
 */
@Getter
@Setter
@Builder
public class EvolutionMegaDTO {
    @JsonProperty("orbe")
    private String orbe;


}
