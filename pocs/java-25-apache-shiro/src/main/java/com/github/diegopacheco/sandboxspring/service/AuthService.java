package com.github.diegopacheco.sandboxspring.service;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public String login(String username, String password) {
        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            token.setRememberMe(true);

            try {
                currentUser.login(token);
                return "Login successful for user: " + username;
            } catch (UnknownAccountException uae) {
                return "Unknown account: " + username;
            } catch (IncorrectCredentialsException ice) {
                return "Incorrect credentials for user: " + username;
            } catch (LockedAccountException lae) {
                return "Account locked for user: " + username;
            } catch (AuthenticationException ae) {
                return "Authentication failed: " + ae.getMessage();
            }
        } else {
            return "User already logged in: " + currentUser.getPrincipal();
        }
    }

    public String logout() {
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated()) {
            currentUser.logout();
            return "Logout successful";
        } else {
            return "No user logged in";
        }
    }

    public String getCurrentUser() {
        Subject currentUser = SecurityUtils.getSubject();
        if (currentUser.isAuthenticated()) {
            return "Current user: " + currentUser.getPrincipal();
        } else {
            return "No user logged in";
        }
    }

    public boolean hasRole(String role) {
        Subject currentUser = SecurityUtils.getSubject();
        return currentUser.hasRole(role);
    }

    public boolean isPermitted(String permission) {
        Subject currentUser = SecurityUtils.getSubject();
        return currentUser.isPermitted(permission);
    }
}