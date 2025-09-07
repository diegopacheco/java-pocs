package com.github.diegopacheco.javapocs.codeorg.ddd.domain.user;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(UserId userId);
    Optional<User> findByEmail(Email email);
    List<User> findAll();
    void deleteById(UserId userId);
    boolean existsByEmail(Email email);
}