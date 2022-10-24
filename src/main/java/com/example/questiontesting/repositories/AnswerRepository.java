package com.example.questiontesting.repositories;

import com.example.questiontesting.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
