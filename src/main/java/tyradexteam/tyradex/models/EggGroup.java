package tyradexteam.tyradex.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Node("EggGroup")
public class EggGroup {
    @Id
    @Property("id")
    @JsonIgnore
    private String id;

    @Property("name_fr")
    private String nameFr;
}
