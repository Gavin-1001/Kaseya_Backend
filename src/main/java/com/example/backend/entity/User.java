package com.example.backend.entity;

import lombok.Data;
import javax.persistence.*;


@Entity
@Data
@Table(name="users")
public class User {

    //todo implement uuid for id's.
    //todo implement @ManyToOne db for employee to skill level

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //need to implement Long

    @Column(name = "username", unique = true, nullable = false, length = 100)
    private String username;

    private String password;

    @Transient
    private String accessToken;

    @Transient
    private String refreshToken;

    @Enumerated(EnumType.STRING)
    //@Column(name = "role")
    @Column(name = "role", nullable = false)
    private Role role;


    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User() {

    }
}
