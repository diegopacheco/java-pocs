package com.github.diegopacheco.sandboxspring.service;

import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceWorkSplitter {

    @Autowired
    RedisCommands<String,String> redis;

    public boolean splitWork() {
        var ids = redis.hkeys("ids");
        if (ids == null || ids.isEmpty()) {
            System.out.println("No IDs found in Redis. Cannot split work.");
            return false;
        }

        var slots = redis.hgetall("slots");
        int partitions = slots.size();
        if (slots.isEmpty()) {
            System.out.println("No slots found in Redis. Cannot split work.");
            return false;
        }

        for (String id : ids) {
            int slotIndex = id.hashCode() % partitions;
            String slotKey = "slot:" + slotIndex;

            String currentIds = redis.hget(slotKey, "ids");
            if (currentIds == null) {
                currentIds = "";
            }

            if (!currentIds.isEmpty()) {
                currentIds += ",";
            }
            currentIds += id;

            redis.hset(slotKey, "ids", currentIds);
        }
        return true;
    }

}
