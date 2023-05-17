package com.example.backend.requests;

import com.example.backend.entity.Skills;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@Builder
public class EmployeeDto {

    @NotBlank(message = "First Name cannot be blank")
    String employeeFirstName;

    @NotBlank(message = "Last Name cannot be blank")
    String employeeLastName;

    @NotNull(message = "Date of Birth cannot be null")
    Date employeeDateOfBirth;

    @NotBlank(message = "email address cannot be blank")
    String employeeEmailAddress;

    @NotNull(message = "isActive cannot be null")
    Boolean isActive;

    @NotNull(message = "age cannot be null")
   int employeeAge;

    //private Skills skills[private Skills skillName];

//    @NotBlank(message = "skillName cannot be blank")
//    private Skills skillName;
//
//    @NotBlank(message = "skillDesc cannot be blank")
//    private Skills skillDescription;

}
