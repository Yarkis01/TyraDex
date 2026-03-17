package tyradexteam.tyradex.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Représente les données d'un Pokémon, incluant son ID dans le Pokédex, sa génération, son nom,
 * ses sprites, ses types, ses talents, ses statistiques, ses résistances, son évolution, sa taille,
 * son poids, ses groupes d'œufs, son taux de capture et son niveau à 100.
 */
@Builder
@Getter
@Setter
@JsonPropertyOrder({
    "pokedex_id",
    "generation",
    "name",
    "types",
    "sprites",
    "talents",
    "resistances",
    "stats",
    "evolution",
    "egg_groups",
    "height",
    "weight",
    "catch_rate",
    "level_100"
})
public class PokemonDTO {
    /**
     * ID du Pokémon dans le Pokédex, utilisé pour identifier de manière unique chaque Pokémon.
     */
    @JsonProperty("pokedex_id")
    private Integer pokedexId;

    /**
     * Génération du Pokémon, indiquant à quelle génération de jeux vidéo il appartient
     * (par exemple, 1 pour la première génération, 2 pour la deuxième, etc.).
     */
    @JsonProperty("generation")
    private Integer generation;

    /**
     * Nom du Pokémon, représenté par un objet NameDTO qui contient les noms du Pokémon
     * dans différentes langues (français, anglais, japonais).
     */
    @JsonProperty("name")
    private NameDTO name;

    /**
     * Sprites du Pokémon, représentés par un objet SpriteDTO qui contient les différentes
     * images du Pokémon (par exemple, les sprites normaux, shiny, etc.).
     */
    @JsonProperty("sprites")
    private SpriteDTO sprites;

    /**
     * Types du Pokémon, représentés par un objet TypeDTO qui contient les types du Pokémon
     * (par exemple, feu, eau, plante, etc.) et les images associées à ces types.
     */
    @JsonProperty("types")
    private List<TypeDTO> types;

    /**
     * Talents du Pokémon, représentés par un objet TalentDTO qui contient les talents du Pokémon
     * (par exemple, statik, lévitation, etc.) et une indication si ces talents sont des talents cachés (tc) ou non.
     */
    @JsonProperty("talents")
    private List<TalentDTO> talents;

    /**
     * Statistiques du Pokémon, représentées par un objet StatDTO qui contient les différentes statistiques du Pokémon
     * (par exemple, points de vie, attaque, défense, etc.) et leurs valeurs respectives.
     */
    @JsonProperty("stats")
    private StatDTO stats;

    /**
     * Résistances du Pokémon, représentées par un objet ResistanceDTO qui contient les différentes résistances du Pokémon
     * (par exemple, résistance au feu, à l'eau, etc.) et leurs valeurs respectives.
     */
    @JsonProperty("resistances")
    private ResistanceDTO resistances;

    /**
     * Évolution du Pokémon, représentée par un objet EvolutionDTO qui contient les différentes évolutions du Pokémon
     * (par exemple, les évolutions précédentes et suivantes) et les conditions d'évolution associées
     * (par exemple, niveau, objet, etc.).
     */
    @JsonProperty("evolution")
    private EvolutionDTO evolution;

    /**
     * Taille du Pokémon, représentée par une chaîne de caractères indiquant la hauteur du Pokémon
     * (par exemple, "1.0 m", "0.5 m", etc.).
     */
    @JsonProperty("height")
    private String height;

    /**
     * Poids du Pokémon, représenté par une chaîne de caractères indiquant le poids du Pokémon
     * (par exemple, "10.0 kg", "5.0 kg", etc.).
     */
    @JsonProperty("weight")
    private String weight;

    /**
    * Groupes d'œufs du Pokémon, représentés par un tableau de chaînes de caractères indiquant les différents groupes d'œufs
    */
    @JsonProperty("egg_groups")
    private List<EggGroupDTO> eggGroups;

    /**
    * Taux de capture du Pokémon, représenté par un entier indiquant la probabilité de capturer le Pokémon
    */
    @JsonProperty("catch_rate")
    private Integer catchRate;

    /**
    * Nombre de points d'expériences du Pokémon pour atteindre le niveau 100 indiqué par un entier
    */
    @JsonProperty("level_100")
    private Integer level100;
}
