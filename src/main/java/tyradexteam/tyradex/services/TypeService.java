package tyradexteam.tyradex.services;

import org.springframework.stereotype.Service;
import tyradexteam.tyradex.models.dtos.TypeDTO;
import tyradexteam.tyradex.services.mapper.TypeMapper;
import tyradexteam.tyradex.services.repositories.TypeRepository;

import java.util.List;

/**
 * Service class for managing Type entities. This class provides business logic and interacts with the TypeRepository
 * to perform operations related to Type data in the database.
 */
@Service
public class TypeService {
    private final TypeRepository repository;

    /**
     *  Constructor for TypeService, which initializes the repository and PokemonService for handling business logic related to Type entities.
     * @param typeRepository The TypeRepository instance used for performing operations on Type entities in the database. This repository provides methods for retrieving and managing Type data.
     * @param pokemonService The PokemonService instance used for performing operations related to Pokemon entities.
     *                       This service can be utilized within the TypeService to handle any business logic that may involve interactions between Type and Pokemon entities, such as retrieving Pokemon based on their types or managing relationships between them.
     */
    public TypeService(TypeRepository typeRepository) {
        this.repository = typeRepository;
    }

    /**
     * Method to retrieve all Type entities from the database. This method interacts with the repository to fetch data.
     * @return A list of TypeDTO objects representing all Type entities retrieved from the database. Each TypeDTO contains information about a specific type, which can be used for data transfer in the application.
     */
    public List<TypeDTO> findAll() {
        return TypeMapper.toDto(this.repository.findAll());
    }
}
