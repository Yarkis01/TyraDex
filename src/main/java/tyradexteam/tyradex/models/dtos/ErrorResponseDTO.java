package tyradexteam.tyradex.models.dtos;

/**
 * Standardized JSON body returned for all error responses.
 * @param status HTTP status code (e.g. 404)
 * @param error Short description of the error type (e.g. "Not Found")
 * @param message Detailed message explaining the error
 */
public record ErrorResponseDTO(int status, String error, String message) {}
