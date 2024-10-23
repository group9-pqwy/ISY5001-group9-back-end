package nus.iss.ais.carquest.service;

import nus.iss.ais.carquest.entity.CarSearchRequest;
import nus.iss.ais.carquest.entity.MainPageRECParams;
import nus.iss.ais.carquest.entity.MainPageRECReturnParams;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public interface ModelService {
    List<MainPageRECReturnParams> getMainPageRECList(MainPageRECParams mainPageRECParams);
    ResponseEntity<?> getRecommendations(CarSearchRequest carSearchRequest);
}
