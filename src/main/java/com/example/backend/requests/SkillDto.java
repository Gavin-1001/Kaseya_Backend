package com.example.backend.requests;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class SkillDto {

//    @NotBlank(message = "Skill Name cannot be blank")
//    @NotNull(message = "Skill Name cannot be NULL")
    String skillName;

//    @NotBlank(message = "Skill Description cannot be blank")
//    @NotNull(message = "Skill Description cannot be NULL")
    String skillDescription;
}
