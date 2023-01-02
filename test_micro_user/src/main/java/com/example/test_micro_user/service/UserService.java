package com.example.test_micro_user.service;

import com.example.test_micro_user.model.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface UserService {
   void deleteAllUsers();

    List<User> findAllUsers();

    Optional<User> findUserById(Long id);

    void deleteUserById(Long id);

    User createUser(User user);

    Optional<User> findByUserName(String username);

    User findUserWithCarsById(Long id);
}
