package nus.iss.ais.carquest.controller;

import nus.iss.ais.carquest.entity.CarSearchRequest;
import nus.iss.ais.carquest.service.LoginService;
import nus.iss.ais.carquest.service.ModelService;
import nus.iss.ais.carquest.service.SearchHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private SearchHistoryService searchHistoryService;
    @Autowired
    private ModelService modelService;
    @Autowired
    private LoginService loginService;

    @PostMapping("/recommend")
    public ResponseEntity<?> recommendCars(@RequestBody CarSearchRequest carSearchRequest,
                                           @RequestHeader(value = "Authorization", required = false) String token) {
        Integer userId = null;
        if (token != null && !token.isEmpty()) {
            userId = loginService.getUserIdFromToken(token);
        }
        if (userId != null) {
            searchHistoryService.saveSearchHistory(userId, carSearchRequest);
        }
       return modelService.getRecommendations(carSearchRequest);
    }
}
