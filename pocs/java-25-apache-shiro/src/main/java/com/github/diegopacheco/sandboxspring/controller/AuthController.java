package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        return authService.login(username, password);
    }

    @PostMapping("/logout")
    public String logout() {
        return authService.logout();
    }

    @GetMapping("/current")
    public String getCurrentUser() {
        return authService.getCurrentUser();
    }

    @GetMapping("/role/{role}")
    public String checkRole(@PathVariable String role) {
        boolean hasRole = authService.hasRole(role);
        return "User has role '" + role + "': " + hasRole;
    }

    @GetMapping("/permission/{permission}")
    public String checkPermission(@PathVariable String permission) {
        boolean isPermitted = authService.isPermitted(permission);
        return "User has permission '" + permission + "': " + isPermitted;
    }

    @GetMapping("/admin/info")
    public String adminInfo() {
        return "Admin-only information - you have admin role!";
    }
}