package com.example.test_micro_user.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserCreateDto {
    private String name;
    private String username;
    private String lastname;
    private LocalDate birthdate;

}
