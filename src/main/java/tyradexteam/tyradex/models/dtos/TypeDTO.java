package tyradexteam.tyradex.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Représente les informations d'un type de monstre, incluant son nom et son image.
 */
@Getter
@Setter
@Builder
public class TypeDTO {
    /**
     * Le nom du type de monstre, représenté par un objet NameDTO qui contient les noms du type
     */
    @JsonProperty("name")
    private NameDTO name;

    /**
     * L'URL de l'image représentant le type de monstre.
     */
    @JsonProperty("image")
    private String image;
}
