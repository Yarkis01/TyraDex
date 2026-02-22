package tyradexteam.tyradex.config;

import org.neo4j.cypherdsl.core.renderer.Dialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for setting up Neo4j database connection and related settings.
 * This class can be used to define beans and properties for Neo4j integration in the application.
 */
@Configuration
public class Neo4jConfig {
    @Bean
    org.neo4j.cypherdsl.core.renderer.Configuration cypherDslConfiguration() {
        return org.neo4j.cypherdsl.core.renderer.Configuration.newConfig()
            .withDialect(Dialect.NEO4J_5).build();
    }
}
