package tyradexteam.tyradex.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
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

    @Relationship(type = "NAMED", direction = Relationship.Direction.OUTGOING)
    private InternationalizedName names;

    @Relationship(type = "IS_TYPED", direction = Relationship.Direction.OUTGOING)
    private List<Type> types;

    @Relationship(type = "HAS_TALENT", direction = Relationship.Direction.OUTGOING)
    private List<Talent> talents;

    @Relationship(type = "EVOLVED_TO", direction = Relationship.Direction.INCOMING, cascadeUpdates = false)
    @JsonIgnoreProperties({"evolutions", "preEvolutions"})
    private List<Pokemon> evolutions;

    @Relationship(type = "WAS", direction =  Relationship.Direction.OUTGOING, cascadeUpdates = false)
    @JsonIgnoreProperties({"evolutions", "preEvolutions"})
    private List<Pokemon> preEvolutions;

    @Relationship(type = "COMPOSED", direction =Relationship.Direction.OUTGOING)
    private Stat stats;

    @Property("catch_rate")
    private Integer catchRate;

    @Property("level_100")
    private Integer level_100;

    @Relationship(type = "BEHOVE", direction = Relationship.Direction.OUTGOING)
    private List<EggGroup> eggGroups;

    @Property("height")
    private String height;

    @Property("weight")
    private String weight;

}
