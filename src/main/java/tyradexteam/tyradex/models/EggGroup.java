package tyradexteam.tyradex.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Node("EggGroup")
public class EggGroup {
    @Id
    @GeneratedValue
    private String id;

    @Property("name_fr")
    private String nameFr;

    @Override
    public String toString() {
        return nameFr;
    }
}
