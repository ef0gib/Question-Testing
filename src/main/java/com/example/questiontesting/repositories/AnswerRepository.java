package com.example.questiontesting.repositories;

import com.example.questiontesting.entity.Answer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    @Override
    @EntityGraph(value = "answer-fields")
    Optional<Answer> findById(Long aLong);
}
