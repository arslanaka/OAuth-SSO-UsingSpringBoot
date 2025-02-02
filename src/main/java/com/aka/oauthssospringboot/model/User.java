package com.aka.oauthssospringboot.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = "none")
    private String email;

    @Column(name = "password_hash")
    private String passwordHash;

    // Add other user details as needed
}

