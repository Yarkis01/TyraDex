package tyradexteam.tyradex.services.mapper;

import tyradexteam.tyradex.models.Type;
import tyradexteam.tyradex.models.dtos.NameDTO;
import tyradexteam.tyradex.models.dtos.TypeDTO;
import tyradexteam.tyradex.models.dtos.TypePokemon;

import java.util.List;

/**
 * Mapper to convert Type entities to TypeDTOs. This class provides methods to transform a list of Type objects into a list of TypeDTO objects, as well as a method to convert a single Type object into a TypePokemon enum value.
 */
public class TypeMapper {
    /**
     * Method to convert a list of Type entities into a list of TypeDTOs. This method takes a list of Type objects, maps each Type to a TypeDTO by extracting the relevant information (the names of the type in different languages and the image), and returns a list of TypeDTOs.
     * @param types The list of Type entities to be converted into DTOs. Each Type in the list will be transformed into a TypeDTO, which contains a NameDTO with the names of the type in French, English, and Japanese, as well as an image URL representing the type.
     * @return A list of TypeDTO objects that correspond to the provided list of Type entities. Each TypeDTO contains a NameDTO with the names of the type in different languages, and an image URL representing the type, based on the properties of the Type entities.
     */
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

    /**
     * Method to convert a single Type entity into a TypePokemon enum value. This method takes a Type object, extracts the French name of the type, and converts it into a corresponding TypePokemon enum value using the fromString method.
     * @param type The Type entity to be converted into a TypePokemon enum value. The method extracts the French name of the type from the Type object and uses it to determine the corresponding TypePokemon enum value.
     * @return A TypePokemon enum value that corresponds to the provided Type entity. The enum value is determined based on the French name of the type extracted from the Type object, using the fromString method of the TypePokemon enum.
     */
    public static TypePokemon toDto(Type type){
        return TypePokemon.fromString(type.getNameFr());
    }
}
