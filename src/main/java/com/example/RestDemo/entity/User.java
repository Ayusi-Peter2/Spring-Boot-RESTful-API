package com.example.RestDemo.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "username",nullable = false,unique = true)
    private String username;
    @Column(name = "password",nullable = false)
    private String password;
    @Column(name = "active",nullable = false)
    private int active;
    @CreationTimestamp
    @Column(name = "createdAt",nullable = false)
    private Timestamp createdAt;
    @UpdateTimestamp
    @Column(name = "updatedAt",nullable = true)
    private Timestamp updatedAt;

    public User(Long id, String name, String username, String password, int active, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public User(Long id, String name, String password, int active, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public User() {
    }

    public User(String name, String username, String password, int active) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.active = active;
    }
}

