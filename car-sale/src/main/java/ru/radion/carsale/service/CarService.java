package ru.radion.carsale.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.radion.carsale.model.entity.Car;
import ru.radion.carsale.repository.CarRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository repository;

    public Optional<Car> getCarById(Integer id) {
        return repository.findById(id);
    }

}
