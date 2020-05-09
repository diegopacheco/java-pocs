package com.github.diegopacheco.sandboxspring.service;

import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SimpleCache {

    @Autowired
    private StatefulRedisConnection<String, String> connection;

    public void set(String key,String value){
        RedisCommands<String, String> syncCommands = connection.sync();
        syncCommands.set(key, value);
    }

    public String get(String key){
        RedisCommands<String, String> syncCommands = connection.sync();
        return syncCommands.get(key);
    }

}
