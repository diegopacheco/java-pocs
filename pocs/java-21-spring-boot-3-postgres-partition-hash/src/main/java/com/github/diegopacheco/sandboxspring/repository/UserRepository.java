package com.github.diegopacheco.sandboxspring.repository;

import com.github.diegopacheco.sandboxspring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
    List<User> findByNameContainingIgnoreCase(String name);
    
    User findByEmail(String email);
    
    @Query("SELECT u FROM User u WHERE u.id = ?1")
    User findUserById(Long id);
}