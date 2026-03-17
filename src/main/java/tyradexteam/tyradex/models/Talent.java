package tyradexteam.tyradex.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

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

    @Property("name_fr")
    private String nameFr;

    @Property("name_en")
    private String nameEn;

    @Property("name_jp")
    private String nameJp;

    @Property("generation")
    private Integer generation;
}
