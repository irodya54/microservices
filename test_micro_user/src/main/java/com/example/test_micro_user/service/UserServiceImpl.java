package com.example.test_micro_user.service;

import com.example.test_micro_user.model.entity.Car;
import com.example.test_micro_user.model.entity.User;
import com.example.test_micro_user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private CarService carService;

    public void deleteAllUsers() {
        repository.deleteAll();
    }

    public List<User> findAllUsers() {
        return repository.findAll();
    }

    public Optional<User> findUserById(Long id) {
        return repository.findById(id);
    }

    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }

    public User createUser(User user) {
        return repository.save(user);
    }

    public Optional<User> findByUserName(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public User findUserWithCarsById(Long id) {
        User user = null;
        if (repository.findById(id).isPresent()) {
            user = repository.findById(id).get();
            List<Car> cars = user.getCars();
            user.setCars(cars);
        }
        return user;
    }


}
