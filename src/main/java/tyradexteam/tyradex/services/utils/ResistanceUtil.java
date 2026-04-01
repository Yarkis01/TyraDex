package tyradexteam.tyradex.services.utils;

import jakarta.annotation.Nullable;
import tyradexteam.tyradex.models.dtos.ResistanceDTO;
import tyradexteam.tyradex.models.dtos.TypePokemon;
import tyradexteam.tyradex.models.dtos.units.ResistanceUnitDTO;

import java.util.Hashtable;
import java.util.Map;

/**
 * ResistanceUtil is a utility class that calculates the resistances of a Pokémon based on its types. It uses a predefined set of resistances for each type and combines them to determine the overall resistance of a Pokémon with one or two types.
 */
public class ResistanceUtil {
    private final Map<TypePokemon, Map<TypePokemon, Double>> resistances;
    private final Map<TypePokemon, Double> BASE_RESISTANCE = new Hashtable<TypePokemon, Double>()
    {{
        put(TypePokemon.NORMAL, 1.0);
        put(TypePokemon.FIGHTING, 1.0);
        put(TypePokemon.FLYING, 1.0);
        put(TypePokemon.POISON, 1.0);
        put(TypePokemon.GROUND, 1.0);
        put(TypePokemon.ROCK, 1.0);
        put(TypePokemon.BUG, 1.0);
        put(TypePokemon.GHOST, 1.0);
        put(TypePokemon.STEEL, 1.0);
        put(TypePokemon.FIRE, 1.0);
        put(TypePokemon.WATER, 1.0);
        put(TypePokemon.GRASS, 1.0);
        put(TypePokemon.ELECTRIC, 1.0);
        put(TypePokemon.PSYCHIC, 1.0);
        put(TypePokemon.ICE, 1.0);
        put(TypePokemon.DRAGON, 1.0);
        put(TypePokemon.DARK, 1.0);
        put(TypePokemon.FAIRY, 1.0);
    }};

    /**
     * Constructor of the ResistanceUtil class, which initializes the resistances map and populates it with the predefined resistances for each Pokémon type.
     */
    public ResistanceUtil() {
        this.resistances = new Hashtable<>();
        this.initializeResistances();
    }

    /**
     * Calculates the resistances of a Pokémon based on its types. It takes one or two types as input and returns a ResistanceDTO containing the resistances for each type of attack.
     * The method combines the resistances of both types to determine the overall resistance of the Pokémon.
     * @param type1 The primary type of the Pokémon, which is required to calculate the resistances. This type is used to look up the resistances in the predefined map and contributes to the overall resistance calculation.
     * @param type2 The secondary type of the Pokémon, which is optional and can be null. If provided, this type is also used to look up the resistances in the predefined map and contributes to the overall resistance calculation by multiplying the resistances of both types together.
     * @return A ResistanceDTO object that contains the resistances for each type of attack based on the provided types.
     * The resistances are calculated by combining the resistances of both types, and the resulting ResistanceDTO includes a list of ResistanceUnitDTO objects that represent the name and multiplier for each type of attack.
     */
    public ResistanceDTO getResistances(TypePokemon type1, @Nullable TypePokemon type2) {
        ResistanceDTO resistanceDTO = new ResistanceDTO();
        resistanceDTO.setResistances(this.getResistanceFor(type1, type2).entrySet().stream()
            .map(entry -> ResistanceUnitDTO.builder()
                .name(entry.getKey().getName())
                .multiplier(entry.getValue())
                .build())
            .toList());
        return resistanceDTO;
    }

    private void initializeResistances() {
        // Type Acier
        this.resistances.put(
                TypePokemon.STEEL, new Hashtable<TypePokemon, Double>()
                {{
                    put(TypePokemon.POISON, 0.0);
                    put(TypePokemon.ROCK, 0.5);
                    put(TypePokemon.STEEL, 0.5);
                    put(TypePokemon.DRAGON, 0.5);
                    put(TypePokemon.FAIRY, 0.5);
                    put(TypePokemon.ICE, 0.5);
                    put(TypePokemon.BUG, 0.5);
                    put(TypePokemon.NORMAL, 0.5);
                    put(TypePokemon.GRASS, 0.5);
                    put(TypePokemon.FLYING, 0.5);
                    put(TypePokemon.PSYCHIC, 0.5);
                    put(TypePokemon.GROUND, 2.0);
                    put(TypePokemon.FIRE, 2.0);
                    put(TypePokemon.FIGHTING, 2.0);
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

        // Type Électrik
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
                    put(TypePokemon.DRAGON, 0.0);
                    put(TypePokemon.FIGHTING, 0.5);
                    put(TypePokemon.BUG, 0.5);
                    put(TypePokemon.DARK, 0.5);
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
                    put(TypePokemon.FAIRY, 0.5);
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
                    put(TypePokemon.FLYING, 0.5);
                    put(TypePokemon.POISON, 0.5);
                    put(TypePokemon.NORMAL, 0.5);
                    put(TypePokemon.GROUND, 2.0);
                    put(TypePokemon.STEEL, 2.0);
                    put(TypePokemon.WATER, 2.0);
                    put(TypePokemon.GRASS, 2.0);
                    put(TypePokemon.FIGHTING, 2.0);
                }}
        );

        // Type Sol
        this.resistances.put(
                TypePokemon.GROUND, new Hashtable<>()
                {{
                    put(TypePokemon.ELECTRIC, 0.0);
                    put(TypePokemon.POISON, 0.5);
                    put(TypePokemon.ROCK, 0.5);
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
                    put(TypePokemon.GHOST, 2.0);
                    put(TypePokemon.DARK, 2.0);
                }}
        );

        // Type Ténèbres
        this.resistances.put(
                TypePokemon.DARK, new Hashtable<>()
                {{
                    put(TypePokemon.PSYCHIC, 0.0);
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
                    put(TypePokemon.GROUND, 0.0);
                    put(TypePokemon.GRASS, 0.5);
                    put(TypePokemon.FIGHTING, 0.5);
                    put(TypePokemon.BUG, 0.5);
                    put(TypePokemon.ELECTRIC, 2.0);
                    put(TypePokemon.ICE, 2.0);
                    put(TypePokemon.ROCK, 2.0);
                }}
        );
    }

    private Map<TypePokemon, Double> getResistanceFor(TypePokemon type1, @Nullable TypePokemon type2){
        Map<TypePokemon, Double> resultResistances = new Hashtable<>();
        for (TypePokemon type : TypePokemon.values()) {
            double multiplier = BASE_RESISTANCE.get(type);
            if (this.resistances.containsKey(type1) && this.resistances.get(type1).containsKey(type)) {
                multiplier *= this.resistances.get(type1).get(type);
            }
            if (type2 != null && this.resistances.containsKey(type2) && this.resistances.get(type2).containsKey(type)) {
                multiplier *= this.resistances.get(type2).get(type);
            }
            resultResistances.put(type, multiplier);
        }
        return resultResistances;
    }
}