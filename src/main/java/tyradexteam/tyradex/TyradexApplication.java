package tyradexteam.tyradex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.neo4j.config.EnableNeo4jAuditing;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

/**
 * Main application class for the Tyradex Spring Boot application.
 * This class is responsible for bootstrapping the application and enabling necessary configurations for Neo4j integration.
 */
@SpringBootApplication
@EnableNeo4jAuditing
@EnableNeo4jRepositories(basePackages = {"tyradexteam.tyradex.services.repositories"})
@EnableCaching
public class TyradexApplication {
    /**
     * Main method to run the Spring Boot application.
     * @param args Command-line arguments passed to the application. This method initializes and starts the Spring Boot application context, allowing it to run and listen for incoming requests.
     */
    public static void main(String[] args) {
        SpringApplication.run(TyradexApplication.class, args);
    }

}
