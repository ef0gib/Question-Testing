package com.example.questiontesting.repositories;

import com.example.questiontesting.entity.Level;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LevelRepository extends JpaRepository<Level, Long> {
    @Override
    @EntityGraph(value = "level-fields")
    Optional<Level> findById(Long aLong);
}
