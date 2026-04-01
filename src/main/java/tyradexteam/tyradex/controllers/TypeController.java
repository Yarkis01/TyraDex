package tyradexteam.tyradex.controllers;

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
public class TypeController {
    private final TypeService typeService;
    private final PokemonService pokemonService;

    public TypeController(TypeService typeService, PokemonService pokemonService) {
        this.typeService = typeService;
        this.pokemonService = pokemonService;
    }

    /**
     * Constructor for the TypeController class. This constructor takes a TypeRepository as a parameter and assigns it to the repository field of the controller. The TypeRepository is used to interact with the database and perform operations related to Type entities.
     * @return A new instance of the TypeController class, initialized with the provided TypeRepository for database interactions.
     */
    @GetMapping("")
    public List<TypeDTO> findAll(){
        return this.typeService.findAll();
    }

    /**
     * Endpoint to retrieve Pokemon entities based on their type. This method will handle HTTP requests to the "/type/{type1}"
     * @param type1 The type of Pokemon to filter by, which can be provided in either French or English. The endpoint will match Pokemon nodes that are connected to a TypePokemon node with the specified name.
     * @return A list of Pokemon entities that match the specified type, retrieved from the service layer, which in turn interacts with the repository to fetch data from the database.
     */
    @GetMapping(value = "{type1}", produces = "application/json")
    public List<PokemonDTO> getPokemonByType(@PathVariable String type1) {
        return this.pokemonService.getPokemonByType(type1);
    }
}
