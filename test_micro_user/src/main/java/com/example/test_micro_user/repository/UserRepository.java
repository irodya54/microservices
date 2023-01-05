package com.example.test_micro_user.repository;

import com.example.test_micro_user.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findAll(Pageable pageable);

    Optional<User> findByUsername(String username);

    @Query("select u.username, u.name, u.lastname, u.cars from User as u join fetch Car where u.id = :id")
    User findUserWithHerCars(Long id);




}
