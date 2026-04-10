package tyradexteam.tyradex.services.mapper;

import tyradexteam.tyradex.models.Pokemon;
import tyradexteam.tyradex.models.dtos.NameDTO;
import tyradexteam.tyradex.models.dtos.PokemonDTO;
import tyradexteam.tyradex.models.dtos.SpriteDTO;
import tyradexteam.tyradex.models.dtos.StatDTO;
import tyradexteam.tyradex.models.dtos.units.SpriteUnitDTO;
import tyradexteam.tyradex.services.utils.ResistanceUtil;

import java.util.List;

/**
 * Mapper to convert Pokemon entities to PokemonDTOs. This class provides methods to transform a Pokemon object into a PokemonDTO, which is used for data transfer in the application.
 */
public class PokemonMapper {
    /**
     * Method to convert a Pokemon entity into a PokemonDTO. This method takes a Pokemon object, extracts the relevant information, and constructs a PokemonDTO with the corresponding data. The method also utilizes the ResistanceUtil to calculate the resistances based on the Pokemon's types.
     * @param pokemon The Pokemon entity to be converted into a DTO. The method extracts various properties from the Pokemon object, such as its Pokedex ID, generation, names in different languages, sprites, types, talents, stats, resistances, evolutions, height, weight, catch rate, level 100 stats, and egg groups. The resulting PokemonDTO is built using a builder pattern and contains all the relevant information for data transfer.
     * @return A PokemonDTO object that corresponds to the provided Pokemon entity. The DTO contains all the relevant information extracted from the Pokemon object, including its Pokedex ID, generation, names, sprites, types, talents, stats, resistances, evolutions, height, weight, catch rate, level 100 stats, and egg groups. The resistances are calculated using the ResistanceUtil based on the Pokemon's types.
     */
    public static PokemonDTO toDTO(Pokemon pokemon) {
        ResistanceUtil resistanceUtil = new ResistanceUtil();
        return PokemonDTO.builder()
            .pokedexId(pokemon.getPokedexId())
            .generation(pokemon.getGeneration())
            .name(NameDTO.builder().fr(pokemon.getNameFr()).en(pokemon.getNameEn()).jp(pokemon.getNameJp()).build())
            .sprites(SpriteDTO.builder().sprites(
                    SpriteUnitDTO.builder()
                            .regular(pokemon.getSpriteRegular())
                            .shiny(pokemon.getSpriteShiny())
                            .build())
                    .gmax(null)
                    .build())
            .types(TypeMapper.toDto(pokemon.getTypes()))
            .talents(TalentMapper.toDto(pokemon.getTalents()))
            .stats(StatDTO.builder()
                .hp(pokemon.getHp())
                .atk(pokemon.getAttack())
                .def(pokemon.getDefense())
                .spAtk(pokemon.getSpecialAttack())
                .spDef(pokemon.getSpecialDefense())
                .speed(pokemon.getSpeed())
                .build())
            .resistances(!pokemon.getTypes().isEmpty() ? resistanceUtil.getResistances(
                     TypeMapper.toDto(
                        pokemon.getTypes().get(0)),
                        pokemon.getTypes().size() > 1 ? TypeMapper.toDto(pokemon.getTypes().get(1)) : null)
                    : null)
            .evolution(EvolutionMapper.toDto(pokemon.getPreviousEvolutions(), pokemon.getNextEvolutions()))
            .height(pokemon.getHeight())
            .weight(pokemon.getWeight())
            .catchRate(pokemon.getCatchRate())
            .level100(pokemon.getLevel_100())
            .eggGroups(EggGroupMapper.toDto(pokemon.getEggGroups()))
            .build();
    }

