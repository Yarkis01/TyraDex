package tyradexteam.tyradex.models.interfaces;

import tyradexteam.tyradex.models.InternationalizedName;
import tyradexteam.tyradex.models.Type;

import java.util.List;

public interface PokemonEvolutionProjection {
    Integer getPokedexId();
    Integer getGeneration();
    InternationalizedName getNames();
    List<Type> getTypes();
}
