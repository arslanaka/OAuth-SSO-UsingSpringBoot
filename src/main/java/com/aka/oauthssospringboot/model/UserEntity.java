package com.aka.oauthssospringboot.model;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;


@Entity
@Table(name = "users")
public class UserEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long user_id;

    @Column(unique = true, nullable = false,name = "email")
    private String email;

    @Column(unique = true, nullable = false,name = "user_name")
    private String name;

    @Column(name = "password")
    private String passwordHash;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "updated_at")
    private Timestamp updated_at;

    @Column(name = "user_type")
    private Enum user_type;

    @Column(name = "google_uuid")
    private UUID google_uuid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    public Enum getUser_type() {
        return user_type;
    }

    public void setUser_type(Enum user_type) {
        this.user_type = user_type;
    }

    public UUID getGoogle_uuid() {
        return google_uuid;
    }

    public void setGoogle_uuid(UUID google_uuid) {
        this.google_uuid = google_uuid;
    }
}

