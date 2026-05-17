package tyradexteam.tyradex.models.dtos;

import lombok.Getter;

/**
 * All different Types of Pokemon in different languages (French, English and Japanese)
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
     * Constructor for the types of Pokemon
     * @param name Name of the Type of Pokemon in different languages (French, English and Japanese)
     */
    TypePokemon(NameDTO name) {
        this.name = name;
    }

    /**
     * Convert a string to a TypePokemon enum, by comparing the string with the name of the type in different languages (French, English and Japanese)
     * @param type Type of the Pokemon in string to convert
     * @return The TypePokemon corresponding to the string, if it exists, otherwise throws an IllegalArgumentException
     */
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
