package tyradexteam.tyradex.services.mapper;

import org.springframework.stereotype.Service;
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
@Service
public class TalentMapper {

    /**
     * Convert a talent to a DTO to represent it, with a lot of informations about each them
     * @param talent The talent to convert to DTO
     * @return DTO which represents the talent
     */
    public TalentDTO toDto(Talent talent) {
        return TalentDTO.builder()
                .name(NameDTO.builder()
                        .fr(talent.getNameFr())
                        .en(talent.getNameEn())
                        .jp(talent.getNameJp())
                    .build())
                .generation(talent.getGeneration())
                .effectFight(talent.getEffectFight())
                .effectTerrain(talent.getEffectStadium())
                .build();
    }

    /**
     * Convert a talent to a DTO which corresponds to the link between a Pokemon and a talent
     * @param talents The list of talents to convert to DTO, which are the talents of a Pokemon with the information about whether they are hidden or not
     * @return The list of talent DTO which corresponds to the list of talents of a Pokemon, with the information about whether they are hidden or not
     */
    public List<TalentDTO> toPokemonDto(List<TalentRelationship> talents) {
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

    /**
     * Method to convert a talent entity to a talent DTO for a Pokemon.
     * @param talent The talent to convert to DTO
     * @return The talent DTO which corresponds to the entity
     */
    public TalentDTO toPokemonDto(Talent talent) {
        return TalentDTO.builder()
                .name(NameDTO.builder()
                        .fr(talent.getNameFr())
                        .en(talent.getNameEn())
                        .jp(talent.getNameJp())
                    .build())
                .build();
    }

}
