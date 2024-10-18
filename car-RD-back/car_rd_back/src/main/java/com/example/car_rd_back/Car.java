package com.example.car_rd_back;

public class Car {
    private Long id;
    private String make;           // 品牌
    private String model;          // 车型
    private String trim;           // 车款
    private String body;           // 车身类型
    private String transmission;   // 变速箱类型
    private String vin;            // 车辆识别码
    private String state;          // 所在州
    private String condition;      // 车况
    private int odometer;          // 里程数
    private String color;          // 颜色
    private String interior;       // 内饰颜色
    private String seller;         // 卖家
    private double mmr;            // 市场批发价格
    private double sellingPrice;   // 销售价格
    private int saleMonth;         // 销售月份
    private int saleYear;          // 销售年份
    private int carAge;            // 车龄

    // 构造函数，getters 和 setters
    public Car(Long id, String make, String model, String trim, String body, String transmission, String vin,
               String state, String condition, int odometer, String color, String interior, String seller,
               double mmr, double sellingPrice, int saleMonth, int saleYear, int carAge) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.trim = trim;
        this.body = body;
        this.transmission = transmission;
        this.vin = vin;
        this.state = state;
        this.condition = condition;
        this.odometer = odometer;
        this.color = color;
        this.interior = interior;
        this.seller = seller;
        this.mmr = mmr;
        this.sellingPrice = sellingPrice;
        this.saleMonth = saleMonth;
        this.saleYear = saleYear;
        this.carAge = carAge;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getTrim() { return trim; }
    public void setTrim(String trim) { this.trim = trim; }

    public String getBody() { return body; }
    public void setBody(String body) { this.body = body; }

    public String getTransmission() { return transmission; }
    public void setTransmission(String transmission) { this.transmission = transmission; }

    public String getVin() { return vin; }
    public void setVin(String vin) { this.vin = vin; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }

    public int getOdometer() { return odometer; }
    public void setOdometer(int odometer) { this.odometer = odometer; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public String getInterior() { return interior; }
    public void setInterior(String interior) { this.interior = interior; }

    public String getSeller() { return seller; }
    public void setSeller(String seller) { this.seller = seller; }

    public double getMmr() { return mmr; }
    public void setMmr(double mmr) { this.mmr = mmr; }

    public double getSellingPrice() { return sellingPrice; }
    public void setSellingPrice(double sellingPrice) { this.sellingPrice = sellingPrice; }

    public int getSaleMonth() { return saleMonth; }
    public void setSaleMonth(int saleMonth) { this.saleMonth = saleMonth; }

    public int getSaleYear() { return saleYear; }
    public void setSaleYear(int saleYear) { this.saleYear = saleYear; }

    public int getCarAge() { return carAge; }
    public void setCarAge(int carAge) { this.carAge = carAge; }
}
