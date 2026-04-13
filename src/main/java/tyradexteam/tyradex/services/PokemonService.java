package tyradexteam.tyradex.services;

import org.springframework.stereotype.Service;
import tyradexteam.tyradex.models.dtos.PokemonDTO;
import tyradexteam.tyradex.models.exceptions.PokemonNotFoundException;
import tyradexteam.tyradex.services.mapper.PokemonMapper;
import tyradexteam.tyradex.services.repositories.PokemonRepository;

import java.util.List;

/**
 * Service class for managing Pokemon entities. This class provides business logic and interacts with the PokemonRepository
 * to perform CRUD operations on Pokemon data.
 */
@Service
public class PokemonService {
    private final PokemonRepository repo;

    /**
     * Constructor for PokemonService, which initializes the repository for database operations.
     * @param repo The PokemonRepository instance used for operations on Pokemon entities.
     */
    public PokemonService(PokemonRepository repo) {
        this.repo = repo;
    }

    /**
    * Method to retrieve all Pokemon entities from the database. This method interacts with the repository to fetch data.
    * @return An iterable collection of Pokemon entities retrieved from the database.
    */
    public List<PokemonDTO> getAllPokemon() {
        return this.repo.findAllCustom().stream().map(PokemonMapper::toDTO).toList();
    }

    /**
     * Method to retrieve Pokemon entities based on their type. This method interacts with the repository to fetch data
     * @param type1 The type of Pokemon to filter by, which can be provided in either French or English.
     * @return A list of Pokemon entities that match the specified type, retrieved from the database.
     */
    public List<PokemonDTO> getPokemonByType(String type1) {
        return PokemonMapper.toDTO(this.repo.findByType(type1.toLowerCase()));
    }

    /**
     * Method to retrieve a Pokemon entity based on its unique identifier (ID). This method interacts with the repository to fetch data
     * @param id The unique identifier of the Pokemon to retrieve. The method attempts to find a Pokemon with the specified ID and returns it as a DTO.
     *           If no Pokemon is found with the given ID, a PokemonNotFoundException is thrown.
     * @return The PokemonDTO corresponding to the Pokemon entity with the specified ID, retrieved from the database.
     * If no such Pokemon exists, an exception is thrown.
     * @throws PokemonNotFoundException If no Pokemon is found with the specified ID,
     * this exception is thrown to indicate that the requested resource does not exist in the database.
     */
    public PokemonDTO getPokemonById(Integer id) throws PokemonNotFoundException {
        return PokemonMapper.toDTO(this.repo.findById(id).orElseThrow(() -> new PokemonNotFoundException("Pokemon not found with id: " + id)));
    }

    /**
     * Method to retrieve a Pokemon entity based on its name.
     * @param name The name of the Pokemon to search for. The method attempts to find a Pokemon with the specified name and returns it as a DTO.
     * @return The pokemon to search for, retrieved from the database. If no such Pokemon exists, an exception is thrown.
     * @throws PokemonNotFoundException If the pokemon is not found with the specified name, this exception is thrown to indicate that the requested resource does not exist in the database.
     */
    public PokemonDTO getPokemonByName(String name) throws PokemonNotFoundException {
        return PokemonMapper.toDTO(this.repo.findByName(name.toLowerCase()).orElseThrow(() -> new PokemonNotFoundException("Pokemon not found with name: " + name)));
    }

    /**
     * Method to get the number of Pokemon present in the database
     * @return The number of the Pokemon
     */
    public Long getCountPokemon(){
        return this.repo.count();
    }
}
