package tyradexteam.tyradex.controllers;

import org.springframework.web.bind.annotation.*;
import tyradexteam.tyradex.models.Pokemon;
import tyradexteam.tyradex.services.PokemonService;

import java.util.List;
import java.util.Optional;

/**
 * Controller class for handling HTTP requests related to Pokemon entities.
 * This class will define endpoints for request Pokemon data,
 * and will interact with the PokemonService to perform business logic operations.
 */
@RestController()
@RequestMapping("pokemon")
public class PokemonController {
    private final PokemonService service;

    /**
     * Constructor for PokemonController, which initializes the service for handling business logic related to Pokemon entities.
     * @param service The PokemonService instance used for performing operations on Pokemon data.
     */
    public PokemonController(PokemonService service) {
        this.service = service;
    }

    /**
     * Endpoint to retrieve all Pokemon entities. This method will handle HTTP requests to the "/all"
     * endpoint and return a collection of Pokemon data.
     * @return An iterable collection of Pokemon entities retrieved from the service layer,
     * which in turn interacts with the repository to fetch data from the database.
     */
    @GetMapping(value = "all", produces = "application/json")
    public List<Pokemon> getAllPokemon() {
        return this.service.getAllPokemon();
    }

    @GetMapping(value = "type/{type1}", produces = "application/json")
    public List<Pokemon> getPokemonByType(@PathVariable String type1) {
        return this.service.getPokemonByType(type1);
    }
}
