package com.example.test_micro_user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableEurekaClient
public class TestMicroUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestMicroUserApplication.class, args);
    }

}
