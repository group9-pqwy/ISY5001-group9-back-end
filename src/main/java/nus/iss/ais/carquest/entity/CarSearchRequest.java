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
    private Integer minOdometer;
    private Integer maxOdometer;
    private String interior;
    private String seller;
    private Double mmr;
    private Double minPrice;
    private Double maxPrice;
}
