package tyradexteam.tyradex.services.mapper;

import tyradexteam.tyradex.models.EvolutionRelationship;
import tyradexteam.tyradex.models.dtos.EvolutionDTO;
import tyradexteam.tyradex.models.dtos.units.EvolutionUnitDTO;

import java.util.List;

/**
 * La classe EvolutionMapper est responsable de la conversion des objets EvolutionRelationship en objets EvolutionDTO.
 * Elle contient une méthode toDto qui prend en entrée deux listes d'EvolutionRelationship (une pour les pré-évolutions et une pour les post-évolutions)
 * et retourne un objet EvolutionDTO contenant les informations correspondantes. La méthode manageListOfEvolutions est utilisée
 * pour convertir une liste d'EvolutionRelationship en une liste d'EvolutionUnitDTO, qui est ensuite utilisée pour construire l'objet EvolutionDTO.
 */
public class EvolutionMapper {
    /**
     * Convertit les listes d'EvolutionRelationship en un objet EvolutionDTO. La méthode toDto prend en entrée deux listes d'EvolutionRelationship,
     * une pour les pré-évolutions et une pour les post-évolutions, et utilise la méthode manageListOfEvolutions pour convertir chacune de ces listes en une liste d'EvolutionUnitDTO.
     * @param previous La liste des pré-évolutions, représentée par une liste d'objets EvolutionRelationship.
     * @param next La liste des post-évolutions, représentée par une liste d'objets EvolutionRelationship.
     * @return Un objet EvolutionDTO contenant les pré-évolutions et les post-évolutions converties en listes d'EvolutionUnitDTO.
     */
    public static EvolutionDTO toDto(List<EvolutionRelationship> previous, List<EvolutionRelationship> next) {
        return EvolutionDTO.builder()
                .pre(manageListOfEvolutions(previous))
                .post(manageListOfEvolutions(next))
                // Todo : gestion des méga évolutions, pas encore géré !
                .build();
    }

    /**
     * Convertit une liste d'EvolutionRelationship en une liste d'EvolutionUnitDTO. La méthode manageListOfEvolutions prend en entrée une liste d'EvolutionRelationship
     * et utilise un stream pour parcourir chaque élément de la liste, en créant un nouvel objet EvolutionUnitDTO pour chaque EvolutionRelationship.
     * @param previous La liste des EvolutionRelationship à convertir, qui peut représenter soit les pré-évolutions soit les post-évolutions.
     * @return Une liste d'EvolutionUnitDTO, où chaque élément correspond à un EvolutionRelationship de la liste d'entrée, avec les propriétés condition et pokemon correctement mappées.
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
