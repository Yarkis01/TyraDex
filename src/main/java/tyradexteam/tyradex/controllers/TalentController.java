package tyradexteam.tyradex.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tyradexteam.tyradex.models.dtos.PokemonDTO;
import tyradexteam.tyradex.models.dtos.TalentDTO;
import tyradexteam.tyradex.services.TalentService;

import java.util.List;

@RestController
@RequestMapping("/talents")
@Tag(name="TalentController", description = "Endpoints for retrieving Talent entities and related data.")
public class TalentController {
    private final TalentService service;

    /**
     * Constructor for TalentController, inject the Talent Service to use it in some routes
     * @param talentService
     */
    public TalentController(
            TalentService talentService
    ) {
        this.service = talentService;
    }

    /**
     * Get all talents available in the database
     * @return All talents available
     */
    @GetMapping(value = {"/", ""}, produces = "application/json")
    @Operation(summary = "Retrieve All Talents", description = "Endpoint to retrieve all Talent entities. This method will handle HTTP requests to the '/talents' endpoint and return a collection of Talent data.")
    public List<TalentDTO> getAll(){
        return this.service.getAll();
    }

    /**
     * Get all Pokemon with the same talent
     * @param talent The talent to search
     * @return All Pokemons with the talent
     */
    @GetMapping(value = "{talent}", produces = "application/json")
    @Operation(summary = "Retrieve Pokemon by Talent", description = "Endpoint to retrieve Pokemon entities based on their talent. The endpoint will match Pokemon nodes that are connected to a Talent node with the specified name.")
    public List<PokemonDTO> getPokemonByTalent(@PathVariable String talent) {
        return this.service.getPokemonByTalent(talent.toLowerCase());
    }
}
