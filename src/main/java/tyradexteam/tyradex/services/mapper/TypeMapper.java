package tyradexteam.tyradex.services.mapper;

import tyradexteam.tyradex.models.Type;
import tyradexteam.tyradex.models.dtos.NameDTO;
import tyradexteam.tyradex.models.dtos.TypeDTO;
import tyradexteam.tyradex.models.dtos.TypePokemon;

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

    public static TypePokemon toDto(Type type){
        return TypePokemon.fromString(type.getNameFr());
    }
}