    /**
     * Method to convert a Pokemon entity into a "light" version of PokemonDTO. This method takes a Pokemon object and constructs a PokemonDTO with only the essential information, excluding certain details such as resistances and evolutions. The resulting DTO is built using a builder pattern and contains the basic information about the Pokemon, such as its Pokedex ID, generation, names, sprites, types, talents, stats, height, weight, catch rate, level 100 stats, and egg groups.
     * @param pokemon The Pokemon entity to be converted into a "light" version of PokemonDTO. The method extracts only the essential information from the Pokemon object, such as its Pokedex ID, generation, names in different languages, sprites, types, talents, stats, height, weight, catch rate, level 100 stats, and egg groups. The resulting PokemonDTO is built using a builder pattern and contains only the basic information about the Pokemon, while excluding details such as resistances and evolutions.
     * @return A "light" version of PokemonDTO that corresponds to the provided Pokemon entity. The DTO contains only the essential information extracted from the Pokemon object, including its Pokedex ID, generation, names, sprites, types, talents, stats, height, weight, catch rate, level 100 stats, and egg groups. The resistances and evolutions are intentionally excluded from this version of the DTO to provide a simplified representation of the Pokemon's data for certain use cases where detailed information is not necessary.
     */
    public static PokemonDTO toDTOLight(Pokemon pokemon) {
        return PokemonDTO.builder()
                .pokedexId(pokemon.getPokedexId())
                .generation(pokemon.getGeneration())
                .name(NameDTO.builder().fr(pokemon.getNameFr()).en(pokemon.getNameEn()).jp(pokemon.getNameJp()).build())
                .sprites(SpriteDTO.builder().sprites(
                                SpriteUnitDTO.builder()
                                        .regular(pokemon.getSpriteRegular())
                                        .shiny(pokemon.getSpriteShiny())
                                        .build())
                        .gmax(null)
                        .build())
                .types(TypeMapper.toDto(pokemon.getTypes()))
                .talents(TalentMapper.toDto(pokemon.getTalents()))
                .stats(StatDTO.builder()
                        .hp(pokemon.getHp())
                        .atk(pokemon.getAttack())
                        .def(pokemon.getDefense())
                        .spAtk(pokemon.getSpecialAttack())
                        .spDef(pokemon.getSpecialDefense())
                        .speed(pokemon.getSpeed())
                        .build())
                .evolution(null)
                .height(pokemon.getHeight())
                .weight(pokemon.getWeight())
                .catchRate(pokemon.getCatchRate())
                .level100(pokemon.getLevel_100())
                .eggGroups(EggGroupMapper.toDto(pokemon.getEggGroups()))
            .build();
    }

    public static PokemonDTO toDtoMinimal(Pokemon pokemon){
        return PokemonDTO.builder()
                .pokedexId(pokemon.getPokedexId())
                .generation(pokemon.getGeneration())
                .name(NameDTO.builder().fr(pokemon.getNameFr()).en(pokemon.getNameEn()).jp(pokemon.getNameJp()).build())
                .sprites(
                    SpriteDTO.builder().sprites(
                        SpriteUnitDTO.builder()
                            .regular(pokemon.getSpriteRegular())
                            .shiny(pokemon.getSpriteShiny())
                            .build())
                    .gmax(null)
                    .build())
                .evolution(EvolutionMapper.toDto(pokemon.getPreviousEvolutions(), pokemon.getNextEvolutions()))
                .types(TypeMapper.toDto(pokemon.getTypes()))
            .build();
    }

    /**
     * Method to convert a list of Pokemon entities into a list of PokemonDTOs. This method takes a list of Pokemon objects, maps each Pokemon to a PokemonDTO using the toDTO method, and returns a list of PokemonDTOs. The resulting list contains the DTO representations of all the Pokemon entities provided in the input list.
     * @param pokemons The list of Pokemon entities to be converted into DTOs. Each Pokemon in the list will be transformed into a PokemonDTO using the toDTO method, which extracts the relevant information from each Pokemon object and constructs a corresponding PokemonDTO. The resulting list of PokemonDTOs will contain the DTO representations of all the Pokemon entities provided in the input list, allowing for data transfer and representation in a format suitable for various use cases within the application.
     * @return A list of PokemonDTO objects that correspond to the provided list of Pokemon entities. Each Pokemon in the input list is transformed into a PokemonDTO using the toDTO method, resulting in a list of DTOs that contain the relevant information extracted from each Pokemon object. This allows for efficient data transfer and representation of multiple Pokemon entities in a format suitable for various use cases within the application.
     */
    public static List<PokemonDTO> toDTO(List<Pokemon> pokemons) {
        return pokemons.stream().map(PokemonMapper::toDTO).toList();
    }

    public static List<PokemonDTO> toDtoMinimal(List<Pokemon> pokemons){
        return pokemons.stream().map(PokemonMapper::toDtoMinimal).toList();
    }
}
