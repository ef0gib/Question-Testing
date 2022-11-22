package com.example.questiontesting.controller;

import com.example.questiontesting.dto.LevelDto;
import com.example.questiontesting.dto.ProfileDto;
import com.example.questiontesting.service.ProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(method = "GET", description = "Method gets Profile object by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Server's sent Profile object", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ProfileDto.class))
            }),
            @ApiResponse(responseCode = "500", description = "You've destroyed my server!")
    })
    public ResponseEntity<EntityModel<ProfileDto>> getProfileDtoById(@PathVariable Long id) { // берет id из body запроса
        System.out.println("ProfileController.getProfileDtoById(): id=" + id);
        EntityModel<ProfileDto> byId = service.getById(id);
        return ResponseEntity.ok().body(byId);
    }

    @PostMapping("/add")
    @Operation(method = "POST", description = "Method adds a new Profile object")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "New Profile object added into DB", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = String.class))
            }),
            @ApiResponse(responseCode = "500", description = "You've destroyed my server!")
    })
    public ResponseEntity<String> addProfile(@Parameter(name = "Profile", required = true)
                                                 @RequestBody ProfileDto profileDto) {
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
