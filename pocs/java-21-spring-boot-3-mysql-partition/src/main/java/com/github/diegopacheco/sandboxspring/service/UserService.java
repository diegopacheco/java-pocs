package com.github.diegopacheco.sandboxspring.service;

import com.github.diegopacheco.sandboxspring.entity.User;
import com.github.diegopacheco.sandboxspring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(String name, String lastName, String email) {
        User user = new User(name, lastName, email, LocalDateTime.now());
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAllUsers();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getUsersByNamePrefix(String namePrefix) {
        return userRepository.findByNameStartingWith(namePrefix);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}