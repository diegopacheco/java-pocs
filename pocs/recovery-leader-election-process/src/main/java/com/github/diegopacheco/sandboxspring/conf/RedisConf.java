package com.github.diegopacheco.sandboxspring.conf;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConf {

    @Bean
    public RedisClient redisClient() {
        String redisHost = System.getProperty("redis.host",
                isRunningInDocker() ? "redis" : "localhost");
        return RedisClient.create("redis://" + redisHost + ":6379");
    }

    @Bean
    public StatefulRedisConnection<String, String> connection(RedisClient redisClient) {
        return redisClient.connect();
    }

    @Bean
    public RedisCommands<String, String> redisCommands(StatefulRedisConnection<String, String> connection) {
        return connection.sync();
    }

    private boolean isRunningInDocker() {
        return System.getenv("DOCKER_CONTAINER") != null ||
                System.getProperty("java.class.path").contains("app.war") ||
                new java.io.File("/.dockerenv").exists();
    }

}
