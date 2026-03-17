package tyradexteam.tyradex.services.mapper;

import tyradexteam.tyradex.models.Pokemon;
import tyradexteam.tyradex.models.dtos.NameDTO;
import tyradexteam.tyradex.models.dtos.PokemonDTO;
import tyradexteam.tyradex.models.dtos.SpriteDTO;
import tyradexteam.tyradex.models.dtos.StatDTO;
import tyradexteam.tyradex.models.dtos.units.SpriteUnitDTO;

import java.util.List;

/**
 * Mapper pour convertir les entités Pokemon en DTO PokemonDTO.
 */
public class PokemonMapper {
    /**
     * Convertit une entité Pokemon en un DTO PokemonDTO.
     * @param pokemon L'entité Pokemon à convertir.
     * @return Le DTO PokemonDTO correspondant à l'entité Pokemon fournie.
     */
    public static PokemonDTO toDTO(Pokemon pokemon) {
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
            .evolution(EvolutionMapper.toDto(pokemon.getPreviousEvolutions(), pokemon.getNextEvolutions()))
            .height(pokemon.getHeight())
            .weight(pokemon.getWeight())
            .catchRate(pokemon.getCatchRate())
            .level100(pokemon.getLevel_100())
            .eggGroups(EggGroupMapper.toDto(pokemon.getEggGroups()))
            .build();
    }

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

    public static List<PokemonDTO> toDTO(List<Pokemon> pokemons) {
        return pokemons.stream().map(PokemonMapper::toDTO).toList();
    }
}
