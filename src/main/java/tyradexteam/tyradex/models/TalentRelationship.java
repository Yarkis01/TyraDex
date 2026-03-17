package tyradexteam.tyradex.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private Long id;

    @Property("hidden")
    private Boolean hidden;

    @TargetNode
    private Talent talent;
}
