package com.example.questiontesting.controller;

import com.example.questiontesting.dto.QuestionDto;
import com.example.questiontesting.service.QuestionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/question")
@AllArgsConstructor
public class QuestionController {

    private QuestionService service; // создается конструктором согласно аннотации @AllArgsConstructor

    @GetMapping("/get/{id}")
    public ResponseEntity<QuestionDto> getQuestionDtoById(@PathVariable Long id) { // берет id из body запроса
        QuestionDto questionDto = service.getById(id);
        return ResponseEntity.ok().body(questionDto);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addQuestion(@RequestBody QuestionDto questionDto) {
        service.saveQuestion(questionDto);
        return ResponseEntity.ok().body("Added Question successfully");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateQuestion(@RequestBody QuestionDto questionDto, @PathVariable Long id) {
        questionDto.setId(id);
        service.saveQuestion(questionDto);
        return ResponseEntity.ok().body("Updated Question successfully");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Long id) {
        service.deleteQuestion(id);
        return ResponseEntity.ok().body("Deleted Question successfully");
    }

}
