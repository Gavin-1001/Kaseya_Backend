package com.example.backend.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
