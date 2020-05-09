package com.github.diegopacheco.sandboxspring.service;

import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.reactive.RedisStringReactiveCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.PreDestroy;
import java.time.Duration;
import java.util.Date;

@Service
public class SimpleCache {

    @Autowired
    private StatefulRedisConnection<String, String> connection;

    public void set(String key, String value) {
        connection.sync().set(key, value);
    }

    public String get(String key) {
        return connection.sync().get(key);
    }

    public void getAndSetCachePrint(String key) {
        RedisStringReactiveCommands<String, String> commands = connection.reactive();
        Flux.just(key)
                .flatMap( k -> {
                    return commands.set(k, new Date().toString());
                })
                .subscribe(System.out::println);

        Flux.just(key)
                .flatMap(commands::get)
                .subscribe(System.out::println);
    }

    @PreDestroy
    public void detroy() {
        connection.close();
    }

}
