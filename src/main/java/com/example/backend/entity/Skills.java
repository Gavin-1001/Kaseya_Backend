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
    @Column(name = "id")
    private Long id;

    private String skillName;

    private String skillDescription;


    @OneToOne(mappedBy = "skills")
    private Employee employee;


}
