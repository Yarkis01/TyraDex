package tyradexteam.tyradex.services.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tyradexteam.tyradex.models.Pokemon;

/**
 * Repository interface for managing Pokemon entities in the database.
 * This interface extends CrudRepository, providing basic CRUD operations.
 */
@Repository
public interface PokemonRepository extends CrudRepository<Pokemon, String> {
}
