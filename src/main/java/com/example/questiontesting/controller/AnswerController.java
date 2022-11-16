package com.example.questiontesting.controller;

import com.example.questiontesting.dto.AnswerDto;
import com.example.questiontesting.service.AnswerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/answer")
@AllArgsConstructor
public class AnswerController {

    private AnswerService service; // создается конструктором согласно аннотации @AllArgsConstructor

    @GetMapping("/get/{id}")
    public ResponseEntity<AnswerDto> getAnswerDtoById(@PathVariable Long id) { // берет id из body запроса
        AnswerDto answerDto = service.getById(id);
        return ResponseEntity.ok().body(answerDto);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addAnswer(@RequestBody AnswerDto answerDto) {
        service.saveAnswer(answerDto);
        return ResponseEntity.ok().body("Added Answer successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateAnswer(@RequestBody AnswerDto answerDto, @PathVariable Long id) {
        answerDto.setId(id);
        service.saveAnswer(answerDto);
        return ResponseEntity.ok().body("Updated Answer successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAnswer(@PathVariable Long id) {
        service.deleteAnswer(id);
        return ResponseEntity.ok().body("Deleted Answer successfully");
    }

}
