package com.example.backend.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name="skills")
public class Skills {
    //Add the controller for skillsLevel and check repo

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "skillName")
    private String skillName;

    @Column(name = "skillDescription")
    private String skillDescription;

//    @OneToOne(mappedBy = "skills")
//    private Employee employee;





}
