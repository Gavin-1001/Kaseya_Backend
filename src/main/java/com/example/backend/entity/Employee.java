package com.example.backend.entity;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private String employeeFirstName;

    @Column()
    private String employeeLastName;

    @Column
    private Date employeeDateOfBirth;

    @Column()
    private String employeeEmailAddress;

    @Column()
    private String employeeSkillLevel;
    //this will be a left join from SkillLevel table in the future, just get the api working for initial testing purposes

    @Column()
    private Boolean isActive;

    @Column()
    private int employeeAge;

}
