package tyradexteam.tyradex.models;

import lombok.*;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

/**
 * Model class representing an InternationalizedName entity.
 * This class will contain fields for different language representations of a name,
 * such as French, English, and Japanese.
 */
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Node("InternationalizedName")
public class InternationalizedName {
    @Id
    @Property("id")
    private String id;

    @Property("fr")
    private String fr;

    @Property("en")
    private String en;

    @Property("jp")
    private String jp;
}
