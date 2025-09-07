package com.github.diegopacheco.javapocs.codeorg.ddd.application.user;

import com.github.diegopacheco.javapocs.codeorg.ddd.domain.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    
    private final UserRepository userRepository;
    
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public User createUser(String name, String email, String address) {
        Email emailVO = Email.of(email);
        
        if (userRepository.existsByEmail(emailVO)) {
            throw new IllegalArgumentException("User with email " + email + " already exists");
        }
        
        Address addressVO = address != null ? Address.of(address) : null;
        User user = User.create(name, emailVO, addressVO);
        
        return userRepository.save(user);
    }
    
    public Optional<User> findUserById(String userId) {
        return userRepository.findById(UserId.of(userId));
    }
    
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(Email.of(email));
    }
    
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    public User updateUser(String userId, String name, String email, String address) {
        UserId userIdVO = UserId.of(userId);
        User user = userRepository.findById(userIdVO)
                .orElseThrow(() -> new IllegalArgumentException("User not found: " + userId));
        
        if (name != null) {
            user.updateName(name);
        }
        
        if (email != null) {
            Email newEmail = Email.of(email);
            if (!user.getEmail().equals(newEmail) && userRepository.existsByEmail(newEmail)) {
                throw new IllegalArgumentException("User with email " + email + " already exists");
            }
            user.updateEmail(newEmail);
        }
        
        if (address != null) {
            user.updateAddress(Address.of(address));
        }
        
        return userRepository.save(user);
    }
    
    public void deleteUser(String userId) {
        UserId userIdVO = UserId.of(userId);
        if (!userRepository.findById(userIdVO).isPresent()) {
            throw new IllegalArgumentException("User not found: " + userId);
        }
        userRepository.deleteById(userIdVO);
    }
}