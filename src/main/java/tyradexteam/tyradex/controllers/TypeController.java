package tyradexteam.tyradex.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tyradexteam.tyradex.models.dtos.PokemonDTO;
import tyradexteam.tyradex.models.dtos.TypeDTO;
import tyradexteam.tyradex.services.PokemonService;
import tyradexteam.tyradex.services.TypeService;

import java.util.List;

/**
 * Controller class for handling HTTP requests related to Type entities.
 */
@RestController
@RequestMapping("/types")
@Tag(name="TypeController", description = "Endpoints for retrieving Type entities and related data.")
public class TypeController {
    private final TypeService typeService;
    private final PokemonService pokemonService;

    /**
     * Constructor for type controller, inject the Type Service to use it in some routes
     * @param typeService The service used to have types
     * @param pokemonService The service used to have pokemons
     */
    public TypeController(TypeService typeService, PokemonService pokemonService) {
        this.typeService = typeService;
        this.pokemonService = pokemonService;
    }

    /**
     * Constructor for the TypeController class. This constructor takes a TypeRepository as a parameter and assigns it to the repository field of the controller. The TypeRepository is used to interact with the database and perform operations related to Type entities.
     * @return A new instance of the TypeController class, initialized with the provided TypeRepository for database interactions.
     */
    @GetMapping("")
    @Operation(summary = "Retrieve All Types", description = "Endpoint to retrieve all Type entities. This method will handle HTTP requests to the '/types' endpoint and return a collection of Type data.")
    public List<TypeDTO> findAll(){
        return this.typeService.findAll();
    }

    /**
     * Endpoint to retrieve Pokemon entities based on their type. This method will handle HTTP requests to the "/type/{type1}"
     * @param type1 The type of Pokemon to filter by, which can be provided in either French or English. The endpoint will match Pokemon nodes that are connected to a TypePokemon node with the specified name.
     * @return A list of Pokemon entities that match the specified type, retrieved from the service layer, which in turn interacts with the repository to fetch data from the database.
     */
    @GetMapping(value = "{type1}", produces = "application/json")
    @Operation(summary = "Retrieve Pokemon by Type", description = "Endpoint to retrieve Pokemon entities based on their type. The endpoint will match Pokemon nodes that are connected to a TypePokemon node with the specified name, which can be provided in either French or English.")
    public List<PokemonDTO> getPokemonByType(@PathVariable String type1) {
        return this.pokemonService.getPokemonByType(type1);
    }
}
