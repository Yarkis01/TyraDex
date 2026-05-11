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
    @Id
    @Property("pokedex_id")
    private Integer pokedexId;

    @Property("generation")
    private Integer generation;

    @Property("name_fr")
    private String nameFr;

    @Property("name_en")
    private String nameEn;

    @Property("name_jp")
    private String nameJp;

    @Property("sprite_regular")
    private String spriteRegular;

    @Property("sprite_shiny")
    private String spriteShiny;

    @Property("order")
    private Integer order;

    @Property("catch_rate")
    private Integer catchRate;

    @Property("level_100")
    private Integer level_100;

    @Property("height")
    private String height;

    @Property("weight")
    private String weight;

    @Property("hp")
    private Integer hp;

    @Property("atk")
    private Integer attack;

    @Property("def")
    private Integer defense;

    @Property("spe_atk")
    private Integer specialAttack;

    @Property("spe_def")
    private Integer specialDefense;

    @Property("speed")
    private Integer speed;

    @Relationship(type = "IS_TYPED", direction = Relationship.Direction.OUTGOING)
    private List<Type> types;

    @Relationship(type = "GROUPED_IN", direction = Relationship.Direction.OUTGOING)
    private List<EggGroup> eggGroups;

    @Relationship(type = "HAS", direction = Relationship.Direction.OUTGOING)
    private List<TalentRelationship> talents;

    @Relationship(type = "WAS", direction = Relationship.Direction.OUTGOING)
    private List<EvolutionRelationship> previousEvolutions;

    @Relationship(type = "NEXT", direction = Relationship.Direction.OUTGOING)
    private List<EvolutionRelationship> nextEvolutions;

}
