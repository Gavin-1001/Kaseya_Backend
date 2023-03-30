package com.example.backend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class JwtRefreshToken {

    @Id
    @Column(name="token_id")
    private String tokenId;

    @Column(name="user_id")
    private Long userId;

    @Column(name="created_token_date")
    private LocalDateTime whenTokenCreated;

    @Column(name="expiration_date")
    private LocalDateTime whenTokenExpirationDate;


}
