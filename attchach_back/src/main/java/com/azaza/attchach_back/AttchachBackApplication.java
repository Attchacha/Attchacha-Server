package com.azaza.attchach_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AttchachBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(AttchachBackApplication.class, args);
    }

}
