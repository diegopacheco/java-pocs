package com.github.diegopacheco.sandboxspring.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("users")
public class User {
    
    @Id
    private Long id;
    
    private String name;
    
    private String lastName;
    
    private String email;
    
    private LocalDateTime activatedAt;

    public User() {}

    public User(String name, String lastName, String email, LocalDateTime activatedAt) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.activatedAt = activatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getActivatedAt() {
        return activatedAt;
    }

    public void setActivatedAt(LocalDateTime activatedAt) {
        this.activatedAt = activatedAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", activatedAt=" + activatedAt +
                '}';
    }
}