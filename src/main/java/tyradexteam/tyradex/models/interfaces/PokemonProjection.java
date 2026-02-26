package tyradexteam.tyradex.models.interfaces;

import tyradexteam.tyradex.models.*;

import java.util.List;

public interface PokemonProjection {
    Integer getPokedexId();
    Integer getGeneration();
    InternationalizedName getNames();
    List<Type> getTypes();
    List<Talent> getTalents();
    Stat getStats();
    String getHeight();
    String getWeight();
    Integer getCatchRate();
    Integer getLevel100();
    List<EggGroup> getEggGroups();
    List<PokemonEvolutionProjection> getEvolutions();
    List<PokemonEvolutionProjection> getPreEvolutions();
}
