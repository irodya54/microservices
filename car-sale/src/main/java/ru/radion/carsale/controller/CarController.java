package ru.radion.carsale.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.radion.carsale.model.entity.Car;
import ru.radion.carsale.service.CarService;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/car")
public class CarController {


    private CarService carService;

    public CarController() {
    }


    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Integer id) {
        Optional<Car> carReadDto = carService.getCarById(id);
        return carReadDto.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
