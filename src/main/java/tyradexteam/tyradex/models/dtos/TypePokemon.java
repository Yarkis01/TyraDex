package tyradexteam.tyradex.models.dtos;

import lombok.Getter;

/**
 * Enumération représentant les différents types de Pokémon.
 */
public enum TypePokemon {
    NORMAL(new NameDTO("Normal", "Normal", "ノーマル")),
    FIRE(new NameDTO("Feu", "Fire", "ほのお")),
    WATER(new NameDTO("Eau", "Water", "みず")),
    ELECTRIC(new NameDTO("Électrik", "Electric", "でんき")),
    GRASS(new NameDTO("Plante", "Grass", "くさ")),
    ICE(new NameDTO("Glace", "Ice", "こおり")),
    FIGHTING(new NameDTO("Combat", "Fighting", "かくとう")),
    POISON(new NameDTO("Poison", "Poison", "どく")),
    GROUND(new NameDTO("Sol", "Ground", "じめん")),
    FLYING(new NameDTO("Vol", "Flying", "ひこう")),
    PSYCHIC(new NameDTO("Psy", "Psychic", "エスパー")),
    BUG(new NameDTO("Insecte", "Bug", "むし")),
    ROCK(new NameDTO("Roche", "Rock", "いわ")),
    GHOST(new NameDTO("Spectre", "Ghost", "ゴースト")),
    DRAGON(new NameDTO("Dragon", "Dragon", "ドラゴン")),
    DARK(new NameDTO("Ténèbres", "Dark", "あく")),
    STEEL(new NameDTO("Acier", "Steel", "はがね")),
    FAIRY(new NameDTO("Fée", "Fairy", "フェアリー"));

    @Getter
    private NameDTO name;

    /**
     * Constructeur de l'énumération TypePokemon, qui initialise le nom du type de Pokémon.
     * @param name Le nom du type de Pokémon, représenté par un objet NameDTO qui contient
     *             les noms du type dans différentes langues (français, anglais, japonais).
     */
    TypePokemon(NameDTO name) {
        this.name = name;
    }

    public static TypePokemon fromString(String type) {
        for (TypePokemon typePokemon : TypePokemon.values()) {
            if (typePokemon.name.getFr().equalsIgnoreCase(type) ||
                typePokemon.name.getEn().equalsIgnoreCase(type) ||
                typePokemon.name.getJp().equalsIgnoreCase(type)) {
                return typePokemon;
            }
        }
        throw new IllegalArgumentException("Type de Pokémon inconnu: " + type);
    }
}
