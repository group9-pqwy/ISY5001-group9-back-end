package nus.iss.ais.carquest.service;

import nus.iss.ais.carquest.entity.CarSearchRequest;
import nus.iss.ais.carquest.entity.MainPageRECParams;

/**
 * SearchHistoryService interface defines operations related to managing and retrieving user search history.
 * It provides methods to fetch a user's search history and save new search records.
 */
public interface SearchHistoryService {

    /**
     * Retrieves the search history of a specific user.
     * This method fetches the user's previous search parameters based on their user ID.
     *
     * @param userId the unique identifier of the user whose search history is to be retrieved.
     * @return a MainPageRECParams object containing the search parameters from the user's most recent search history.
     *         Returns null if no search history is found for the user.
     */
    MainPageRECParams getUserSearchHistory(Integer userId);

    /**
     * Saves a user's search request to their search history.
     * This method stores the search parameters associated with a specific user ID for future reference.
     *
     * @param userId the unique identifier of the user whose search history is to be updated.
     * @param carSearchRequest the search request object containing the car search parameters to be saved in the user's history.
     */
    void saveSearchHistory(Integer userId, CarSearchRequest carSearchRequest);
}
