package com.example.backend.entity;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.Date;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name="employee")
@Data
@Builder

public class Employee {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true)
    private String id;

    @NotBlank(message = "First Name cannot be null!")
    private String employeeFirstName;

    @NotBlank(message = "Last Name cannot be null!!")
    private String employeeLastName;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date employeeDateOfBirth;

    @Email(message = "Email must be a valid email!")
    private String employeeEmailAddress;

    @NotNull(message = "Must be true or false")
    private Boolean isActive;

    @NotNull(message = "Age cannot be null!")
    @Min(18)
    @Max(70)
    private int employeeAge;

//    @OneToMany(targetEntity = Skills.class, cascade = CascadeType.ALL)
//    @JoinColumn(name="Employee_fk", referencedColumnName = "id")
//    private List<Skills> skills; // THIS WORKS!!!


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "skills_id")
    private Skills skills;




}
