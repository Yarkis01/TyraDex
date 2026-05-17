package tyradexteam.tyradex.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import tyradexteam.tyradex.models.dtos.ErrorResponseDTO;
import tyradexteam.tyradex.models.exceptions.PokemonNotFoundException;

/**
 * Global exception handler for the application.
 * Intercepts uncaught exceptions thrown by any controller and returns a structured JSON error response
 * instead of Spring Boot's default error page.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles requests to routes that don't exist.
     * Requires spring.mvc.throw-exception-if-no-handler-found=true and
     * spring.web.resources.add-mappings=false in application.properties.
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO handleNoHandlerFound(NoHandlerFoundException ex) {
        return new ErrorResponseDTO(404, "Not Found", "Route " + ex.getRequestURL() + " not found");
    }

    /**
     * Handles requests for a Pokemon that does not exist in the database.
     */
    @ExceptionHandler(PokemonNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponseDTO handlePokemonNotFound(PokemonNotFoundException ex) {
        return new ErrorResponseDTO(404, "Not Found", ex.getMessage());
    }
}
