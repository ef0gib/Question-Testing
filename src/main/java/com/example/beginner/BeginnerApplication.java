package com.example.beginner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class BeginnerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeginnerApplication.class, args);
        System.out.println("Hii!");
    }

}


