package com.github.diegopacheco.sandboxspring.service;

import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;

@Service
public class SimpleCache {

    @Autowired
    private StatefulRedisConnection<String, String> connection;

    public void set(String key,String value){
        connection.sync().set(key, value);
    }

    public String get(String key){
        return connection.sync().get(key);
    }

    @PreDestroy
    public void detroy(){
        connection.close();
    }

}
