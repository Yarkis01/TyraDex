package tyradexteam.tyradex.services;

import org.springframework.stereotype.Service;
import tyradexteam.tyradex.models.Pokemon;
import tyradexteam.tyradex.models.Type;
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
    public List<Pokemon> getAllPokemon() {
        return this.repo.findAll();
    }

    /**
     * Method to retrieve Pokemon entities based on their type. This method interacts with the repository to fetch data
     * @param type1 The type of Pokemon to filter by, which can be provided in either French or English.
     * @return A list of Pokemon entities that match the specified type, retrieved from the database.
     */
    public List<Pokemon> getPokemonByType(String type1) {
        return this.repo.findByType(capitalizeFirstLetter(type1));
    }

    private String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
