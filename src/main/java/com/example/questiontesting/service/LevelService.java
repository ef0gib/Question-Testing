package com.example.questiontesting.service;

import com.example.questiontesting.dto.LevelDto;
import com.example.questiontesting.entity.Level;
import com.example.questiontesting.entity.Profile;
import com.example.questiontesting.exception.NotFoundLevelException;
import com.example.questiontesting.exception.NotFoundProfileException;
import com.example.questiontesting.repositories.LevelRepository;
import com.example.questiontesting.util.Mapper;
import org.springframework.stereotype.Service;

@Service
public class LevelService {

    private LevelRepository levelRepository;
    private Mapper mapper;

    public LevelService(LevelRepository levelRepository, Mapper mapper) {
        this.levelRepository = levelRepository;
        this.mapper = mapper;
    }

    public LevelDto getById(Long id) {
        Level level = levelRepository.findById(id).orElseThrow(() -> new NotFoundLevelException(id));// метод hibernate
        LevelDto levelDto = mapper.mapper(level, LevelDto.class);
        return levelDto;
    }

    public void saveLevel(LevelDto levelDto) {
        Level level = mapper.mapper(levelDto, Level.class);
        levelRepository.save(level);
    }

    public void deleteLevel(Long id) {
        Level level = levelRepository.findById(id).orElseThrow(() -> new NotFoundLevelException(id));
        levelRepository.delete(level);
    }
}
