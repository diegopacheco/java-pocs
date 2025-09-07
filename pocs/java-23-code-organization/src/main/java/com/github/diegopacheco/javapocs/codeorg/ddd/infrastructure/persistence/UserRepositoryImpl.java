package com.github.diegopacheco.javapocs.codeorg.ddd.infrastructure.persistence;

import com.github.diegopacheco.javapocs.codeorg.ddd.domain.user.Email;
import com.github.diegopacheco.javapocs.codeorg.ddd.domain.user.User;
import com.github.diegopacheco.javapocs.codeorg.ddd.domain.user.UserId;
import com.github.diegopacheco.javapocs.codeorg.ddd.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Repository
public class UserRepositoryImpl implements UserRepository {
    
    private final SpringDataUserRepository springDataUserRepository;
    
    @Autowired
    public UserRepositoryImpl(SpringDataUserRepository springDataUserRepository) {
        this.springDataUserRepository = springDataUserRepository;
    }
    
    @Override
    public User save(User user) {
        return springDataUserRepository.save(user);
    }
    
    @Override
    public Optional<User> findById(UserId userId) {
        return springDataUserRepository.findById(userId.value());
    }
    
    @Override
    public Optional<User> findByEmail(Email email) {
        return springDataUserRepository.findByEmail(email.value());
    }
    
    @Override
    public List<User> findAll() {
        return StreamSupport.stream(springDataUserRepository.findAll().spliterator(), false)
                .toList();
    }
    
    @Override
    public void deleteById(UserId userId) {
        springDataUserRepository.deleteById(userId.value());
    }
    
    @Override
    public boolean existsByEmail(Email email) {
        return springDataUserRepository.existsByEmail(email.value());
    }
}