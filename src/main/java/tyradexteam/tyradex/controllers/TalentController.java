package tyradexteam.tyradex.controllers;

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
    public List<TalentDTO> getAll(){
        return this.service.getAll();
    }

    /**
     * Get all Pokemon with the same talent
     * @param talent The talent to search
     * @return All Pokemons with the talent
     */
    @GetMapping(value = "{talent}", produces = "application/json")
    public List<PokemonDTO> getPokemonByTalent(@PathVariable String talent) {
        return this.service.getPokemonByTalent(talent.toLowerCase());
    }
}
