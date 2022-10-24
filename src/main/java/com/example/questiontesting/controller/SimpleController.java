package com.example.questiontesting.controller;

import com.example.questiontesting.dto.ProfileDto;
import com.example.questiontesting.service.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
//@AllArgsConstructor
public class SimpleController {

//    private ProfileService service; // создается конструкторм согласно аннотации @AllArgsConstructor

    @GetMapping("/myget")
    public String getStringForGet() { // берет id из body запроса
        return "That was my getStringForGet";
    }
}
