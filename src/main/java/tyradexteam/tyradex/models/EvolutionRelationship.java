package tyradexteam.tyradex.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

/**
 * Relationship properties class for the EVOLVED_TO and WAS relationships between Pokemon nodes.
 * Captures the 'condition' property on the relationship in addition to the target Pokemon node.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@RelationshipProperties
public class EvolutionRelationship {
    @RelationshipId
    @JsonIgnore
    private Long id;

    @Property("condition")
    private String condition;

    @TargetNode
    @JsonIgnoreProperties({"nextEvolutions", "previousEvolutions"})
    private Pokemon pokemon;
}
