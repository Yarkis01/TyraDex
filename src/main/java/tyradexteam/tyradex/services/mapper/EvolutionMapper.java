package tyradexteam.tyradex.services.mapper;

import tyradexteam.tyradex.models.EvolutionRelationship;
import tyradexteam.tyradex.models.dtos.EvolutionDTO;
import tyradexteam.tyradex.models.dtos.units.EvolutionUnitDTO;

import java.util.List;

/**
 * Mapper pour convertir les entités EvolutionRelationship en DTO EvolutionDTO, qui contient les informations sur les évolutions d'un Pokémon.
 * La classe EvolutionMapper gère la conversion des listes d'évolutions précédentes et suivantes d'un Pokémon
 * en une structure de données plus adaptée pour l'API, en utilisant des DTO spécifiques
 * pour représenter les conditions d'évolution et les informations associées à chaque évolution.
 */
public class EvolutionMapper {
    /**
     * Convertit les listes d'entités EvolutionRelationship représentant les évolutions précédentes et suivantes d'un Pokémon
     * @param previous La liste des évolutions précédentes d'un Pokémon, représentée par des entités EvolutionRelationship.
     * @param next La liste des évolutions suivantes d'un Pokémon, représentée par des entités EvolutionRelationship.
     * @return Un DTO EvolutionDTO qui contient les informations sur les évolutions précédentes et suivantes du Pokémon,
     * avec les conditions d'évolution et les informations associées à chaque évolution.
     */
    public static EvolutionDTO toDto(List<EvolutionRelationship> previous, List<EvolutionRelationship> next) {
        return EvolutionDTO.builder()
                .pre(manageListOfEvolutions(previous))
                .post(manageListOfEvolutions(next))
                // Todo : gestion des méga évolutions, pas encore géré !
                .build();
    }

    /**
     * Gère les évolutions d'un Pokémon en convertissant une liste d'entités EvolutionRelationship en une liste de DTO EvolutionUnitDTO.
     * @param previous La liste des évolutions d'un Pokémon, représentée par des entités EvolutionRelationship.
     * @return Une liste de DTO EvolutionUnitDTO correspondant aux évolutions du Pokémon, où chaque DTO contient la condition d'évolution et les informations du Pokémon associé.
     */
    private static List<EvolutionUnitDTO> manageListOfEvolutions(List<EvolutionRelationship> previous) {
        return previous.stream().map(
                er -> {
                    return EvolutionUnitDTO.builder()
                            .condition(er.getCondition())
                            .pokemon(PokemonMapper.toDTOLight(er.getPokemon()))
                            .build();
                }
        ).toList();
    }


}
