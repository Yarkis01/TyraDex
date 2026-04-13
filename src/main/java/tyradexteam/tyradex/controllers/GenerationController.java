package tyradexteam.tyradex.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tyradexteam.tyradex.models.dtos.PokemonDTO;
import tyradexteam.tyradex.services.GenerationService;

import java.util.List;

/**
 * Controller class for handling HTTP requests related to Pokemon entities filtered by generation.
 * This class defines an endpoint for retrieving Pokemon data based on their generation,
 * and interacts with the PokemonService to perform business logic operations related to fetching Pokemon by generation.
 */
@RestController
@RequestMapping("/gen")
public class GenerationController {
    private final GenerationService service;

    /**
     * Constructor for GenerationController, which initializes the service for handling business logic related to Pokemon entities.
     * @param generationService The PokemonService instance used for performing operations on Pokemon data, specifically for retrieving Pokemon based on their generation. This service will be injected by Spring's dependency injection mechanism when the controller is instantiated.
     */
    public GenerationController(GenerationService generationService) {
        this.service = generationService;
    }

    /**
     * Endpoint to retrieve Pokemon entities based on their generation. This method will handle HTTP requests to the "/generation/{generation}"
     * @param generation The generation of Pokemon to filter by. The endpoint will match Pokemon nodes that have a 'generation' property equal to the specified value.
     * @return A list of Pokemon entities that match the specified generation, retrieved from the service layer, which in turn interacts with the repository to fetch data from the database.
     */
    @GetMapping(value = "{generation}", produces = "application/json")
    public List<PokemonDTO> getPokemonByGeneration(@PathVariable Integer generation) {
        return this.service.getPokemonByGeneration(generation);
    }
}
