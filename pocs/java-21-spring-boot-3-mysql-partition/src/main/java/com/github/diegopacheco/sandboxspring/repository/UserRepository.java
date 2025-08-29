package com.github.diegopacheco.sandboxspring.repository;

import com.github.diegopacheco.sandboxspring.entity.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT * FROM users WHERE name LIKE :namePrefix%")
    List<User> findByNameStartingWith(@Param("namePrefix") String namePrefix);

    @Query("SELECT * FROM users")
    List<User> findAllUsers();

    @Query("SELECT * FROM users WHERE email = :email")
    User findByEmail(@Param("email") String email);
}