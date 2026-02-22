package tyradexteam.tyradex.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

/**
 * Model class representing a Stat entity.
 * This class will contain fields for the various stats of a Pokémon, such as HP, Attack, Defense, etc.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Node("Stat")
public class Stat {
    @Id
    @Property("id")
    @JsonIgnore
    private String id;
    @Property("hp")
    private Integer hp;
    @Property("atk")
    private Integer attack;
    @Property("def")
    private Integer defense;
    @Property("spe_atk")
    private Integer specialAttack;
    @Property("spe_def")
    private Integer specialDefense;
    @Property("speed")
    private Integer speed;
}
