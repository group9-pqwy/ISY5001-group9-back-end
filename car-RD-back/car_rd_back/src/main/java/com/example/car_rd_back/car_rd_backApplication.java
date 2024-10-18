package com.example.car_rd_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class car_rd_backApplication {

    public static void main(String[] args) {
        SpringApplication.run(car_rd_backApplication.class, args);
    }
}