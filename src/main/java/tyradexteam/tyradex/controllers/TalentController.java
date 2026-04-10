package tyradexteam.tyradex.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tyradexteam.tyradex.models.dtos.PokemonDTO;
import tyradexteam.tyradex.models.dtos.TalentDTO;
import tyradexteam.tyradex.services.mapper.PokemonMapper;
import tyradexteam.tyradex.services.mapper.TalentMapper;
import tyradexteam.tyradex.services.repositories.PokemonRepository;
import tyradexteam.tyradex.services.repositories.TalentRepository;

import java.util.List;

@RestController
@RequestMapping("/talents")
public class TalentController {
    private final PokemonRepository pkmnRepo;
    private final TalentRepository repo;

    /**
     * Constructor for TalentController, inject the Pokemon Repository to use it in some routes
     * @param pokemonRepository The pokemon repository to use in the controller, it will be injected by Spring's dependency injection mechanism when the controller is instantiated. This repository will allow the controller to interact with the database and perform operations related to Pokemon entities, which may be necessary for handling requests related to talents.
     */
    public TalentController(
            PokemonRepository pokemonRepository,
            TalentRepository talentRepository
    ) {
        this.pkmnRepo = pokemonRepository;
        this.repo = talentRepository;
    }

    /**
     * Get all talents available in the database
     * @return All talents available
     */
    @GetMapping(value = {"/", ""}, produces = "application/json")
    public List<TalentDTO> getAll(){
        return this.repo.findAll().stream().map(TalentMapper::toDto).toList();
    }

    /**
     * Get all Pokemon with the same talent
     * @param talent The talent to search
     * @return All Pokemons with the talent
     */
    @GetMapping(value = "{talent}", produces = "application/json")
    public List<PokemonDTO> getPokemonByTalent(@PathVariable String talent) {
        return this.pkmnRepo.findByTalent(talent).stream().map(PokemonMapper::toDTO).toList();
    }
}
