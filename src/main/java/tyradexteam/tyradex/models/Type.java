package tyradexteam.tyradex.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

/**
 * Model class representing a Type entity.
 * This class can be expanded with fields and properties relevant to the Type concept in the application.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Node("TypePokemon")
public class Type {
    /**
     * ID of the Type of Pokemon, managed by Neo4J
     */
    @Id
    @GeneratedValue
    private String id;

    /**
     * French name of the type
     */
    @Property("name_fr")
    private String nameFr;

    /**
     * English name of the type
     */
    @Property("name_en")
    private String nameEn;

    /**
     * Japanese name of the type
     */
    @Property("name_jp")
    private String nameJp;

    /**
     * Image which represents the type
     */
    @Property("image")
    private String image;
}
