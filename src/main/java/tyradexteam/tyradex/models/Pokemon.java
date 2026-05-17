package tyradexteam.tyradex.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

/**
 * Model class representing a Pokemon entity.
 * This class will contain fields corresponding to the attributes of a Pokemon, such as name, type, abilities, etc.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Node("Pokemon")
public class Pokemon {
    /**
     * ID of the Pokemon in the national pokedex
     */
    @Id
    @Property("pokedex_id")
    private Integer pokedexId;

    /**
     * Generation of the Pokemon
     */
    @Property("generation")
    private Integer generation;

    /**
     * French name of the Pokemon
     */
    @Property("name_fr")
    private String nameFr;

    /**
     * English name of the Pokemon
     */
    @Property("name_en")
    private String nameEn;

    /**
     * Japanese name of the Pokemon
     */
    @Property("name_jp")
    private String nameJp;

    /**
     * Category of the Pokemon (e.g., "Seed Pokémon", "Lizard Pokémon", etc.)
     */
    @Property("category")
    private String category;

    /**
     * Regular sprite of the Pokemon
     */
    @Property("sprite_regular")
    private String spriteRegular;

    /**
     * Shiny sprite of the Pokemon
     */
    @Property("sprite_shiny")
    private String spriteShiny;

    /**
     * Level of evolution of the Pokemon in his family of evolution.
     */
    @Property("order")
    private Integer order;

    /**
     * The rate to catch the pokemon (3-255)
     */
    @Property("catch_rate")
    private Integer catchRate;

    /**
     * The quantity of experience to reach to level 100
     */
    @Property("level_100")
    private Integer level_100;

    /**
     * The height of the Pokemon
     */
    @Property("height")
    private String height;

    /**
     * The weight of the Pokemon
     */
    @Property("weight")
    private String weight;

    /**
     * The heal point of the Pokemon (stat)
     */
    @Property("hp")
    private Integer hp;

    /**
     * The attack of the Pokemon (stat)
     */
    @Property("atk")
    private Integer attack;

    /**
     * The defense of the Pokemon (stat)
     */
    @Property("def")
    private Integer defense;

    /**
     * The special attack of the Pokemon (stat)
     */
    @Property("spe_atk")
    private Integer specialAttack;

    /**
     * The special defense of the Pokemon (stat)
     */
    @Property("spe_def")
    private Integer specialDefense;

    /**
     * The speed of the Pokemon (stat)
     */
    @Property("speed")
    private Integer speed;

    /**
     * Relationship to get all types of the Pokemon
     */
    @Relationship(type = "IS_TYPED", direction = Relationship.Direction.OUTGOING)
    private List<Type> types;

    /**
     * Relationship to get all egg groups of the Pokemon
     */
    @Relationship(type = "GROUPED_IN", direction = Relationship.Direction.OUTGOING)
    private List<EggGroup> eggGroups;

    /**
     * Relationship to get all talents of the Pokemon
     */
    @Relationship(type = "HAS", direction = Relationship.Direction.OUTGOING)
    private List<TalentRelationship> talents;

    /**
     * Relationship to get all previous evolutions
     */
    @Relationship(type = "WAS", direction = Relationship.Direction.OUTGOING)
    private List<EvolutionRelationship> previousEvolutions;

    /**
     * Relationship to get all next evolutions
     */
    @Relationship(type = "NEXT", direction = Relationship.Direction.OUTGOING)
    private List<EvolutionRelationship> nextEvolutions;

}
