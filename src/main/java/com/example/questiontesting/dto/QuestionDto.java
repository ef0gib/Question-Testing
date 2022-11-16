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
public class QuestionDto {

    private Long id;
    private String name;
    private Long numOfCorr;
    @ToString.Exclude
    private List<AnswerDto> answers;
    @ToString.Exclude
    private ProfileDto profile;
    @ToString.Exclude
    private LevelDto level;
}
