package com.github.diegopacheco.packagelevelfun.dao;

import com.github.diegopacheco.packagelevelfun.logger.SecureConsoleLogger;

import java.util.Map;

public class UserEmailDao {

    public String getEmail(String userId) {
        String email = "mail%s@gmail.com".formatted(userId);
        SecureConsoleLogger.debugPrint(Map.of("email", email));
        return email;
    }
}
