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

    @Value("${SERVER_PORT:${server.port:8080}}")
    private String serverPort;

    @Autowired
    ServiceWorkSplitter splitter;

    @Autowired
    DataGenerationService dataGenerationService;

    @PostConstruct
    public void initElection(){
        System.out.println(">> Starting Leader Election from this Slot: " + slotHolder.getSlot() + " port: " + serverPort);

        redis.hset("slots", slotHolder.getSlot().toString(), "active");
        System.out.println(">> Register my slot in redis DONE");

        System.out.println(">>> Generating 10 ids for db");
        dataGenerationService.generate(10);

        Boolean lockAcquired = redis.set("LOCK", slotHolder.getSlot().toString(), SetArgs.Builder.nx().ex(300));
        if (lockAcquired) {

            System.out.println("Lock acquired by slot: " + slotHolder.getSlot() + " I'm the leader");
            System.out.println(">> Starting split work...");
            splitter.splitWork();

            System.out.println(">> Work split DONE");
            System.out.println(">> Releasing lock...");
            redis.del("LOCK");
            System.out.println(">> Lock released");
        } else {
            System.out.println("Lock NOT acquired. Another slot is leader.");
            System.out.println(">> Waiting for leader to finish work...");
            silentSleep(15);

            System.out.println(">> Getting my IDs from slot: " + slotHolder.getSlot());
            String mySlotKey = "slot:" + slotHolder.getSlot();
            String myIds = redis.hget(mySlotKey, "ids");
            if (myIds != null && !myIds.isEmpty()) {
                System.out.println(">> My IDs: " + myIds);
            } else {
                System.out.println(">> No IDs found for my slot: " + slotHolder.getSlot());
            }
        }
    }

    private void silentSleep(long ms) {
        try {
            Thread.sleep(ms * 1000);
        } catch (Exception e) {
        }
    }

}
