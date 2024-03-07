package com.github.diegopacheco.reactor.poc.ctx.config;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadLocalMID {
    public static final String ID = "$MID.ID$";
    private static ThreadLocal<Map<String,String>> holder = new ThreadLocal<>();

    public static ThreadLocalMID newMid(){
        ThreadLocalMID mid = new ThreadLocalMID();
        holder.set(new ConcurrentHashMap<>());
        holder.get().put(ID, UUID.randomUUID().toString());
        return mid;
    }

    public static ThreadLocalMID fromID(String id){
        ThreadLocalMID mid = new ThreadLocalMID();
        holder.set(new ConcurrentHashMap<>());
        holder.get().put(ID, id);
        return mid;
    }

    public String getID(){
        String id =  holder.get().get(ID);
        if (null==id){
            id = UUID.randomUUID().toString();
            holder.get().put(ID,id);
        }
        return id;
    }

    @Override
    public String toString() {
        String id =  holder.get().get(ID);
        return id;
    }
}
