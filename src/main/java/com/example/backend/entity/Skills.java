package com.example.backend.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Skills {
    //Add the controller for skillsLevel and check repo

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private Long id;

    private String skillName;

    private String skillDescription;

// ERROR: mappedBy reference an unknown target entity property: com.example.backend.entity.Employee.employee in com.example.backend.entity.Skills.employee
//    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Employee.class, orphanRemoval=true)
//    private List<Employee> employee;


//this works but is commented out
//    @ManyToOne()
//    private Employee employee;


//put a relationship later back to employee
//    @ManyToOne()




}
