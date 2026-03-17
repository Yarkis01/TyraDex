package tyradexteam.tyradex.services.mapper;

import tyradexteam.tyradex.models.TalentRelationship;
import tyradexteam.tyradex.models.dtos.NameDTO;
import tyradexteam.tyradex.models.dtos.TalentDTO;

import java.util.List;

/**
 * Mapper pour convertir les entités TalentRelationship en DTO TalentDTO.
 */
public class TalentMapper {
    /**
     * Convertit une liste d'entités TalentRelationship en une liste de DTO TalentDTO.
     * @param talents La liste d'entités TalentRelationship à convertir.
     * @return La liste de DTO TalentDTO correspondant aux entités TalentRelationship fournies.
     */
    public static List<TalentDTO> toDto(List<TalentRelationship> talents) {
        return talents.stream().map(
                tr -> {
                    return TalentDTO.builder()
                        .name(NameDTO.builder()
                                .fr(tr.getTalent().getNameFr())
                                .en(tr.getTalent().getNameEn())
                                .jp(tr.getTalent().getNameJp())
                            .build())
                        .tc(tr.getHidden())
                    .build();
                }
        ).toList();
    }
}
