package com.example.backend.entity;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Required;

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

    private String employeeFirstName;

    private String employeeLastName;

    private Date employeeDateOfBirth;

    private String employeeEmailAddress;

    private Boolean isActive;

    private int employeeAge;

//    @OneToMany(targetEntity = Skills.class, cascade = CascadeType.ALL)
//    @JoinColumn(name="Employee_fk", referencedColumnName = "id")
//    private List<Skills> skills; // THIS WORKS!!!


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "skills_id")
    private Skills skills;




}
