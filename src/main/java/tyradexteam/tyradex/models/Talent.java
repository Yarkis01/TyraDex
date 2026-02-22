package tyradexteam.tyradex.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

/**
 * Model class representing a Talent entity.
 * This class will contain fields for the talent's name and generation.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Node("Talent")
public class Talent {
    @Id
    @Property("id")
    @JsonIgnore
    private String id;

    @Relationship(type = "NAMED", direction = Relationship.Direction.OUTGOING)
    private InternationalizedName names;
    @Property("generation")
    private Integer generation;
}
