package com.example.questiontesting.controller;

import com.example.questiontesting.dto.LevelDto;
import com.example.questiontesting.dto.ProfileDto;
import com.example.questiontesting.service.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
@AllArgsConstructor
public class ProfileController {

    private ProfileService service; // создается конструктором согласно аннотации @AllArgsConstructor

    @GetMapping("/get/{id}")
    public ResponseEntity<EntityModel<ProfileDto>> getProfileDtoById(@PathVariable Long id) { // берет id из body запроса
        System.out.println("ProfileController.getProfileDtoById(): id=" + id);
        EntityModel<ProfileDto> byId = service.getById(id);
        return ResponseEntity.ok().body(byId);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addProfile(@RequestBody ProfileDto profileDto) {
        service.saveProfile(profileDto);
        return ResponseEntity.ok().body("Added Profile successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProfile(@RequestBody ProfileDto profileDto, @PathVariable Long id) {
        profileDto.setId(id);
        service.saveProfile(profileDto);
        return ResponseEntity.ok().body("Updated Profile successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProfile(@PathVariable Long id) {
        service.deleteProfile(id);
        return ResponseEntity.ok().body("Deleted Profile successfully");
    }

}
