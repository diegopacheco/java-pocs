package com.github.diegopacheco.javapocs.codeorg.ddd.infrastructure.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.query.Param;

import com.github.diegopacheco.javapocs.codeorg.ddd.domain.user.User;

import java.util.Optional;

public interface SpringDataUserRepository extends CrudRepository<User, String> {
    
    @Query("SELECT * FROM users WHERE email = :email")
    Optional<User> findByEmail(@Param("email") String email);
    
    @Query("SELECT COUNT(*) > 0 FROM users WHERE email = :email")
    boolean existsByEmail(@Param("email") String email);
}