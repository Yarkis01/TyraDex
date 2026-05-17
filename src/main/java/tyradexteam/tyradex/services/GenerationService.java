package tyradexteam.tyradex.services;

import org.springframework.stereotype.Service;
import tyradexteam.tyradex.models.dtos.GenerationInfoDTO;
import tyradexteam.tyradex.models.dtos.PokemonDTO;
import tyradexteam.tyradex.services.mapper.PokemonMapper;
import tyradexteam.tyradex.services.repositories.PokemonRepository;

import java.util.List;

/**
 * The service to manage and extract all data related to the generation of Pokemon.
 */
@Service
public class GenerationService {
    private final PokemonRepository pkmnRepo;
    private final PokemonMapper mapper;

    /**
     * Constructor for generation service to initialize repositories used in the service
     * @param pokemonRepository The repository to get data of Pokemon
     */
    public GenerationService(
            PokemonRepository pokemonRepository,
            PokemonMapper mapper
    ){
        this.pkmnRepo = pokemonRepository;
        this.mapper = mapper;
    }

    /**
     * Method to retrieve all generation information. This method interacts with the repository to fetch data
     * @return A list of GenerationInfoDTO objects containing information about all Pokemon generations, retrieved from the database. Each GenerationInfoDTO object includes details such as the generation number, name, and other relevant information about that generation.
     */
    public List<GenerationInfoDTO> getAllGenerations() {
        return this.pkmnRepo.findAllGenerationInfo();
    }

    /**
     * Method to retrieve Pokemon entities based on their generation. This method interacts with the repository to fetch data
     * @param generation The generation of Pokemon to filter by. The query matches Pokemon nodes that have a 'generation' property equal to the specified value.
     * @return A list of Pokemon entities that match the specified generation, retrieved from the database.
     */
    public List<PokemonDTO> getPokemonByGeneration(Integer generation) {
        return this.pkmnRepo.findByGeneration(generation).stream().map(this.mapper::toDTO).toList();
    }

}
