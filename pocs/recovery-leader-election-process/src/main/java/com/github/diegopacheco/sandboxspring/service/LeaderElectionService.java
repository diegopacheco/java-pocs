package com.github.diegopacheco.sandboxspring.service;

import com.github.diegopacheco.sandboxspring.conf.SlotHolder;
import io.lettuce.core.api.sync.RedisCommands;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LeaderElectionService {

    @Autowired
    SlotHolder slotHolder;

    @Autowired
    RedisCommands<String,String> redis;

    @Value("${SERVER_PORT:${server.port}}")
    private String serverPort;

    @PostConstruct
    public void initElection(){
        System.out.println(">> Starting Leader Election from this Slot: " + slotHolder.getSlot() + " port: " + serverPort);

        redis.hset("slots", slotHolder.getSlot().toString(), "active");
        System.out.println(">> Register my slot in redis DONE");

        Boolean lockAcquired = redis.setnx("LOCK", slotHolder.getSlot().toString());
        if (lockAcquired) {
            System.out.println("Lock acquired by slot: " + slotHolder.getSlot() + " I'm the leader");
        } else {
            System.out.println("Lock NOT acquired. Another slot is leader.");
        }
    }

}
