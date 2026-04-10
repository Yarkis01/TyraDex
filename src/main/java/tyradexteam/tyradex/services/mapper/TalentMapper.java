package tyradexteam.tyradex.services.mapper;

import tyradexteam.tyradex.models.Talent;
import tyradexteam.tyradex.models.TalentRelationship;
import tyradexteam.tyradex.models.dtos.NameDTO;
import tyradexteam.tyradex.models.dtos.TalentDTO;

import java.util.List;

/**
 * Mapper to convert TalentRelationship entities to TalentDTOs. This class provides a method to transform a list of TalentRelationship
 * objects into a list of TalentDTO objects, which are used for data transfer in the application.
 * Each TalentDTO contains a NameDTO with the names of the talent in different languages, as well as a boolean indicating whether the talent is hidden or not.
 */
public class TalentMapper {
    /**
     * Method to convert a list of TalentRelationship entities into a list of TalentDTOs. This method takes a list of TalentRelationship objects,
     * maps each TalentRelationship to a TalentDTO by extracting the relevant information (the names of the talent in different languages and whether it is hidden), and returns a list of TalentDTOs.
     * @param talents The list of TalentRelationship entities to be converted into DTOs. Each TalentRelationship in the list will be transformed into a TalentDTO, which contains a NameDTO with the names of the talent in French, English, and Japanese, as well as a boolean indicating whether the talent is hidden or not.
     * @return A list of TalentDTO objects that correspond to the provided list of TalentRelationship entities. Each TalentDTO contains a NameDTO with the names of the talent in different languages, and a boolean indicating whether the talent is hidden or not, based on the properties of the TalentRelationship entities.
     */
    public static List<TalentDTO> toDto(List<TalentRelationship> talents) {
        return talents.stream().map(
            tr -> TalentDTO.builder()
                .name(NameDTO.builder()
                        .fr(tr.getTalent().getNameFr())
                        .en(tr.getTalent().getNameEn())
                        .jp(tr.getTalent().getNameJp())
                    .build())
                .tc(tr.getHidden())
            .build()
        ).toList();
    }

    public static TalentDTO toDto(Talent talent) {
        return TalentDTO.builder()
                .name(NameDTO.builder()
                        .fr(talent.getNameFr())
                        .en(talent.getNameEn())
                        .jp(talent.getNameJp())
                    .build())
                .build();
    }

}
