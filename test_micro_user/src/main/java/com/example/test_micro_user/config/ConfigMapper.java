package com.example.test_micro_user.config;

import com.example.test_micro_user.util.UserMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigMapper {


    @Bean
    public UserMapper userMapper() {
        return Mappers.getMapper(UserMapper.class);
    }
}
