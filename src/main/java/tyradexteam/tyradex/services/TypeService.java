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
    private final TypeMapper mapper;

    /**
     *  Constructor for TypeService, which initializes the repository and PokemonService for handling business logic related to Type entities.
     * @param typeRepository The TypeRepository instance used for performing operations on Type entities in the database. This repository provides methods for retrieving and managing Type data.
     * @param mapper The TypeMapper instance used for converting between Type entities and TypeDTOs. This mapper facilitates the transformation of data between the database layer and the service layer, allowing for efficient data transfer and manipulation within the application.
     */
    public TypeService(
            TypeRepository typeRepository,
            TypeMapper mapper
    ) {
        this.repository = typeRepository;
        this.mapper = mapper;
    }

    /**
     * Method to retrieve all Type entities from the database. This method interacts with the repository to fetch data.
     * @return A list of TypeDTO objects representing all Type entities retrieved from the database. Each TypeDTO contains information about a specific type, which can be used for data transfer in the application.
     */
    public List<TypeDTO> findAll() {
        return this.mapper.toDto(this.repository.findAll());
    }
}
