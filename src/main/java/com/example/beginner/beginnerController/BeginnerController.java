package com.example.beginner.beginnerController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeginnerController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from the SpringBoot for the first time!";
    }
}
