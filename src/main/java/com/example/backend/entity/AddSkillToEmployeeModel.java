package com.example.backend.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="addSkillToEmployee")
@Data
public class AddSkillToEmployeeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="employee_id")
    private String EmployeeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="employee_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Employee employee;

    @Column(name="skill_id")
    private Long skillId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="skill_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Skills skills;









}
