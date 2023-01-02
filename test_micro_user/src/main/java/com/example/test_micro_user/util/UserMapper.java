package com.example.test_micro_user.util;

import com.example.test_micro_user.model.dto.UserCreateDto;
import com.example.test_micro_user.model.dto.UserDtoWithCars;
import com.example.test_micro_user.model.dto.UserReadDto;
import com.example.test_micro_user.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserReadDto userToUserReadDto (User user);

    User userCreatDtoToUser(UserCreateDto userCreateDto);

    UserCreateDto userToUserCreateDto(User user);

    User userDtoWithCarToUser(UserDtoWithCars dtoWithCars);

    UserDtoWithCars userToUserDtoWithCar(User user);
}
