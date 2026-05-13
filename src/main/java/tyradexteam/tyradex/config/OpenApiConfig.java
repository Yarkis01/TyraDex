package tyradexteam.tyradex.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class configuration for OpenAPI.
 */
@Configuration
public class OpenApiConfig {
    /**
     * Configuration for the documentation of the API in OpenAPI & Swagger
     * @return The OpenAPI configuration
     */
    @Bean
    public OpenAPI info() {
        return new OpenAPI()
            .info(new Info()
            .title("Tyradex API")
            .version("3.0.0")
            .description("API permettant de récupérer des données en rapport avec la licence Pokémon, orienté particulièrement sur les données des jeux-vidéos principaux de Pokémon.")
            .license(new License().name("MIT"))
        );
    }
}
