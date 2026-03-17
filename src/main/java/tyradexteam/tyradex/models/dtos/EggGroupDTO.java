package tyradexteam.tyradex.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Représente un groupe d'œufs dans le contexte de Pokémon, avec son nom dans différentes langues.
 */
@Getter
@Setter
@AllArgsConstructor
public class EggGroupDTO {
    /**
     * Le nom du groupe d'œufs, représenté par un objet NameDTO
     * qui contient les noms du groupe d'œufs dans différentes langues (français, anglais, japonais).
     */
    private NameDTO name;
}
