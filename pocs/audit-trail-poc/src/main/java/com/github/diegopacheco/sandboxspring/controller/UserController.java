package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.model.User;
import com.github.diegopacheco.sandboxspring.service.AuditService;
import com.github.diegopacheco.sandboxspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;
    private final AuditService auditService;

    @Autowired
    public UserController(UserService userService, AuditService auditService) {
        this.userService = userService;
        this.auditService = auditService;
    }

    @PostMapping("/enroll")
    public ResponseEntity<User> enrollUser(@RequestBody User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        return userService.findById(id)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/unenroll/{id}")
    public ResponseEntity<Void> unenrollUser(@PathVariable String id) {
        userService.deleteUser(id);
        auditService.logEvent("User unenrolled", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/fetch")
    public ResponseEntity<String> fetchCatFact() {
        try {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> response = restTemplate.getForEntity(
                    "https://catfact.ninja/fact",
                    String.class
            );

            auditService.logEvent("Cat fact retrieved: " + response.getBody(), "system");
            return new ResponseEntity<>(response.getBody(), HttpStatus.OK);
        } catch (Exception e) {
            auditService.logEvent("Error retrieving cat fact: " + e.getMessage(), "system");
            return new ResponseEntity<>("Failed to fetch cat fact", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}