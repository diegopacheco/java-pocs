package com.slackclone.auth;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService auth;

    public AuthController(AuthService auth) {
        this.auth = auth;
    }

    @PostMapping("/register")
    public AuthResponse register(@Valid @RequestBody RegisterRequest request) {
        return auth.register(request.username().trim(), request.password(), request.displayName().trim());
    }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest request) {
        return auth.login(request.username().trim(), request.password());
    }

    public record RegisterRequest(@NotBlank String username, @NotBlank String password, @NotBlank String displayName) {
    }

    public record LoginRequest(@NotBlank String username, @NotBlank String password) {
    }
}
