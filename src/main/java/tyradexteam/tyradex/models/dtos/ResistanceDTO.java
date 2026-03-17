package tyradexteam.tyradex.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import tyradexteam.tyradex.models.dtos.units.ResistanceUnitDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * La classe ResistanceDTO représente les résistances d'un personnage dans le jeu. Elle contient une liste de résistances,
 * où chaque résistance est représentée par un objet ResistanceUnitDTO qui contient le nom de la résistance et son multiplicateur.
 */
@Getter
@Setter
public class ResistanceDTO {
    /**
     * La liste des résistances d'un personnage, chaque résistance est représentée par un objet ResistanceUnitDTO
     * qui contient le nom de la résistance et son multiplicateur.
     */
    @JsonProperty("resistances")
    private List<ResistanceUnitDTO> resistances;

    /**
     * Constructeur par défaut qui initialise la liste des résistances à une nouvelle ArrayList vide.
     */
    public ResistanceDTO() {
        this.resistances = new ArrayList<>();
    }
}
