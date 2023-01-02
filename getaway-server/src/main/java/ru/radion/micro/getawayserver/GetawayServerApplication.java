package ru.radion.micro.getawayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GetawayServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GetawayServerApplication.class, args);
    }

}
