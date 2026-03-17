package tyradexteam.tyradex.services.mapper;

import tyradexteam.tyradex.models.EggGroup;
import tyradexteam.tyradex.models.dtos.EggGroupDTO;
import tyradexteam.tyradex.models.dtos.NameDTO;

import java.util.List;

/**
 * Mapper pour convertir les entités EggGroup en DTO EggGroupDTO.
 */
public class EggGroupMapper {
    /**
     * Convertis une liste d'entités EggGroup en une liste de DTO EggGroupDTO.
     * @param eggGroups La liste d'entités EggGroup à convertir
     * @return Une liste de DTO EggGroupDTO correspondant aux entités fournies
     */
    public static List<EggGroupDTO> toDto(List<EggGroup> eggGroups){
        return eggGroups.stream()
                .map(eggGroup -> new EggGroupDTO(
                        NameDTO.builder()
                                .fr(eggGroup.getNameFr())
                                .en(null)
                                .jp(null)
                        .build()))
                .toList();
    }
}
