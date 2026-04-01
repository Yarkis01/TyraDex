package tyradexteam.tyradex.services.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tyradexteam.tyradex.models.Pokemon;

import java.util.List;

/**
 * Repository interface for managing Pokemon entities in the database.
 * This interface extends CrudRepository, providing basic CRUD operations.
 */
@Repository
public interface PokemonRepository extends PagingAndSortingRepository<Pokemon, Integer>, Neo4jRepository<Pokemon, Integer> {
    /**
     * Custom query to find Pokemon by their type. This method uses a Cypher query to match Pokemon nodes that are connected
     * @param type The type of Pokemon to filter by, which can be provided in either French or English. The query matches Pokemon nodes that are connected to a TypePokemon node with the specified name.
     * @return A list of Pokemon entities that match the specified type, retrieved from the database.
     */
    @Query("MATCH (p:Pokemon)-[:IS_TYPED]->(t:TypePokemon) WHERE t.name_fr = $type OR t.name_en = $type RETURN p;")
    List<Pokemon> findByType(String type);

    /**
     * Custom query to find Pokemon by their generation. This method uses a Cypher query to match Pokemon nodes that have a specific generation property.
     * @param generation The generation of Pokemon to filter by. The query matches Pokemon nodes that have a 'generation' property equal to the specified value.
     * @return A list of Pokemon entities that match the specified generation, retrieved from the database.
     */
    List<Pokemon> findByGeneration(Integer generation);

    /**
     * Custom query to find Pokemon by their talent. This method uses a Cypher query to match Pokemon nodes that are connected to a Talent node with a specific name.
     * @param nameTalent The name of the talent to filter by, which can be provided in French. The query matches Pokemon nodes that are connected to a Talent node with the specified name in French.
     * @return A list of Pokemon entities that match the specified talent, retrieved from the database.
     */
    @Query("MATCH (p:Pokemon)-[:HAS]->(t:Talent) WHERE t.name_fr=$nameTalent RETURN p")
    List<Pokemon> findByTalent(String nameTalent);
}
