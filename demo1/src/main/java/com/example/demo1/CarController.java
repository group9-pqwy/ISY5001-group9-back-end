package com.example.demo1;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:3000")  // 允许跨域请求
@RestController
@RequestMapping("/api")
public class CarController {

    // 示例数据源
    private List<Car> cars = new ArrayList<>(Arrays.asList(
            new Car(1L, "Toyota", "Corolla", "LE", "Sedan", "Automatic", "1234567890ABCDEFG", "CA", "Used", 50000, "White", "Black", "John Doe", 18000, 20000, 5, 2022, 5),
            new Car(2L, "Honda", "Civic", "EX", "Sedan", "Manual", "0987654321HGFEDCBA", "TX", "New", 10000, "Black", "Gray", "Jane Smith", 20000, 22000, 3, 2023, 1),
            new Car(3L, "Ford", "Explorer", "XLT", "SUV", "Automatic", "112233445566AABBCC", "NY", "Used", 30000, "Blue", "Beige", "Auto Trader", 28000, 30000, 2, 2021, 3),
            new Car(4L, "Tesla", "Model S", "Plaid", "Sedan", "Automatic", "123123123123ABCABC", "CA", "New", 1500, "Red", "White", "Elon Musk", 72000, 75000, 4, 2023, 1),
            new Car(5L, "Jeep", "Wrangler", "Rubicon", "SUV", "Manual", "998877665544ZZXXYY", "FL", "Used", 45000, "Green", "Black", "Jeep Dealership", 34000, 35000, 7, 2020, 4),
            new Car(6L, "Honda", "Civic", "LX", "Sedan", "Automatic", "667788990011223344", "NV", "Used", 25000, "Green", "Beige", "CarMax", 21000, 22000, 6, 2022, 2),
            new Car(7L, "Honda", "Civic", "Touring", "Sedan", "Automatic", "556677889900112233", "CA", "Used", 32000, "White", "Black", "Honda Certified", 22000, 23000, 2, 2022, 3)
    ));

    // 推荐汽车接口：支持所有属性作为可选参数
    @GetMapping("/recommend")
    public List<Car> recommendCars(@RequestParam(required = false) String make, 
                                   @RequestParam(required = false) String model,
                                   @RequestParam(required = false) String trim,
                                   @RequestParam(required = false) String body,
                                   @RequestParam(required = false) String transmission,
                                   @RequestParam(required = false) String vin,
                                   @RequestParam(required = false) String state,
                                   @RequestParam(required = false) String condition,
                                   @RequestParam(required = false) Integer odometer,
                                   @RequestParam(required = false) String color,
                                   @RequestParam(required = false) String interior,
                                   @RequestParam(required = false) String seller,
                                   @RequestParam(required = false) Double mmr,
                                   @RequestParam(required = false) Integer minPrice,
                                   @RequestParam(required = false) Integer maxPrice,
                                   @RequestParam(required = false) Integer saleMonth,
                                   @RequestParam(required = false) Integer saleYear,
                                   @RequestParam(required = false) Integer carAge) {
        return cars.stream()
                .filter(car -> (make == null || make.isEmpty() || car.getMake().equalsIgnoreCase(make)) &&
                               (model == null || model.isEmpty() || car.getModel().equalsIgnoreCase(model)) &&
                               (trim == null || trim.isEmpty() || car.getTrim().equalsIgnoreCase(trim)) &&
                               (body == null || body.isEmpty() || car.getBody().equalsIgnoreCase(body)) &&
                               (transmission == null || transmission.isEmpty() || car.getTransmission().equalsIgnoreCase(transmission)) &&
                               (vin == null || vin.isEmpty() || car.getVin().equalsIgnoreCase(vin)) &&
                               (state == null || state.isEmpty() || car.getState().equalsIgnoreCase(state)) &&
                               (condition == null || condition.isEmpty() || car.getCondition().equalsIgnoreCase(condition)) &&
                               (odometer == null || car.getOdometer() <= odometer) &&
                               (color == null || color.isEmpty() || car.getColor().equalsIgnoreCase(color)) &&
                               (interior == null || interior.isEmpty() || car.getInterior().equalsIgnoreCase(interior)) &&
                               (seller == null || seller.isEmpty() || car.getSeller().equalsIgnoreCase(seller)) &&
                               (mmr == null || car.getMmr() <= mmr) &&
                               (minPrice == null || car.getSellingPrice() >= minPrice) &&
                               (maxPrice == null || car.getSellingPrice() <= maxPrice) &&
                               (saleMonth == null || car.getSaleMonth() == saleMonth) &&
                               (saleYear == null || car.getSaleYear() == saleYear) &&
                               (carAge == null || car.getCarAge() == carAge))
                .collect(Collectors.toList());
    }

    // 获取汽车详情接口
    @GetMapping("/car-details/{id}")
    public ResponseEntity<Car> getCarDetails(@PathVariable Long id) {
        Optional<Car> car = cars.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();

        if (car.isPresent()) {
            return ResponseEntity.ok(car.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
