package com.example.backend.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="employee")
@Data
public class Employee {

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
    private Boolean isActive;

    @Column()
    private int employeeAge;

//    @OneToMany(targetEntity = Skills.class, cascade = CascadeType.ALL)
//    @JoinColumn(name="Employee_fk", referencedColumnName = "id")
//    private List<Skills> skills; // THIS WORKS!!!



}
