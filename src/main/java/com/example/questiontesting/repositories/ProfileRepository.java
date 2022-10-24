package com.example.questiontesting.repositories;

import com.example.questiontesting.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

/*
    @Override // пример переопределения метода JPA
    Optional<Profile> findById(Long aLong);

    Optional<Profile> findByIdAndName(Long id, String name); // пример конструирования метода
*/
}
