package tyradexteam.tyradex.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Entity which represents an egg group
 */
@Getter
@Setter
@AllArgsConstructor
public class EggGroupDTO {
    /**
     * Name of the egg group
     */
    private NameDTO name;
}
