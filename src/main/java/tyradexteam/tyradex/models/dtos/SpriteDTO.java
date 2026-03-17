package tyradexteam.tyradex.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tyradexteam.tyradex.models.dtos.units.SpriteUnitDTO;

/**
 * Représente les sprites d'un personnage dans le jeu, avec les versions régulières et brillantes (shiny).
 */
@Getter
@Setter
@Builder
public class SpriteDTO {
    /**
     * Les sprites réguliers et brillants (shiny) d'un personnage, représentés par un objet SpriteUnitDTO
     * qui contient les URL des images correspondantes.
     */
    @JsonUnwrapped
    private SpriteUnitDTO sprites;

    /**
     * Les sprites de la forme Gigamax d'un personnage, représentés par un objet SpriteUnitDTO
     * qui contient les URL des images correspondantes. Cette propriété est optionnelle
     * et peut être nulle si le personnage n'a pas de forme Gigamax.
     */
    @JsonProperty("gmax")
    private SpriteUnitDTO gmax;
}
