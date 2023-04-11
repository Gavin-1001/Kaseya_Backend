package com.example.backend.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //need to implement Long

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
