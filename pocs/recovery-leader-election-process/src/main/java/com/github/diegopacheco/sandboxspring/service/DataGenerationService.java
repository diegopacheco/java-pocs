package com.github.diegopacheco.sandboxspring.service;

import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DataGenerationService {

    @Autowired
    private RedisCommands<String,String> redis;

    public boolean generate(int n){
        for(int i = 0; i < n; i++) {
            String key = "" + UUID.randomUUID();
            String value = "active";
            redis.hset("db", key, value);
        }
        System.out.println("Generated: " + n + " ids for work.");
        return true;
    }

    public boolean cleanUP(){
        redis.del("db");
        redis.del("slots");
        System.out.println("Cleaned up db and slots keys.");
        return true;
    }

}
