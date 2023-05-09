package com.example.backend.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
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

    //@NotBlank(message = "SKILL NAME CANNOT BE BLANK")
    @NotEmpty(message = "Skill Name cannot be empty!!!")
    private String skillName;

    @NotEmpty(message = "Skill Description cannot be empty!!!")
    private String skillDescription;

}
