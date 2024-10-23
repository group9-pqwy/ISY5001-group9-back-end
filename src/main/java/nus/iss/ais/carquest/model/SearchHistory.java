package nus.iss.ais.carquest.model;

import java.math.BigDecimal;
import java.util.Date;

public class SearchHistory {
    private Integer searchId;

    private Integer userId;

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

    private BigDecimal mmr;

    private BigDecimal minPrice;

    private BigDecimal maxPrice;

    private Date searchTime;

    public Integer getSearchId() {
        return searchId;
    }

    public void setSearchId(Integer searchId) {
        this.searchId = searchId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Integer getMinOdometer() {
        return minOdometer;
    }

    public void setMinOdometer(Integer minOdometer) {
        this.minOdometer = minOdometer;
    }

    public Integer getMaxOdometer() {
        return maxOdometer;
    }

    public void setMaxOdometer(Integer maxOdometer) {
        this.maxOdometer = maxOdometer;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public BigDecimal getMmr() {
        return mmr;
    }

    public void setMmr(BigDecimal mmr) {
        this.mmr = mmr;
    }

    public BigDecimal getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(BigDecimal minPrice) {
        this.minPrice = minPrice;
    }

    public BigDecimal getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(BigDecimal maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Date getSearchTime() {
        return searchTime;
    }

    public void setSearchTime(Date searchTime) {
        this.searchTime = searchTime;
    }
}