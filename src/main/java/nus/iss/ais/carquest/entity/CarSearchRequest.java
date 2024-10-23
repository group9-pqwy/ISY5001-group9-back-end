package nus.iss.ais.carquest.entity;

import lombok.Data;

@Data
public class CarSearchRequest {
    private String make;
    private String model;
    private String color;
    private String trim;
    private String body;
    private String transmission;
    private String vin;
    private String state;
    private String condition;
    private Integer minOdometer;  // 改为 Integer
    private Integer maxOdometer;  // 改为 Integer
    private String interior;
    private String seller;
    private Double mmr;           // 改为 Double
    private Double minPrice;      // 改为 Double
    private Double maxPrice;      // 改为 Double
}
