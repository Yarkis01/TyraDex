package tyradexteam.tyradex.models.dtos;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tyradexteam.tyradex.models.dtos.units.EvolutionMegaDTO;
import tyradexteam.tyradex.models.dtos.units.EvolutionUnitDTO;

import java.util.List;

/**
 * Element which represents all evolutions of a Pokemon
 */
@Getter
@Setter
@Builder
public class EvolutionDTO {
    /**
     * List of pre-evolutions of a Pokemon
     */
    private List<EvolutionUnitDTO> pre;
    /**
     * List of next evolutions of a Pokemon
     */
    private List<EvolutionUnitDTO> next;
    /**
     * List of mega evolutions of a Pokemon
     */
    private List<EvolutionMegaDTO> mega;
}
