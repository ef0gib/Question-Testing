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
@AllArgsConstructor
public class ProfileController {

    private ProfileService service; // создается конструктором согласно аннотации @AllArgsConstructor

    @GetMapping("/get/{id}")
    public ProfileDto getProfileDtoById(@PathVariable Long id) { // берет id из body запроса
        System.out.println("ProfileController.ProfileDto");
        return service.getById(id);
    }
}
