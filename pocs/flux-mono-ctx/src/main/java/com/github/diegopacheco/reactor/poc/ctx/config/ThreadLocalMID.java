package com.github.diegopacheco.reactor.poc.ctx.config;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadLocalMID {
    public static final String ID = "$MID.ID$";
    private ThreadLocal<Map<String,String>> holder;

    public ThreadLocalMID(){
        holder = new ThreadLocal<>();
        holder.set(new ConcurrentHashMap<>());
        holder.get().put(ID, UUID.randomUUID().toString());
    }

    public static ThreadLocalMID newMid(){
        return new ThreadLocalMID();
    }

    public static ThreadLocalMID fromID(String id){
        ThreadLocalMID mid = new ThreadLocalMID();
        mid.holder.get().put(ID, id);
        return mid;
    }

    public String getID(){
        Map<String,String> props = holder.get();
        String id = null;
        if (props!=null){
            id = props.get(ID);
            if (null==id){
                id = UUID.randomUUID().toString();
                holder.get().put(ID,id);
            }
        }else{
            id = UUID.randomUUID().toString();
            if (holder==null){
                holder = new ThreadLocal<>();
            }
            if (holder.get()==null){
                holder.set(new ConcurrentHashMap<>());
            }
            holder.get().put(ID,id);
        }
        return id;
    }

    @Override
    public String toString() {
        Map<String,String> props = holder.get();
        String id = null;
        if (null==props){
            id = "<<NOT AVALIABLE>>";
        }else{
            id = props.get(ID);
        }
        return id;
    }
}
