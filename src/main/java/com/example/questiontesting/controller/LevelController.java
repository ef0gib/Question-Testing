package com.example.questiontesting.controller;

import com.example.questiontesting.dto.LevelDto;
import com.example.questiontesting.service.LevelService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/level")
@AllArgsConstructor
public class LevelController {

    private LevelService service; // создается конструктором согласно аннотации @AllArgsConstructor

    @GetMapping("/get/{id}")
    public ResponseEntity<LevelDto> getLevelDtoById(@PathVariable Long id) { // берет id из body запроса
        LevelDto levelDto = service.getById(id);
        return ResponseEntity.ok().body(levelDto);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addLevel(@RequestBody LevelDto levelDto) {
        service.saveLevel(levelDto);
        return ResponseEntity.ok().body("Added Level successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateLevel(@RequestBody LevelDto levelDto, @PathVariable Long id) {
        levelDto.setId(id);
        service.saveLevel(levelDto);
        return ResponseEntity.ok().body("Updated Level successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteLevel(@PathVariable Long id) {
        service.deleteLevel(id);
        return ResponseEntity.ok().body("Deleted Level successfully");
    }

}
