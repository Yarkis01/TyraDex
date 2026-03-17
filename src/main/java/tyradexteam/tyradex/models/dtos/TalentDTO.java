package tyradexteam.tyradex.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Représente les talents d'une entité, avec un nom et une indication si c'est un talent de classe (tc).
 */
@Getter
@Setter
@Builder
public class TalentDTO {
    /**
     * Le nom du talent, représenté par un objet NameDTO qui contient les noms du talent
     * dans différentes langues (français, anglais, japonais).
     */
    @JsonProperty("name")
    private NameDTO name;
    /**
     * Indique si le talent est un talent caché (tc) ou non.
     */
    @JsonProperty("tc")
    private Boolean tc;
}
