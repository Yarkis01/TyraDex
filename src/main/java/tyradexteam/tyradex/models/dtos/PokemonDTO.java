package tyradexteam.tyradex.models.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Entity representing a full Pokemon with all relationships.
 */
@Builder
@Getter
@Setter
@JsonPropertyOrder({
    "pokedex_id",
    "generation",
    "order",
    "name",
    "category",
    "types",
    "sprites",
    "talents",
    "resistances",
    "stats",
    "evolution",
    "egg_groups",
    "height",
    "weight",
    "catch_rate",
    "level_100"
})
public class PokemonDTO {

    /**
     * The id of the Pokemon in the national pokedex
     */
    @JsonProperty("pokedex_id")
    private Integer pokedexId;

    /**
     * The generation of the Pokemon
     */
    @JsonProperty("generation")
    private Integer generation;

    /**
     * The name of the Pokemon
     */
    @JsonProperty("name")
    private NameDTO name;

    /**
     * Category of the Pokemon
     */
    @JsonProperty("category")
    private String category;

    /**
     * The sprites (regular, shiny) of the Pokemon
     */
    @JsonProperty("sprites")
    private SpriteDTO sprites;

    /**
     * Types of the Pokemons (1 or 2)
     */
    @JsonProperty("types")
    private List<TypeDTO> types;

    /**
     * The state of evolution of the Pokemon (1, 2, 3 or null)
     */
    @JsonProperty("order")
    private Integer order;

    /**
     * Talents for the Pokemon if not null
     */
    @JsonProperty("talents")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<TalentDTO> talents;

    /**
     * Stats of the Pokemon
     */
    @JsonProperty("stats")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private StatDTO stats;

    /**
     * Resistances of the Pokemon
     */
    @JsonProperty("resistances")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonUnwrapped
    private ResistanceDTO resistances;

    /**
     * All evolutions of the Pokemon (pre, next, mega)
     */
    @JsonProperty("evolution")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private EvolutionDTO evolution;

    /**
     * The height of the Pokemon
     */
    @JsonProperty("height")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String height;

    /**
     * The weight of the Pokemon
     */
    @JsonProperty("weight")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String weight;

    /**
     * The egg groups of the Pokemon
     */
    @JsonProperty("egg_groups")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<EggGroupDTO> eggGroups;

    /**
     * The catch rate to catch the Pokemon (3-255)
     */
    @JsonProperty("catch_rate")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer catchRate;

    /**
     * All experience to level up a Pokemon to level 100
     */
    @JsonProperty("level_100")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer level100;
}
