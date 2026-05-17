package tyradexteam.tyradex.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Autowired
    private BuildProperties buildProperties;

    @Bean
    public OpenAPI info() {
        return new OpenAPI()
            .addServersItem(new Server()
                .url("https://api.tyradex.app/v3")
                .description("Tyradex - " + buildProperties.getVersion())
            )
            .info(new Info()
                .title("Tyradex API")
                .version(buildProperties.getVersion())
                .description("API permettant de récupérer des données en rapport avec la licence Pokémon, orienté particulièrement sur les données des jeux-vidéos principaux de Pokémon.")
                .license(new License().name("MIT"))
            );
    }
}
