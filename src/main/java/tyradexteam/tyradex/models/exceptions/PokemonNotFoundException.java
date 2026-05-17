package tyradexteam.tyradex.models.exceptions;

/**
 * Personalized exception thrown when a Pokemon entity is not found in the database.
 * This exception can be used to provide a clear error message when a requested Pokemon does not exist.
 */
public class PokemonNotFoundException extends RuntimeException {
    /**
     * Constructor for PokemonNotFoundException, which initializes the exception with a specific error message.
     * @param message The error message to be associated with this exception, providing details about the nature of the error (e.g., "Pokemon not found with id: X").
     */
    public PokemonNotFoundException(String message) {
        super(message);
    }
}
