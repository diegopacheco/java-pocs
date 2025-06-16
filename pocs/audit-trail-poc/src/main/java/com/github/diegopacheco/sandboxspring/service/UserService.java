package com.github.diegopacheco.sandboxspring.service;

import com.github.diegopacheco.sandboxspring.model.User;
import com.github.diegopacheco.sandboxspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final AuditService auditService;

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserService(UserRepository userRepository,
                       AuditService auditService,
                       JdbcTemplate jdbcTemplate) {
        this.userRepository = userRepository;
        this.auditService = auditService;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public User createUser(User user) {
        if (null==user.getEmail() || user.getEmail().trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (null==user.getPhone() || user.getPhone().trim().isEmpty()) {
            throw new IllegalArgumentException("Phone number cannot be null or empty");
        }

        String sql = "INSERT INTO users (id, name, email, phone) VALUES (?, ?, ?, ?)";
        String id = UUID.randomUUID().toString();
        jdbcTemplate.update(sql, id, user.getName(), user.getEmail(), user.getPhone());
        User savedUser = new User(id, user.getName(), user.getEmail(), user.getPhone());

        auditService.logEvent("User created: " + savedUser, savedUser.getId());
        return savedUser;
    }

    public Optional<User> findById(String id) {
        return userRepository.findById(id);
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> findAllUsers() {
        return StreamSupport
                .stream(userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Transactional
    public User updateUser(User user) {
        User updatedUser = userRepository.save(user);
        auditService.logEvent("User updated: " + user, updatedUser.getId());
        return updatedUser;
    }

    @Transactional
    public void deleteUser(String id) {
        userRepository.findById(id).ifPresent(user -> {
            userRepository.deleteById(id);
            auditService.logEvent("User deleted: " + user, id);
        });
    }
}