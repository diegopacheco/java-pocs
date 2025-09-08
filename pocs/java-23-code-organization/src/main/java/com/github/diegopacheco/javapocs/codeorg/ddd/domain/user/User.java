package com.github.diegopacheco.javapocs.codeorg.ddd.domain.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.Objects;

@Table("users")
public class User {
    
    @Id
    private String id;
    
    private String name;
    
    private String email;
    
    private String address;
    
    @Column("created_at")
    private LocalDateTime createdAt;
    
    @Column("updated_at")
    private LocalDateTime updatedAt;
    
    public User() {
    }
    
    @PersistenceCreator
    public User(String id, String name, String email, String address, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    
    public User(UserId id, String name, Email email, Address address) {
        this.id = Objects.requireNonNull(id, "User ID cannot be null").value();
        this.name = Objects.requireNonNull(name, "Name cannot be null");
        this.email = Objects.requireNonNull(email, "Email cannot be null").value();
        this.address = address != null ? address.value() : null;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }
    
    public static User create(String name, Email email, Address address) {
        User user = new User();
        user.id = UserId.generate().value();
        user.name = Objects.requireNonNull(name, "Name cannot be null");
        user.email = Objects.requireNonNull(email, "Email cannot be null").value();
        user.address = address != null ? address.value() : null;
        user.createdAt = LocalDateTime.now();
        user.updatedAt = LocalDateTime.now();
        return user;
    }
    
    public void updateName(String newName) {
        this.name = Objects.requireNonNull(newName, "Name cannot be null");
        this.updatedAt = LocalDateTime.now();
    }
    
    public void updateEmail(Email newEmail) {
        this.email = Objects.requireNonNull(newEmail, "Email cannot be null").value();
        this.updatedAt = LocalDateTime.now();
    }
    
    public void updateAddress(Address newAddress) {
        this.address = newAddress != null ? newAddress.value() : null;
        this.updatedAt = LocalDateTime.now();
    }
    
    public UserId getUserId() {
        return UserId.of(id);
    }
    
    public String getName() {
        return name;
    }
    
    public Email getEmail() {
        return Email.of(email);
    }
    
    public Address getAddress() {
        return address != null ? Address.of(address) : null;
    }
    
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    
    public String getId() {
        return id;
    }
}