package tyradexteam.tyradex.controllers;

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
@RequestMapping("/pokemon")
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
    @GetMapping(value = {"/", ""}, produces = "application/json")
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
    public List<PokemonDTO> getPokemonByName(@PathVariable String name) {
        return this.service.findPokemonByName(name);
    }

    /**
     * Endpoint to get the number of Pokemon in the database
     * @return The number of Pokemon in the database
     */
    @Cacheable("countPokemon")
    @GetMapping(value = "count", produces = "application/json")
    public Long getPokemonCount(){
        return this.service.getCountPokemon();
    }
}
