package com.example.test_micro_user.controoler;

import com.example.test_micro_user.model.dto.CarReadDto;
import com.example.test_micro_user.model.dto.UserCreateDto;
import com.example.test_micro_user.model.dto.UserDtoWithCars;
import com.example.test_micro_user.model.dto.UserReadDto;
import com.example.test_micro_user.model.entity.User;
import com.example.test_micro_user.service.CarServiceImpl;
import com.example.test_micro_user.service.UserService;
import com.example.test_micro_user.service.UserServiceImpl;
import com.example.test_micro_user.util.CarMapper;
import com.example.test_micro_user.util.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
public class UserRestController {
    private final CarMapper carMapper;

    private final UserService service;
    private final UserMapper userMapper;

    private final CarServiceImpl carService;

    public UserRestController(UserServiceImpl service, UserMapper userMapper, CarServiceImpl carService,
                              CarMapper carMapper) {
        this.service = service;
        this.userMapper = userMapper;
        this.carService = carService;
        this.carMapper = carMapper;
    }

    @GetMapping("/")
    public List<UserReadDto> getAllUsers() {
        return service.findAllUsers().stream().map(userMapper::userToUserReadDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserReadDto> getUserById(@PathVariable Long id) {
        User user = service.findUserById(id).get();
        UserReadDto userReadDto = userMapper.userToUserReadDto(user);
        return ResponseEntity.ok(userReadDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable Long id) {
        service.deleteUserById(id);
        Optional<User> userById = service.findUserById(id);
        return !userById.isPresent() ? new ResponseEntity<>(HttpStatus.OK)
                                    : new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/")
    public ResponseEntity<User> createUser (@RequestBody UserCreateDto userCreateDto) {
        User user = userMapper.userCreatDtoToUser(userCreateDto);
        service.createUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/{id}/usercars")
    public ResponseEntity<UserDtoWithCars> getUserWithHerCars(@PathVariable Long id) {
        User userWithCarsById = service.findUserWithCarsById(id);
        UserDtoWithCars userDtoWithCars = userMapper.userToUserDtoWithCar(userWithCarsById);
        return ResponseEntity.ok(userDtoWithCars);
    }

    @GetMapping("/{username}/cars")
    public ResponseEntity<List<CarReadDto>> getCars (@PathVariable String username) {
        return ResponseEntity.ok(carService.getCarsByUserName(username).stream().map(carMapper::carToCarReadDto).collect(Collectors.toList()));
    }
}
