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

            // 设置请求头，指定 Content-Type 为 application/json
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            // 构建请求数据，只包含 Flask 接口需要的字段
            Map<String, Object> requestData = new HashMap<>();

            // 添加 MainPageRECParams 中的字段
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

            // 添加 Flask 接口需要的其他字段，设置为 null
            requestData.put("year", null);
            requestData.put("transmission", null);
            requestData.put("interior", null);
            requestData.put("car_age", null);

            // 创建请求实体，包含请求头和请求体（requestData 对象）
            HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestData, headers);

            // 使用 ParameterizedTypeReference 来处理泛型类型
            ParameterizedTypeReference<List<Map<String, Object>>> responseType =
                    new ParameterizedTypeReference<List<Map<String, Object>>>() {};

            // 发送 POST 请求，并接收响应
            ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(
                    flaskUrl,
                    HttpMethod.POST,
                    requestEntity,
                    responseType
            );

            // 获取响应体
            List<Map<String, Object>> responseData = response.getBody();

            // 创建一个列表来存储 MainPageRECParams 对象
            List<MainPageRECReturnParams> resultList = new ArrayList<>();

            // 遍历响应数据，提取所需的属性
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
            // 处理异常
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    // 定义与 Flask 交互的方法
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
            e.printStackTrace(); // 打印异常堆栈
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error connecting to Flask service");
        }
    }
}
