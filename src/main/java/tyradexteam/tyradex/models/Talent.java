package tyradexteam.tyradex.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

/**
 * Model class representing a Talent entity.
 * This class will contain fields for the talent's name and generation.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Node("Talent")
public class Talent {
    /**
     * ID of the talent, managed by Neo4J
     */
    @Id
    @GeneratedValue
    private String id;

    /**
     * French name of the talent
     */
    @Property("name_fr")
    private String nameFr;

    /**
     * English name of the talent
     */
    @Property("name_en")
    private String nameEn;

    /**
     * Japanese name of the talent
     */
    @Property("name_jp")
    private String nameJp;

    /**
     * Apparition generation of the talent
     */
    @Property("generation")
    private Integer generation;

    /**
     * Effect of the talent on the fight
     */
    @Property("effet_combat")
    private String effectFight;

    /**
     * Effect of the talent on the stadium
     */
    @Property("effet_terrain")
    private String effectStadium;
}
