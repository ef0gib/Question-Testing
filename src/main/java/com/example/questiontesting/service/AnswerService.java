package com.example.questiontesting.service;

import com.example.questiontesting.dto.AnswerDto;
import com.example.questiontesting.entity.Answer;
import com.example.questiontesting.exception.NotFoundAnswerException;
import com.example.questiontesting.repositories.AnswerRepository;
import com.example.questiontesting.util.Mapper;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    private AnswerRepository answerRepository;
    private Mapper mapper;

    public AnswerService(AnswerRepository answerRepository, Mapper mapper) {
        this.answerRepository = answerRepository;
        this.mapper = mapper;
    }

    public AnswerDto getById(Long id) {
        Answer answer = answerRepository.findById(id).orElseThrow(() -> new NotFoundAnswerException(id));// метод hibernate
        AnswerDto answerDto = mapper.mapper(answer, AnswerDto.class);
        return answerDto;
    }

    public void saveAnswer(AnswerDto answerDto) {
        Answer answer = mapper.mapper(answerDto, Answer.class);
        answerRepository.save(answer);
    }

    public void deleteAnswer(Long id) {
        Answer answer = answerRepository.findById(id).orElseThrow(() -> new NotFoundAnswerException(id));
        answerRepository.delete(answer);
    }
}
