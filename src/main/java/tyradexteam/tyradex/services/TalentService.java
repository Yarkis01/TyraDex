package tyradexteam.tyradex.services;

import org.springframework.stereotype.Service;
import tyradexteam.tyradex.models.dtos.PokemonDTO;
import tyradexteam.tyradex.models.dtos.TalentDTO;
import tyradexteam.tyradex.services.mapper.PokemonMapper;
import tyradexteam.tyradex.services.mapper.TalentMapper;
import tyradexteam.tyradex.services.repositories.PokemonRepository;
import tyradexteam.tyradex.services.repositories.TalentRepository;

import java.util.List;

@Service
public class TalentService {
    private final PokemonRepository pkmnRepo;
    private final TalentRepository repo;

    /**
     * Constructor of the talent service to initialize all repositories used in the service
     * @param pokemonRepository Repository to fech Pokemon Data
     * @param talentRepository Repository to fetrch Talent Data
     */
    public TalentService(
            PokemonRepository pokemonRepository,
            TalentRepository talentRepository
    ){
        this.pkmnRepo = pokemonRepository;
        this.repo = talentRepository;
    }

    /**
     * Get all talent available in the database
     * @return All talents
     */
    public List<TalentDTO> getAll(){
        return this.repo.findAll().stream().map(TalentMapper::toDto).toList();
    }

    /**
     * Get all Pokemon with the same talent defined by the parameter
     * @param talent Talent to search in all pokemon
     * @return All pokemon that can have the talent
     */
    public List<PokemonDTO> getPokemonByTalent(String talent){
        return this.pkmnRepo.findByTalent(talent.toLowerCase()).stream().map(PokemonMapper::toDTO).toList();
    }
}
