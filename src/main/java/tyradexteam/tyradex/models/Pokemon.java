package tyradexteam.tyradex.models;

import lombok.*;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

/**
 * Model class representing a Pokemon entity.
 * This class will contain fields corresponding to the attributes of a Pokemon, such as name, type, abilities, etc.
 */
@Data
@Getter
@Setter
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
    @Property("catch_rate")
    private Integer catchRate;
    @Property("level_100")
    private Integer level_100;
    @Property("height")
    private String height;
    @Property("weight")
    private String weight;
}
