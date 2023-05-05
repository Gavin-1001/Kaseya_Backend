package com.example.backend.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Data
@Table(name="users")
@Builder
@AllArgsConstructor
public class User {

    //todo implement @ManyToOne db for employee to skillsLevel

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id; //need to implement Long

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "id", unique = true)
    private String id;

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



    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
        setRole(Role.USER);
    }

    public User() {

    }
}
