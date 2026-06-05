package com.slackclone.auth;

import com.slackclone.user.User;
import com.slackclone.user.UserRepository;
import java.time.Instant;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {

    private final UserRepository users;
    private final SessionRepository sessions;
    private final PasswordHasher hasher;

    public AuthService(UserRepository users, SessionRepository sessions, PasswordHasher hasher) {
        this.users = users;
        this.sessions = sessions;
        this.hasher = hasher;
    }

    public AuthResponse register(String username, String password, String displayName) {
        if (users.existsByUsername(username)) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "username already taken");
        }
        User saved = users.save(new User(null, username, hasher.hash(password), displayName, null, Instant.now()));
        return issue(saved);
    }

    public AuthResponse login(String username, String password) {
        User user = users.findByUsername(username)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "invalid credentials"));
        if (!hasher.verify(password, user.passwordHash())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "invalid credentials");
        }
        return issue(user);
    }

    private AuthResponse issue(User user) {
        Session session = sessions.save(new Session(null, hasher.newToken(), user.id(), Instant.now()));
        return new AuthResponse(session.token(), toAuthUser(user));
    }

    public static AuthUser toAuthUser(User user) {
        return new AuthUser(user.id(), user.username(), user.displayName(), user.avatarUrl());
    }
}
