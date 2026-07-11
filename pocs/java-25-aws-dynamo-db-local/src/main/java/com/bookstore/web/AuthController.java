package com.bookstore.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.error.UnauthorizedException;
import com.bookstore.security.JwtService;
import com.bookstore.web.dto.LoginRequest;
import com.bookstore.web.dto.TokenResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/auth")
@Tag(name = "Authentication")
public class AuthController {

    private final JwtService jwtService;
    private final String username;
    private final String password;

    public AuthController(JwtService jwtService,
                          @Value("${auth.username}") String username,
                          @Value("${auth.password}") String password) {
        this.jwtService = jwtService;
        this.username = username;
        this.password = password;
    }

    @PostMapping("/login")
    @SecurityRequirements
    @Operation(summary = "Authenticate and receive a JWT bearer token")
    public TokenResponse login(@RequestBody LoginRequest request) {
        if (!username.equals(request.username()) || !password.equals(request.password())) {
            throw new UnauthorizedException("invalid credentials");
        }
        return new TokenResponse(jwtService.issue(request.username()), jwtService.expirationSeconds());
    }
}
