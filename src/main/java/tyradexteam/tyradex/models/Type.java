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
    @Id
    @GeneratedValue
    private String id;

    @Property("name_fr")
    private String nameFr;

    @Property("name_en")
    private String nameEn;

    @Property("name_jp")
    private String nameJp;

    @Property("image")
    private String image;
}
