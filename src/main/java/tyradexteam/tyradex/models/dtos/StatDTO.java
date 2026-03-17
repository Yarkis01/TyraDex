package tyradexteam.tyradex.models.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * La classe StatDTO représente les statistiques d'un personnage dans le jeu.
 * Elle contient des propriétés pour les points de vie (hp), l'attaque (atk), la défense (def),
 * l'attaque spéciale (spAtk), la défense spéciale (spDef) et la vitesse (speed).
 */
@Getter
@Setter
@Builder
public class StatDTO {
    /**
     * Les points de vie (hp) d'un personnage, représentant sa santé et sa capacité à encaisser des dégâts.
     */
    @JsonProperty("hp")
    private Integer hp;

    /**
     * L'attaque (atk) d'un personnage, représentant sa capacité à infliger des dégâts physiques à ses adversaires.
     */
    @JsonProperty("atk")
    private Integer atk;

    /**
     * La défense (def) d'un personnage, représentant sa capacité à réduire les dégâts physiques reçus de ses adversaires.
     */
    @JsonProperty("def")
    private Integer def;

    /**
     * L'attaque spéciale (spAtk) d'un personnage, représentant sa capacité à infliger des dégâts spéciaux à ses adversaires.
     */
    @JsonProperty("spe_atk")
    private Integer spAtk;

    /**
     * La défense spéciale (spDef) d'un personnage, représentant sa capacité à réduire les dégâts spéciaux reçus de ses adversaires.
     */
    @JsonProperty("spe_def")
    private Integer spDef;

    /**
     * La vitesse (speed) d'un personnage, représentant sa capacité à agir plus rapidement que ses adversaires lors des combats.
     */
    @JsonProperty("vit")
    private Integer speed;
}
