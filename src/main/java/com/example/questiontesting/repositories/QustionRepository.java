package com.example.questiontesting.repositories;

import com.example.questiontesting.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QustionRepository extends JpaRepository<Question, Long> {
}
