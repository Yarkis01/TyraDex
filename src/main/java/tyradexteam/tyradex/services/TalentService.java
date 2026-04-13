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
    private final PokemonMapper pkmnMapper;
    private final TalentMapper mapper;

    /**
     * Constructor of the talent service to initialize all repositories used in the service
     * @param pokemonRepository Repository to fech Pokemon Data
     * @param talentRepository Repository to fetrch Talent Data
     */
    public TalentService(
            PokemonRepository pokemonRepository,
            TalentRepository talentRepository,
            PokemonMapper pkmnMapper,
            TalentMapper mapper
    ){
        this.pkmnRepo = pokemonRepository;
        this.repo = talentRepository;
        this.pkmnMapper = pkmnMapper;
        this.mapper = mapper;
    }

    /**
     * Get all talent available in the database
     * @return All talents
     */
    public List<TalentDTO> getAll(){
        return this.repo.findAll().stream().map(this.mapper::toDto).toList();
    }

    /**
     * Get all Pokemon with the same talent defined by the parameter
     * @param talent Talent to search in all pokemon
     * @return All pokemon that can have the talent
     */
    public List<PokemonDTO> getPokemonByTalent(String talent){
        return this.pkmnRepo.findByTalent(talent.toLowerCase()).stream().map(this.pkmnMapper::toDTO).toList();
    }
}
