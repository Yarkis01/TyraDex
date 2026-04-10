package tyradexteam.tyradex.services.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import tyradexteam.tyradex.models.Talent;

/**
 * Repository interface for managing Pokemon talents in the database.
 * This interface will define methods for performing CRUD operations and custom queries related to talents,
 * allowing the application to interact with the database and retrieve information about Pokemon talents as needed.
 */
public interface TalentRepository extends Neo4jRepository<Talent, String> {
}
