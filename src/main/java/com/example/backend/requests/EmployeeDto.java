package com.example.backend.requests;

import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@Builder
public class EmployeeDto {

    @NotBlank(message = "First Name cannot be blank")
    @NotNull(message = "First Name cannot be NULL")
    String employeeFirstName;

    @NotBlank(message = "Last Name cannot be BLANK")
    @NotNull(message = "Last Name cannot be NULL")
    String employeeLastName;

    @NotNull(message = "Date cannot be null")
    Date employeeDateOfBirth;

    @NotBlank(message = "Email Address cannot be BLANK")
    @NotNull(message = "Email Address cannot be NULL")
    @Email(message = "This must be a valid email")
    String employeeEmailAddress;

    @NotNull(message = "Employee Active cannot be null")
    Boolean isActive;


    @Min(value = 1, message = "Invalid Age: Equals to zero or Less than zero")
    @Max(value = 100, message = "Age not above 100")
    int employeeAge;
}
