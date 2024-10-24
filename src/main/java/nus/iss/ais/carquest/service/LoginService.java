package nus.iss.ais.carquest.service;

/**
 * LoginService interface defines the operations related to user authentication and token management.
 * It provides methods to handle user login and retrieve user information based on the provided token.
 */
public interface LoginService {

    /**
     * Logs in a user using the provided username and password.
     * This method performs user authentication and returns a token if the credentials are valid.
     *
     * @param username the username of the user attempting to log in.
     * @param password the password of the user attempting to log in.
     * @return a String token that represents the user's session if authentication is successful.
     *         Returns null if the authentication fails.
     */
    String login(String username, String password);

    /**
     * Retrieves the user ID from a given token.
     * This method extracts and returns the user ID embedded within the provided authentication token.
     *
     * @param token the authentication token from which the user ID is to be extracted.
     * @return an Integer representing the user ID if the token is valid.
     *         Returns null if the token is invalid or does not contain a valid user ID.
     */
    Integer getUserIdFromToken(String token);
}
