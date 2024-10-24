package nus.iss.ais.carquest.service;

import nus.iss.ais.carquest.entity.CarSearchRequest;
import nus.iss.ais.carquest.entity.MainPageRECParams;
import nus.iss.ais.carquest.entity.MainPageRECReturnParams;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * ModelService interface defines the operations related to fetching recommendations for the main page
 * and specific car searches. It provides methods to retrieve recommended items based on input parameters.
 */
public interface ModelService {

    /**
     * Retrieves a list of recommended items for the main page based on the provided parameters.
     * This method fetches a list of recommendations tailored for display on the main page.
     *
     * @param mainPageRECParams the parameters that define the filtering and sorting criteria for main page recommendations.
     * @return a List of MainPageRECReturnParams containing the recommended items for the main page.
     */
    List<MainPageRECReturnParams> getMainPageRECList(MainPageRECParams mainPageRECParams);

    /**
     * Retrieves a list of car recommendations based on the provided car search request.
     * This method performs a search based on the car's specifications and user preferences,
     * and returns a list of recommended cars wrapped in a ResponseEntity.
     *
     * @param carSearchRequest the request object containing the car search criteria, including filters such as brand, model, price range, etc.
     * @return a ResponseEntity containing the recommended cars or an appropriate error message if the search fails.
     */
    ResponseEntity<?> getRecommendations(CarSearchRequest carSearchRequest);
}
