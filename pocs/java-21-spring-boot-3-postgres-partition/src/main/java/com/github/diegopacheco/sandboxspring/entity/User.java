package com.github.diegopacheco.sandboxspring.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true, length = 100)
    private String username;
    
    @Column(nullable = false, length = 255)
    private String email;
    
    @Column(nullable = false, length = 100)
    private String firstName;
    
    @Column(nullable = false, length = 100)
    private String lastName;
    
    @Column(name = "username_first_char", nullable = false, columnDefinition = "CHAR(1)")
    private String usernameFirstChar;
    
    public User() {}
    
    public User(String username, String email, String firstName, String lastName) {
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.usernameFirstChar = username != null && !username.isEmpty() ? 
            String.valueOf(username.toLowerCase().charAt(0)) : "?";
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
        this.usernameFirstChar = username != null && !username.isEmpty() ? 
            String.valueOf(username.toLowerCase().charAt(0)) : "?";
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String getUsernameFirstChar() {
        return usernameFirstChar;
    }
    
    public void setUsernameFirstChar(String usernameFirstChar) {
        this.usernameFirstChar = usernameFirstChar;
    }
}