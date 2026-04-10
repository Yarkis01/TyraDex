package tyradexteam.tyradex.models.dtos.units;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import tyradexteam.tyradex.models.dtos.PokemonDTO;

/**
 * Représente une unité d'évolution, qui peut être un personnage ou une arme.
 */
@Getter
@Setter
@Builder
public class EvolutionUnitDTO {
    /**
     * La condition d'évolution, qui peut être une condition de niveau, d'objet, de lieu, etc.
     * Cette propriété est optionnelle et peut être nulle si l'évolution ne nécessite pas de condition spécifique.
     */
    private String condition;

    /**
     * Le Pokémon associé à cette unité d'évolution, représenté par un objet PokemonDTO.
     */
    @JsonUnwrapped
    @JsonIgnoreProperties({"level_100", "catch_rate", "egg_groups", "height", "weight", "evolution", "resistances","talents","stats"})
    private PokemonDTO pokemon;
}
