package tyradexteam.tyradex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.config.EnableNeo4jAuditing;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableNeo4jAuditing
@EnableNeo4jRepositories(basePackages = {"tyradexteam.tyradex.services.repositories"})
public class TyradexApplication {

    public static void main(String[] args) {
        SpringApplication.run(TyradexApplication.class, args);
    }

}
