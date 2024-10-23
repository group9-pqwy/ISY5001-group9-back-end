package nus.iss.ais.carquest.entity;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class MainPageRECReturnParams {
    private String make;
    private String model;
    private String color;
    private String trim;
    private String body;
    private Double price;
    public MainPageRECReturnParams(String make, String model, String color, String trim, String body, Double price) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.trim = trim;
        this.body = body;
        this.price = price;
    }
    public MainPageRECReturnParams() {
    }
}
