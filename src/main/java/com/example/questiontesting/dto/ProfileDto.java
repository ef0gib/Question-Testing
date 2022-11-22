package com.example.questiontesting.dto;

import io.swagger.v3.oas.annotations.media.Schema;
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

    @Schema(description = "Auto generated field in DB", name = "id", required = false)
    private Long id;
    @Schema(description = "Profile object name", name = "name", required = true, example = "Developer",
            maxLength = 20, minLength = 1)
    private String name;
    @ToString.Exclude
    @Schema(description = "Auto generated field in DB", name = "id", required = true)
    private List<QuestionDto> questions;
}
