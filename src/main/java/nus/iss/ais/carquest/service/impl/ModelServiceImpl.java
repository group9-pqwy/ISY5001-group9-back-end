package nus.iss.ais.carquest.service.impl;

import nus.iss.ais.carquest.entity.CarSearchRequest;
import nus.iss.ais.carquest.entity.MainPageRECParams;
import nus.iss.ais.carquest.entity.MainPageRECReturnParams;
import nus.iss.ais.carquest.service.ModelService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.*;

@Service
public class ModelServiceImpl implements ModelService {
    @Override
    public List<MainPageRECReturnParams> getMainPageRECList(MainPageRECParams mainPageRECParams) {
        String flaskUrl = "http://localhost:5000/recommend";

        try {
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            Map<String, Object> requestData = new HashMap<>();

            if (mainPageRECParams.getMake() != null) {
                requestData.put("make", mainPageRECParams.getMake());
            }
            if (mainPageRECParams.getModel() != null) {
                requestData.put("model", mainPageRECParams.getModel());
            }
            if (mainPageRECParams.getColor() != null) {
                requestData.put("color", mainPageRECParams.getColor());
            }
            if (mainPageRECParams.getTrim() != null) {
                requestData.put("trim", mainPageRECParams.getTrim());
            }
            if (mainPageRECParams.getBody() != null) {
                requestData.put("body", mainPageRECParams.getBody());
            }

            requestData.put("year", null);
            requestData.put("transmission", null);
            requestData.put("interior", null);
            requestData.put("car_age", null);

            HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestData, headers);

            ParameterizedTypeReference<List<Map<String, Object>>> responseType =
                    new ParameterizedTypeReference<List<Map<String, Object>>>() {};

            ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(
                    flaskUrl,
                    HttpMethod.POST,
                    requestEntity,
                    responseType
            );

            List<Map<String, Object>> responseData = response.getBody();

            List<MainPageRECReturnParams> resultList = new ArrayList<>();

            for (Map<String, Object> item : responseData) {
                String make = (String) item.get("make");
                String model = (String) item.get("model");
                String color = (String) item.get("color");
                String trim = (String) item.get("trim");
                String body = (String) item.get("body");
                Double price = (Double) item.get("sellingprice");

                MainPageRECReturnParams recParams = new MainPageRECReturnParams(make, model, color, trim, body, price);

                resultList.add(recParams);
            }

            return resultList;

        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    @Override
    public ResponseEntity<?> getRecommendations(CarSearchRequest carSearchRequest) {
        String flaskUrl = "http://localhost:5000/recommend";
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<List> response = restTemplate.postForEntity(flaskUrl, carSearchRequest, List.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                return ResponseEntity.ok(response.getBody());
            } else {
                return ResponseEntity.status(response.getStatusCode()).body("Error fetching recommendations from Flask");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error connecting to Flask service");
        }
    }
}
