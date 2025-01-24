package com.github.diegopacheco.packagelevelfun.dao;

public class UserEmailDao {

    public String getEmail(String userId) {
        return "mail%s@gmail.com".formatted(userId);
    }
}
