package tyradexteam.tyradex.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

/**
 * Model class representing an EggGroup entity.
 * This class can be expanded with fields and properties relevant to the EggGroup concept in the application.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Node("EggGroup")
public class EggGroup {
    /**
     * ID of the EggGroup, managed by Neo4J
     */
    @Id
    @GeneratedValue
    private String id;

    /**
     * Name of the EggGroup in French
     */
    @Property("name_fr")
    private String nameFr;

    /**
     * Name of the EggGroup in English
     */
    @Property("name_en")
    private String nameEn;

    /**
     * Name of the EggGroup in Japanese
     */
    @Property("name_jp")
    private String nameJp;

    /**
     * Override of the toString method to return the name of the EggGroup in French.
     * @return The Egg group name in French
     */
    @Override
    public String toString() {
        return nameFr;
    }
}
