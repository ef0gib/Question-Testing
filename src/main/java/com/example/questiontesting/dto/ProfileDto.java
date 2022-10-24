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
public class ProfileDto {

    private Long id;
    private String name;
    private List<QuestionDto> questions;
}
