package tyradexteam.tyradex.services.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;
import tyradexteam.tyradex.models.Pokemon;

import java.util.List;

/**
 * Repository interface for managing Pokemon entities in the database.
 * This interface extends CrudRepository, providing basic CRUD operations.
 */
@Repository
public interface PokemonRepository extends Neo4jRepository<Pokemon, Integer> {
    @Query("MATCH (p:Pokemon)-[:IS_TYPED]->(t:TypePokemon)-[:NAMED]->(name:InternationalizedName) WHERE name.fr = $type OR name.en = $type MATCH q=(p)-[]->() RETURN q;")
    List<Pokemon> findByType(String type);
}
