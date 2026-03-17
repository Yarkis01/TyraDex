package tyradexteam.tyradex.models.dtos.units;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tyradexteam.tyradex.models.dtos.NameDTO;

/**
 * La classe EvolutionMegaDTO représente les informations spécifiques à l'évolution méga d'un personnage dans le jeu.
 * Elle contient une propriété "orbe" qui indique l'orbe nécessaire pour effectuer l'évolution méga.
 */
@Getter
@Setter
@Builder
public class EvolutionMegaDTO {
    /**
     * L'orbe nécessaire pour effectuer la méga évolution d'un Pokémon.
     */
    @JsonProperty("orbe")
    private String orbe;

    /**
     * Le nom de la méga évolution, représenté par un objet NameDTO qui contient les noms de la méga évolution
     * dans différentes langues (français, anglais, japonais).
     */
    @JsonProperty("name")
    private NameDTO name;

    /**
     * Les sprites de la méga évolution, représentés par un objet SpriteUnitDTO qui contient les différentes images
     * de la méga évolution (régulière, shiny, etc.).
     */
    @JsonProperty("sprites")
    private SpriteUnitDTO sprites;

}
