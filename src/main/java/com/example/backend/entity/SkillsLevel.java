package com.example.backend.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class SkillsLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String skillLevelId;

    @Column(name = "skillName")
    private String skillName;

    @Column(name = "skillDescription")
    private String skillDescription;

////    @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
////    private Set<Employee> employeeList;
////
    @OneToOne(mappedBy = "employeeSkillsLevel")
    private Employee employee;

}
