package com.example.test_micro_user.util;

import com.example.test_micro_user.model.dto.CarReadDto;
import com.example.test_micro_user.model.entity.Car;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarReadDto carToCarReadDto(Car car);

    Car CarReadDtoToCar(CarReadDto dto);
}
