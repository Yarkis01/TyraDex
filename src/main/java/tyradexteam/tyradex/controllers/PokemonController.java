package tyradexteam.tyradex.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tyradexteam.tyradex.models.dtos.PokemonDTO;
import tyradexteam.tyradex.services.PokemonService;

import java.util.List;

/**
 * Controller class for handling HTTP requests related to Pokemon entities.
 * This class will define endpoints for request Pokemon data,
 * and will interact with the PokemonService to perform business logic operations.
 */
@RestController
@RequestMapping("/pokemons")
@Tag(name = "Pokemon", description = "Endpoints for retrieving Pokemon entities and related data.")
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
    @Cacheable("allPokemon")
    @GetMapping(produces = "application/json")
    @Operation(summary = "Retrieve All Pokemon", description = "Endpoint to retrieve all Pokemon entities. This method will handle HTTP requests to the '/all' endpoint and return a collection of Pokemon data.")
    public List<PokemonDTO> getAllPokemon() {
        return this.service.getAllPokemon();
    }

    /**
     * Endpoint to retrieve all Pokemon entities with only the necessary information to display them in a list.
     * This method will handle HTTP requests to the "/light"
     * @return An iterable collections of Pokemon entities retrived.
     */
    @Cacheable("allPokemonLighted")
    @GetMapping(value={"/lighted"}, produces = "application/json")
    @Operation(summary = "Retrieve All Pokemon Lighted", description = "Endpoint to retrieve all Pokemon entities with only the necessary information to display them in a list. This method will handle HTTP requests to the '/light' endpoint and return a collection of Pokemon data with minimal information.")
    public List<PokemonDTO> getAllPokemonLighted() {
        return this.service.getAllLightPokemon();
    }

    /**
     * Endpoint to retrieve a Pokemon entity based on its unique identifier (ID). This method will handle HTTP requests to the "/{id}"
     * @param nameOrId The unique identifier of the Pokemon to retrieve. The endpoint will attempt to find a Pokemon with the specified ID and return it as a DTO.
     * @return The PokemonDTO corresponding to the Pokemon entity with the specified ID, retrieved from the service layer,
     * which in turn interacts with the repository to fetch data from the database. If no such Pokemon exists, an exception is thrown.
     */
    @GetMapping(value = "{nameOrId}", produces = "application/json")
    @Operation(summary = "Retrieve Pokemon by ID or Name", description = "Endpoint to retrieve a Pokemon entity based on its unique identifier (ID) or name. This method will handle HTTP requests to the '/{id}' endpoint, where 'id' can be either the numeric ID or the name of the Pokemon. The endpoint will attempt to find a Pokemon with the specified ID or name and return it as a DTO. If no such Pokemon exists, an exception is thrown.")
    public PokemonDTO getPokemonById(@PathVariable String nameOrId) {
        PokemonDTO pokemon;
        try {
            Integer idInt = Integer.parseInt(nameOrId);
            pokemon = this.service.getPokemonById(idInt);
        } catch (NumberFormatException e) {
            System.out.println(nameOrId);
            pokemon = this.service.getPokemonByName(nameOrId);
        }
        return pokemon;
    }

    @GetMapping(value = "search/{name}", produces = "application/json")
    @Operation(summary = "Search Pokemon by Name", description = "Endpoint to search for Pokemon entities based on their name. This method will handle HTTP requests to the '/search/{name}' endpoint, where 'name' is a string representing the name of the Pokemon to search for. The endpoint will attempt to find Pokemon with names that match the specified string and return them as a list of DTOs. If no such Pokemon exists, an empty list is returned.")
    public List<PokemonDTO> getPokemonByName(@PathVariable String name) {
        return this.service.findPokemonByName(name);
    }

    /**
     * Endpoint to get the number of Pokemon in the database
     * @return The number of Pokemon in the database
     */
    @Cacheable("countPokemon")
    @GetMapping(value = "count", produces = "application/json")
    @Operation(summary = "Get Pokemon Count", description = "Endpoint to get the number of Pokemon in the database. This method will handle HTTP requests to the '/count' endpoint and return the total count of Pokemon entities stored in the database.")
    public Long getPokemonCount(){
        return this.service.getCountPokemon();
    }
}
