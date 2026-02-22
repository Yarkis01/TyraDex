package tyradexteam.tyradex.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Node("EggGroup")
public class EggGroup {
    @Id
    @Property("id")
    @JsonIgnore
    private String id;

    @Relationship(type = "NAMED", direction = Relationship.Direction.OUTGOING)
    private InternationalizedName names;
}
