package tyradexteam.tyradex.services.utils;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Classe utilitaire pour calculer dynamiquement les faiblesses et résistances d'un Pokémon.
 */
public class ResistanceUtil {
    private final Dictionary<TypePokemon, Dictionary<TypePokemon, Double>> resistances;


    public ResistanceUtil() {
        this.resistances = new Hashtable<>();

        // Type Acier
        this.resistances.put(
                TypePokemon.STEEL, new Hashtable<TypePokemon, Double>()
                {{
                    put(TypePokemon.FIRE, 2.0);
                    put(TypePokemon.FIGHTING, 2.0);
                    put(TypePokemon.STEEL, 0.5);
                    put(TypePokemon.DRAGON, 0.5);
                    put(TypePokemon.FAIRY, 0.5);
                    put(TypePokemon.ICE, 0.5);
                    put(TypePokemon.BUG, 0.5);
                    put(TypePokemon.NORMAL, 0.5);
                    put(TypePokemon.GRASS, 0.5);
                    put(TypePokemon.ROCK, 0.0);
                    put(TypePokemon.POISON, 0.0);
                    put(TypePokemon.GROUND, 2.0);
                    put(TypePokemon.FLYING, 0.5);
                    put(TypePokemon.PSYCHIC, 0.5);
                }}
        );
        // Type Combat
        this.resistances.put(
                TypePokemon.FIGHTING, new Hashtable<>()
                {{
                    put(TypePokemon.BUG, 0.5);
                    put(TypePokemon.DARK, 0.5);
                    put(TypePokemon.ROCK, 0.5);
                    put(TypePokemon.FLYING, 2.0);
                    put(TypePokemon.PSYCHIC, 2.0);
                    put(TypePokemon.FAIRY, 2.0);
                }}
        );

        // Type Dragon
        this.resistances.put(
                TypePokemon.DRAGON, new Hashtable<>()
                {{
                    put(TypePokemon.FIRE, 0.5);
                    put(TypePokemon.WATER, 0.5);
                    put(TypePokemon.ELECTRIC, 0.5);
                    put(TypePokemon.GRASS, 0.5);
                    put(TypePokemon.ICE, 2.0);
                    put(TypePokemon.DRAGON, 2.0);
                    put(TypePokemon.FAIRY, 2.0);
                }}
        );

        // Type Eau
        this.resistances.put(
                TypePokemon.WATER, new Hashtable<>()
                {{
                    put(TypePokemon.FIRE, 0.5);
                    put(TypePokemon.WATER, 0.5);
                    put(TypePokemon.ICE, 0.5);
                    put(TypePokemon.STEEL, 0.5);
                    put(TypePokemon.ELECTRIC, 2.0);
                    put(TypePokemon.GRASS, 2.0);
                }}
        );

        // Type Électrique
        this.resistances.put(
                TypePokemon.ELECTRIC, new Hashtable<>()
                {{
                    put(TypePokemon.ELECTRIC, 0.5);
                    put(TypePokemon.FLYING, 0.5);
                    put(TypePokemon.STEEL, 0.5);
                    put(TypePokemon.GROUND, 2.0);
                }}
        );

        // Type Fée
        this.resistances.put(
                TypePokemon.FAIRY, new Hashtable<>()
                {{
                    put(TypePokemon.FIGHTING, 0.5);
                    put(TypePokemon.BUG, 0.5);
                    put(TypePokemon.DARK, 0.5);
                    put(TypePokemon.FIRE, 2.0);
                    put(TypePokemon.POISON, 2.0);
                    put(TypePokemon.STEEL, 2.0);
                }}
        );

        // Type Feu
        this.resistances.put(
                TypePokemon.FIRE, new Hashtable<>()
                {{
                    put(TypePokemon.FIRE, 0.5);
                    put(TypePokemon.GRASS, 0.5);
                    put(TypePokemon.ICE, 0.5);
                    put(TypePokemon.BUG, 0.5);
                    put(TypePokemon.STEEL, 0.5);
                    put(TypePokemon.WATER, 2.0);
                    put(TypePokemon.GROUND, 2.0);
                    put(TypePokemon.ROCK, 2.0);
                }}
        );

        // Type Glace
        this.resistances.put(
                TypePokemon.ICE, new Hashtable<>()
                {{
                    put(TypePokemon.ICE, 0.5);
                    put(TypePokemon.FIRE, 2.0);
                    put(TypePokemon.FIGHTING, 2.0);
                    put(TypePokemon.ROCK, 2.0);
                    put(TypePokemon.STEEL, 2.0);
                }}
        );

        // Type Insecte
        this.resistances.put(
                TypePokemon.BUG, new Hashtable<>()
                {{
                    put(TypePokemon.FIGHTING, 0.5);
                    put(TypePokemon.GROUND, 0.5);
                    put(TypePokemon.GRASS, 0.5);
                    put(TypePokemon.FIRE, 2.0);
                    put(TypePokemon.FLYING, 2.0);
                    put(TypePokemon.ROCK, 2.0);
                }}
        );

        // Type Normal
        this.resistances.put(
                TypePokemon.NORMAL, new Hashtable<>()
                {{
                    put(TypePokemon.GHOST, 0.0);
                    put(TypePokemon.FIGHTING, 2.0);
                }}
        );

        // Type Plante
        this.resistances.put(
                TypePokemon.GRASS, new Hashtable<>()
                {{
                    put(TypePokemon.WATER, 0.5);
                    put(TypePokemon.ELECTRIC, 0.5);
                    put(TypePokemon.GRASS, 0.5);
                    put(TypePokemon.GROUND, 0.5);
                    put(TypePokemon.FLYING, 2.0);
                    put(TypePokemon.POISON, 2.0);
                    put(TypePokemon.BUG, 2.0);
                    put(TypePokemon.FIRE, 2.0);
                    put(TypePokemon.ICE, 2.0);
                }}
        );

        // Type Poison
        this.resistances.put(
                TypePokemon.POISON, new Hashtable<>()
                {{
                    put(TypePokemon.GRASS, 0.5);
                    put(TypePokemon.FIGHTING, 0.5);
                    put(TypePokemon.POISON, 0.5);
                    put(TypePokemon.BUG, 0.5);
                    put(TypePokemon.FAIRY, 0.5);
                    put(TypePokemon.GROUND, 2.0);
                    put(TypePokemon.PSYCHIC, 2.0);
                }}
        );

        // Type Psy
        this.resistances.put(
                TypePokemon.PSYCHIC, new Hashtable<>()
                {{
                    put(TypePokemon.FIGHTING, 0.5);
                    put(TypePokemon.PSYCHIC, 0.5);
                    put(TypePokemon.BUG, 2.0);
                    put(TypePokemon.GHOST, 2.0);
                    put(TypePokemon.DARK, 2.0);
                }}
        );

        // Type Roche
        this.resistances.put(
                TypePokemon.ROCK, new Hashtable<>()
                {{
                    put(TypePokemon.FIRE, 0.5);
                    put(TypePokemon.FIGHTING, 0.5);
                    put(TypePokemon.GROUND, 0.5);
                    put(TypePokemon.FLYING, 0.5);
                    put(TypePokemon.BUG, 0.5);
                    put(TypePokemon.STEEL, 2.0);
                    put(TypePokemon.WATER, 2.0);
                    put(TypePokemon.GRASS, 2.0);
                    put(TypePokemon.FAIRY, 2.0);
                }}
        );

        // Type Sol
        this.resistances.put(
                TypePokemon.GROUND, new Hashtable<>()
                {{
                    put(TypePokemon.POISON, 0.5);
                    put(TypePokemon.ROCK, 0.5);
                    put(TypePokemon.ELECTRIC, 0.0);
                    put(TypePokemon.GRASS, 2.0);
                    put(TypePokemon.ICE, 2.0);
                    put(TypePokemon.WATER, 2.0);
                }}
        );

        // Type Spectre
        this.resistances.put(
                TypePokemon.GHOST, new Hashtable<>()
                {{
                    put(TypePokemon.NORMAL, 0.0);
                    put(TypePokemon.FIGHTING, 0.0);
                    put(TypePokemon.POISON, 0.5);
                    put(TypePokemon.BUG, 0.5);
                    put(TypePokemon.FAIRY, 0.5);
                    put(TypePokemon.PSYCHIC, 2.0);
                    put(TypePokemon.GHOST, 2.0);
                    put(TypePokemon.DARK, 2.0);
                }}
        );

        // Type Ténèbres
        this.resistances.put(
                TypePokemon.DARK, new Hashtable<>()
                {{
                    put(TypePokemon.GHOST, 0.5);
                    put(TypePokemon.DARK, 0.5);
                    put(TypePokemon.FIGHTING, 2.0);
                    put(TypePokemon.BUG, 2.0);
                    put(TypePokemon.FAIRY, 2.0);
                }}
        );

        // Type Vol
        this.resistances.put(
                TypePokemon.FLYING, new Hashtable<>()
                {{
                    put(TypePokemon.GRASS, 0.5);
                    put(TypePokemon.FIGHTING, 0.5);
                    put(TypePokemon.BUG, 0.5);
                    put(TypePokemon.ELECTRIC, 2.0);
                    put(TypePokemon.ICE, 2.0);
                    put(TypePokemon.ROCK, 2.0);
                }}
        );

    }
}