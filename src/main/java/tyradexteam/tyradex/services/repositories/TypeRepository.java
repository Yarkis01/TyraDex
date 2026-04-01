package tyradexteam.tyradex.services.repositories;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import tyradexteam.tyradex.models.Type;

public interface TypeRepository extends Neo4jRepository<Type, String> {
}
