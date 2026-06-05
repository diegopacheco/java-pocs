package com.slackclone.auth;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface SessionRepository extends CrudRepository<Session, Long> {
    Optional<Session> findByToken(String token);
}
