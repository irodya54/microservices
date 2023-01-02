package com.example.test_micro_user.repository;

import com.example.test_micro_user.model.dto.CarReadDto;
import com.example.test_micro_user.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Long> {

    @Query(value = "select car \n" +
            "from Car car \n" +
            "where car.user.username = :username")
    List<Car> getCarByUserName(String username);
}
