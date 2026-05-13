package tyradexteam.tyradex.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import tyradexteam.tyradex.models.dtos.units.ResistanceUnitDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * DTO class representing the resistance information of a Pokémon, including its resistances to various types.
 */
@Getter
@Setter
public class ResistanceDTO {
    /**
     * List of ResistanceUnitDTO which represents a type & his multiplier of resistance (0, 0.25, 0.5, 1, 1.5, 2, 4).
     */
    @JsonProperty("resistances")
    private List<ResistanceUnitDTO> resistances;

    /**
     * Constructor for ResistanceDTO to initialize resistances
     */
    public ResistanceDTO() {
        this.resistances = new ArrayList<>();
    }
}
