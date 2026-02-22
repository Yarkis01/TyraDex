package tyradexteam.tyradex.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;
import tools.jackson.databind.annotation.JsonAppend;

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
    @Property("id")
    @JsonIgnore
    private String id;

    @Relationship(type = "NAMED", direction = Relationship.Direction.OUTGOING)
    private InternationalizedName names;

    @Property("image")
    private String image;

}
