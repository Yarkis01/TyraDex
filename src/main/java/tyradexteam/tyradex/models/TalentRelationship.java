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
    /**
     * ID of the relationship, managed by Neo4J
     */
    @RelationshipId
    private String id;

    /**
     * Indicates whether the talent is hidden or not for the Pokemon. This is a property of the relationship, not the Talent node itself.
     */
    @Property("hidden")
    private Boolean hidden;

    /**
     * The talent node that this relationship points to. This is the target node of the relationship, and it represents the talent associated with the Pokemon.
     */
    @TargetNode
    private Talent talent;
}
