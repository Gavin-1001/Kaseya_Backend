package com.example.backend.entity;


import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
public class Employee {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id; //need to implement Long
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true)
    private String id;


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

    @OneToOne
    @JoinColumn(name = "skillsLevel")
    private SkillsLevel employeeSkillsLevel;

    @Column()
    private Boolean isActive;

    @Column()
    private int employeeAge;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="employee_id", referencedColumnName = "id", insertable = false, updatable = false)
//    private Employee employee;


}
