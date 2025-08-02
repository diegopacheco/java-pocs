package com.github.diegopacheco.sandboxspring.service;

import io.lettuce.core.api.sync.RedisCommands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceWorkSplitter {

    @Autowired
    RedisCommands<String,String> redis;

    public boolean splitWork() {
        var ids = redis.hkeys("db");
        if (ids == null || ids.isEmpty()) {
            System.out.println("No DB found in Redis. Cannot split work.");
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

    public List<String> getMyWorkIDS(String slot){
        String mySlotKey = "slot:" + slot;
        String myIds = redis.hget(mySlotKey, "ids");
        if (myIds != null && !myIds.isEmpty()) {
            return List.of(myIds.split(","));
        } else {
            System.out.println("No IDs found for my slot: " + slot);
            return List.of();
        }
    }

    public List<String> getFullDB(){
        List<String> ids = redis.hkeys("db");
        if (ids == null || ids.isEmpty()) {
            System.out.println("No IDs found in Redis.");
            return List.of();
        }

        StringBuilder fullDB = new StringBuilder();
        for (String id : ids) {
            String data = redis.hget("db", id);
            if (data != null) {
                fullDB.append(id).append(":").append(data).append("\n");
            }
        }
        return List.of(fullDB.toString().split("\n"));
    }

}
