package com.example.test_micro_user.integration;

import com.example.test_micro_user.IntegrationTestBase;
import com.example.test_micro_user.model.dto.CarReadDto;
import com.example.test_micro_user.model.dto.UserCreateDto;
import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@Transactional
public class UserControllerTest extends IntegrationTestBase {

    @Test
    void getUserById () throws Exception {
        System.out.println();
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/users/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(1))
                .andExpect(jsonPath("name").value("Ivan"))
                .andExpect(jsonPath("username").value("Ivan@mail.ru"));
    }

    @Test
    @Rollback(value = true)
    void isDeleteUserById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/users/{id}", 1))
                .andExpect(status().isOk());
        assertFalse(service.findUserById(1L).isPresent());
    }

    @Test
    void isCreatedUser() throws Exception {
        UserCreateDto user = UserCreateDto.builder()
                .username("testUser1@mail.ru")
                .name("test")
                .lastname("test")
                .birthdate(LocalDate.of(2000, 1, 1))
                .build();
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/users/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(user)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("username").value("testUser1@mail.ru"))
                .andExpect(jsonPath("name").value("test"))
                .andExpect(jsonPath("lastname").value("test"));
        assertEquals(service.findByUserName(user.getUsername()).get().getUsername(),"testUser1@mail.ru");
    }

    @Test
    void getCarsTest() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/users/{username}/cars", "Ivan@mail.ru"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()", is(2)))

                .andExpect(jsonPath("$.[0].model", is("Octavia")))
                .andExpect(jsonPath("$.[0].number", is("A955AA178")))

                .andExpect(jsonPath("$.[1].model", is("Rapid")))
                .andExpect(jsonPath("$.[1].number", is("A956AA147")));


    }
}
