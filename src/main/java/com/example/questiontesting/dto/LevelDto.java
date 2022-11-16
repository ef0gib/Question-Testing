package com.example.questiontesting.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class LevelDto {

    private Long id;
    private String name;
    @ToString.Exclude
    private List<QuestionDto> questions;
}
