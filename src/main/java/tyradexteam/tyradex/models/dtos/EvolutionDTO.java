package tyradexteam.tyradex.models.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tyradexteam.tyradex.models.dtos.units.EvolutionMegaDTO;
import tyradexteam.tyradex.models.dtos.units.EvolutionUnitDTO;

import java.util.List;

/**
 * DTO représentant les évolutions d'un Pokémon, incluant les pré-évolutions, les post-évolutions et les évolutions méga.
 */
@Getter
@Setter
@Builder
public class EvolutionDTO {
    /**
     * Liste des pré-évolutions du Pokémon.
     */
    private List<EvolutionUnitDTO> pre;
    /**
     * Liste des post-évolutions du Pokémon.
     */
    private List<EvolutionUnitDTO> post;
    /**
     * Liste des évolutions méga du Pokémon.
     */
    private List<EvolutionMegaDTO> mega;
}
