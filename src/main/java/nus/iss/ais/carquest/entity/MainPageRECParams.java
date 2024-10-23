package nus.iss.ais.carquest.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class MainPageRECParams {
    private String make;
    private String model;
    private String color;
    private String trim;
    private String body;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;

    public MainPageRECParams(String make, String model, String color, String trim, String body, BigDecimal minPrice, BigDecimal maxPrice) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.trim = trim;
        this.body = body;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }
    public MainPageRECParams() {
    }
}
