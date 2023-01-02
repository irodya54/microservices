package com.example.test_micro_user.service;

import com.example.test_micro_user.model.dto.CarReadDto;
import com.example.test_micro_user.model.entity.Car;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface CarService {
    Optional<Car> findById(Long id);
    List<Car> findAll();

    List<Car> getCarsByUserName(String username);
}
