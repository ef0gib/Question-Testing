package com.example.questiontesting.service;

import com.example.questiontesting.dto.QuestionDto;
import com.example.questiontesting.entity.Question;
import com.example.questiontesting.exception.NotFoundQuestionException;
import com.example.questiontesting.repositories.QuestionRepository;
import com.example.questiontesting.util.Mapper;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;
    private Mapper mapper;

    public QuestionService(QuestionRepository questionRepository, Mapper mapper) {
        this.questionRepository = questionRepository;
        this.mapper = mapper;
    }

    public QuestionDto getById(Long id) {
        Question question = questionRepository.findById(id).orElseThrow(() -> new NotFoundQuestionException(id));// метод hibernate
        QuestionDto questionDto = mapper.mapper(question, QuestionDto.class);
        return questionDto;
    }

    public void saveQuestion(QuestionDto questionDto) {
        Question question = mapper.mapper(questionDto, Question.class);
        questionRepository.save(question);
    }

    public void deleteQuestion(Long id) {
        Question question = questionRepository.findById(id).orElseThrow(() -> new NotFoundQuestionException(id));
        questionRepository.delete(question);
    }
}
