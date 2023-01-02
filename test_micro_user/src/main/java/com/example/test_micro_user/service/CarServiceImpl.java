package com.example.test_micro_user.service;

import com.example.test_micro_user.model.dto.CarReadDto;
import com.example.test_micro_user.model.entity.Car;
import com.example.test_micro_user.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService{

    private final CarRepository repository;

    @Override
    public Optional<Car> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Car> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Car> getCarsByUserName(String username) {
        return repository.getCarByUserName(username);
    }
}
