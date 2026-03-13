package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    //무족건 들어가야하고 유일해야함
    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private String role;

    private String refreshToken;

    public Member(String name, String email, String password, String role){
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = "ROLE_USER";
        this.createdAt = LocalDateTime.now();
    }

    public void update(String name, String email){
        this.name = name;
        this.email = email;
    }

    public void updateRefreshToken(String refreshToken){
        this.refreshToken = refreshToken;
    }
}
