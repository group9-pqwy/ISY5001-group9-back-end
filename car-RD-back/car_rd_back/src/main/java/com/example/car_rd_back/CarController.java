package com.example.car_rd_back;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")  // 允许跨域请求
@RestController
@RequestMapping("/api")
public class CarController {

    @PostMapping("/recommend")
    public ResponseEntity<?> recommendCars(@RequestBody Map<String, Object> searchData) {
        // 将前端的数据传递到Flask模型服务
        System.out.println("Received search data from frontend: " + searchData);  // 打印前端传来的数据
        String flaskUrl = "http://localhost:5000/recommend"; // Flask的API端点

        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<List> response = restTemplate.postForEntity(flaskUrl, searchData, List.class);

            if (response.getStatusCode() == HttpStatus.OK) {
                return ResponseEntity.ok(response.getBody()); // 返回推荐的汽车列表给前端
            } else {
                return ResponseEntity.status(response.getStatusCode()).body("Error fetching recommendations from Flask");
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error connecting to Flask service");
        }
    }
}

