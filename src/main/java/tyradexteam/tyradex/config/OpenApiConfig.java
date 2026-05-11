package tyradexteam.tyradex.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI info() {
        return new OpenAPI()
            .info(new Info()
            .title("Tyradex API")
            .version("1.0.0")
            .description("API permettant de récupérer des données en rapport avec la licence Pokémon, orienté particulièrement sur les données des jeux-vidéos principaux de Pokémon.")
            .license(new License().name("MIT"))
        );
    }
}
