package tyradexteam.tyradex.services.mapper;

import tyradexteam.tyradex.models.EggGroup;
import tyradexteam.tyradex.models.dtos.EggGroupDTO;
import tyradexteam.tyradex.models.dtos.NameDTO;

import java.util.List;

/**
 * Mapper to convert EggGroup entities to EggGroupDTOs. This class provides a method to transform a list of EggGroup
 * objects into a list of EggGroupDTO objects, which are used for data transfer in the application.
 */
public class EggGroupMapper {
    /**
     * Method to convert a list of EggGroup entities into a list of EggGroupDTOs. This method takes a list of EggGroup objects,
     * maps each EggGroup to an EggGroupDTO by extracting the relevant information (in this case, the French name), and returns a list of EggGroupDTOs.
     * @param eggGroups The list of EggGroup entities to be converted into DTOs. Each EggGroup in the list will be transformed into an EggGroupDTO, which contains a NameDTO with the French name of the EggGroup.
     * @return A list of EggGroupDTO objects that correspond to the provided list of EggGroup entities.
     * Each EggGroupDTO contains a NameDTO with the French name of the EggGroup, while the English and Japanese names are set to null in this implementation.
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
