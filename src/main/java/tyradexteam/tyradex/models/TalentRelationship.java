package tyradexteam.tyradex.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

/**
 * Relationship properties class for the HAS_TALENT relationship between Pokemon and Talent.
 * Captures the 'hidden' property on the relationship in addition to the target Talent node.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@RelationshipProperties
public class TalentRelationship {
    @RelationshipId
    @JsonIgnore
    private Long id;

    @Property("hidden")
    private Boolean hidden;

    @TargetNode
    private Talent talent;
}
