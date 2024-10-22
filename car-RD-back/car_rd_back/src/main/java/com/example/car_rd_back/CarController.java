package com.example.car_rd_back;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.*;

@CrossOrigin(origins = "http://localhost:3000")  // 允许跨域请求
@RestController
@RequestMapping("/api")
public class CarController {

    @Autowired
    private JdbcTemplate jdbcTemplate;  // 用于连接 MySQL 数据库

    // 使用 Keys.secretKeyFor 生成一个安全的密钥
    private SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);  // 自动生成安全的密钥

    // 登录端点
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
        String username = loginData.get("username");
        String password = loginData.get("password");

        // 查询用户
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        List<Map<String, Object>> users = jdbcTemplate.queryForList(sql, username, password);

        if (users.size() == 1) {
            // 用户名和密码匹配，生成 JWT token
            Map<String, Object> user = users.get(0);
            String userId = String.valueOf(user.get("user_id"));

            // 生成 JWT token
            String jwtToken = Jwts.builder()
                    .setSubject(userId)  // 将 user_id 设置为 subject
                    .signWith(secretKey, SignatureAlgorithm.HS256)
                    .compact();

            Map<String, String> response = new HashMap<>();
            response.put("token", jwtToken);

            // 返回 token 给客户端
            return ResponseEntity.ok(response);
        } else {
            // 用户名或密码不匹配
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }

    // 解码 JWT，获取用户 ID
    private Integer getUserIdFromToken(String token) {
        try {
            String userIdStr = Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token.replace("Bearer ", ""))
                .getBody()
                .getSubject();  // 从 JWT token 中提取 user_id

            if (userIdStr == null || userIdStr.trim().isEmpty()) {
                return null;
            }
            return Integer.parseInt(userIdStr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping("/recommend")
    public ResponseEntity<?> recommendCars(@RequestBody Map<String, Object> searchData, 
                                           @RequestHeader(value = "Authorization", required = false) String token) {
        Integer userId = null;

        // 如果 token 存在，从 token 中提取 user_id
        if (token != null && !token.isEmpty()) {
            userId = getUserIdFromToken(token);
        }

        // 如果 userId 为空，不保存搜索记录，但仍然继续推荐流程
        if (userId != null) {
            // 保存搜索历史到数据库
            saveSearchHistory(userId, searchData);
        }

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
            e.printStackTrace(); // 打印异常堆栈，帮助调试
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error connecting to Flask service");
        }
    }

    
    private Double parseDoubleOrDefault(Object value, double defaultValue) {
        if (value == null || value.toString().trim().isEmpty()) {
            return defaultValue; // 如果为空字符串或null，则返回默认值
        }
        try {
            return Double.parseDouble(value.toString()); // 尝试解析为Double
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return defaultValue; // 如果解析失败，则返回默认值
        }
    }
    
    // 将搜索历史数据存储到 MySQL 数据库
    private void saveSearchHistory(Integer userId, Map<String, Object> searchData) {
        // 输出用户ID和搜索数据到控制台
        System.out.println("Inserting search history for user: " + userId);
        System.out.println("Search data: " + searchData);

        String sql = "INSERT INTO search_history (user_id, make, model, color, trim, body, transmission, vin, state, `condition`, min_odometer, max_odometer, interior, seller, mmr, min_price, max_price, search_time) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";

        // 执行SQL插入语句
        jdbcTemplate.update(sql, 
            userId, 
            searchData.getOrDefault("make", "Unknown"),
            searchData.getOrDefault("model", "Unknown"),
            searchData.getOrDefault("color", "Unknown"),
            searchData.getOrDefault("trim", "Unknown"),
            searchData.getOrDefault("body", "Unknown"),
            searchData.getOrDefault("transmission", "Unknown"),
            searchData.getOrDefault("vin", null),
            searchData.getOrDefault("state", "Unknown"),
            searchData.getOrDefault("condition", "Unknown"),
            searchData.getOrDefault("min_odometer", 0),
            searchData.getOrDefault("max_odometer", 0),
            searchData.getOrDefault("interior", "Unknown"),
            searchData.getOrDefault("seller", "Unknown"),
            parseDoubleOrDefault(searchData.get("mmr"), 0.0),
            parseDoubleOrDefault(searchData.get("minPrice"), 0.0),
            parseDoubleOrDefault(searchData.get("maxPrice"), 0.0)
        );



        // 输出完成插入的提示
        System.out.println("Search history inserted successfully for user: " + userId);
    }
}
