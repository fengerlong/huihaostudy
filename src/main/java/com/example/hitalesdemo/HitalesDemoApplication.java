package com.example.hitalesdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class HitalesDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(HitalesDemoApplication.class, args);
    }

}
