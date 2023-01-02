package com.example.test_micro_user.model.dto;

import com.example.test_micro_user.model.entity.Car;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Stream;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDtoWithCars {
    private Long id;
    private String username;
    private String name;
    private String lastname;

    private List<CarReadDto> cars;

}
