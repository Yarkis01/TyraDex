package tyradexteam.tyradex.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

/**
 * Model class representing a Pokemon entity.
 * This class will contain fields corresponding to the attributes of a Pokemon, such as name, type, abilities, etc.
 */
@Getter
@Setter
@Node("Pokemon")
public class Pokemon {
    @Id
    private String id;
    @Property("pokedex_id")
    private Integer pokedexId;
    @Property("generation")
    private Integer generation;
    @Property("catch_rate")
    private Integer catchRate;
    @Property("level_100")
    private Integer level_100;
    @Property("height")
    private String height;
    @Property("weight")
    private String weight;







}
