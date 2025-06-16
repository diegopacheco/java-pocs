package com.github.diegopacheco.sandboxspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.relational.core.mapping.event.BeforeConvertCallback;
import com.github.diegopacheco.sandboxspring.model.User;
import java.util.UUID;

@Configuration
public class UserIdGenerationConfig {

    /*
    @Bean
    public BeforeConvertCallback<User> beforeConvertCallback() {
        return (user) -> {
            if (null==user.getId() ||
                user.getId().isEmpty() ||
                "0".equals(user.getId()))
            {
                user.setId(UUID.randomUUID().toString());
            }
            return user;
        };
    }
    */
}