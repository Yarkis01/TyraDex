package tyradexteam.tyradex.services.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import tyradexteam.tyradex.models.Pokemon;
import tyradexteam.tyradex.models.dtos.GenerationInfoDTO;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for managing Pokemon entities in the database.
 * This interface extends CrudRepository, providing basic CRUD operations.
 */
@Repository
public interface PokemonRepository extends PagingAndSortingRepository<Pokemon, Integer>, Neo4jRepository<Pokemon, Integer> {
    /**
     * Get all Pokemon with minimal informations to show only the sprite and the name of the Pokemon. This method uses a custom query to optimize performance in the neo4J database.
     * @return All Pokemons with only the name and the sprite of the Pokemon, retrieved from the database.
     */
    @Query(
    """
        MATCH (n:Pokemon)-[r:IS_TYPED]-(t)
        MATCH (n)-[r:IS_TYPED]-(m)
        RETURN n, collect(r), collect(m)
        ORDER BY n.pokedex_id;
    """
    )
    List<Pokemon> findAllLight();

    /**
     * Get all Pokemon with a custom query to optimize performance in the neo4J database.
     * @return All Pokemons with all informations
     */
    @Query(
    """
        MATCH (n:Pokemon)
        OPTIONAL MATCH (n)-[r:IS_TYPED|GROUPED_IN|HAS]-(m)
        OPTIONAL MATCH (n)-[r_w:WAS]->(m_ew:Pokemon)
        OPTIONAL MATCH (n)-[r_n:NEXT]->(m_en:Pokemon)
        RETURN n, collect(r), collect(r_w), collect(r_n), collect(m), collect(m_ew), collect(m_en)
        ORDER BY n.pokedex_id ASC;
    """
    )
    List<Pokemon> findAllCustom();

    /**
     * Custom query to find Pokemon by their type. This method uses a Cypher query to match Pokemon nodes that are connected
     * @param type The type of Pokemon to filter by, which can be provided in either French or English. The query matches Pokemon nodes that are connected to a TypePokemon node with the specified name.
     * @return A list of Pokemon entities that match the specified type, retrieved from the database.
     */
    @Query("MATCH (p:Pokemon)-[:IS_TYPED]->(t:TypePokemon) WHERE toLower(t.name_fr) = $type OR toLower(t.name_en) = $type ORDER BY p.pokedex_id ASC RETURN p;")
    List<Pokemon> findByType(String type);

    /**
     * Custom query to find Pokemon by their generation. This method uses a Cypher query to match Pokemon nodes that have a specific generation property.
     * @param generation The generation of Pokemon to filter by. The query matches Pokemon nodes that have a 'generation' property equal to the specified value.
     * @return A list of Pokemon entities that match the specified generation, retrieved from the database.
     */
    List<Pokemon> findByGeneration(Integer generation);

    /**
     * Custom query to retrieve information about all Pokemon generations, including their Pokedex ID ranges. This method uses a Cypher query to group Pokemon nodes by their generation property and calculate the minimum and maximum Pokedex ID for each generation.
     * @return A list of GenerationInfoDTO objects containing information about all Pokemon generations, retrieved from the database. Each GenerationInfoDTO object includes details such as the generation number, name, and other relevant information about that generation, along with the minimum and maximum Pokedex ID for that generation.
     */
    @Query("MATCH (p:Pokemon) RETURN p.generation AS generation, min(p.pokedex_id) AS `from`, max(p.pokedex_id) AS `to` ORDER BY p.generation ASC")
    List<GenerationInfoDTO> findAllGenerationInfo();

    /**
     * Custom query to find Pokemon by their talent. This method uses a Cypher query to match Pokemon nodes that are connected to a Talent node with a specific name.
     * @param nameTalent The name of the talent to filter by, which can be provided in French. The query matches Pokemon nodes that are connected to a Talent node with the specified name in French.
     * @return A list of Pokemon entities that match the specified talent, retrieved from the database.
     */
    @Query("MATCH (p:Pokemon)-[:HAS]->(t:Talent), (p)-[r:IS_TYPED|GROUPED_IN|HAS|WAS|NEXT]-(m) WHERE toLower(t.name_fr)=$nameTalent OR toLower(t.name_en)=$nameTalent ORDER BY p.pokedex_id ASC RETURN p, collect(r), collect(m) ORDER BY p.pokedex_id ASC;")
    List<Pokemon> findByTalent(String nameTalent);

    /**
     * Custom query to find Pokemon by their name. This method uses a Cypher query to match Pokemon nodes that have a specific generation property.
     * @param name Name of the Pokemon to filter by, which can be provided in French, or English.
     * @return A list of Pokemon entities that match the specified name, retrieved from the database. The query matches Pokemon nodes that have a 'name_fr' or 'name_en' property equal to the specified name, and also retrieves their related nodes and relationships.
     */
    @Query(
    """
        MATCH (p:Pokemon), (p)-[r:IS_TYPED|GROUPED_IN|HAS|WAS|NEXT]-(m)
        WHERE toLower(p.name_fr) = toLower($name)
        OR toLower(p.name_en) = toLower($name)
        RETURN p, collect(r), collect(m)
        ORDER BY p.pokedex_id ASC;
    """)
    Optional<Pokemon> findByName(String name);


    /**
     * Custom query to search for Pokemon by a partial name match.
     * This method uses a Cypher query to find Pokemon whose French or English name contains the search string.
     *
     * @param name Le texte saisi par l'utilisateur dans la barre de recherche.
     * @return Une liste (List) d'entités Pokemon qui contiennent la chaîne de caractères spécifiée.
     */
    @Query(
    """
        MATCH (p:Pokemon), (p)-[r:IS_TYPED|GROUPED_IN|HAS|WAS|NEXT]-(m)
        WHERE toLower(p.name_fr) CONTAINS toLower($name)
        OR toLower(p.name_en) CONTAINS toLower($name)
        RETURN p, collect(r), collect(m)
        ORDER BY p.pokedex_id ASC;
    """
    )
    List<Pokemon> searchByPartialName(String name);
}
