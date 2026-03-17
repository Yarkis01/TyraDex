package tyradexteam.tyradex.services.mapper;

import tyradexteam.tyradex.models.Type;
import tyradexteam.tyradex.models.dtos.NameDTO;
import tyradexteam.tyradex.models.dtos.TypeDTO;

import java.util.List;

/**
 * Mapper pour convertir les entités Type en DTO TypeDTO.
 */
public class TypeMapper {
    public static List<TypeDTO> toDto(List<Type> types) {
        return types.stream().map(
                t -> {
                    return TypeDTO.builder()
                        .name(NameDTO.builder()
                                .fr(t.getNameFr())
                                .en(t.getNameEn())
                                .jp(t.getNameJp())
                                .build())
                        .image(t.getImage())
                        .build();
                    }
        ).toList();
    }
}
