package tyradexteam.tyradex.services;

import org.springframework.stereotype.Service;
import tyradexteam.tyradex.models.Pokemon;
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
        System.out.println(this.repo.findAll());
        return this.repo.findAll();
    }
}
