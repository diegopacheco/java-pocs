package com.github.diegopacheco.reactor.poc.ctx.config;

import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class Mid {

    public static final String ID = "$MID.ID$";
    private Map<String,String> props = new ConcurrentHashMap<>();

    public static Mid newMid(){
        Mid mid = new Mid();
        mid.props.put(ID,UUID.randomUUID().toString());
        return mid;
    }

    public static Mid fromID(String id){
        Mid mid = new Mid();
        mid.props.put(ID,id);
        return mid;
    }

    public String getID(){
        String id =  props.get(ID);
        if (null==id){
            id = UUID.randomUUID().toString();
            props.put(ID,id);
        }
        return id;
    }

    @Override
    public String toString() {
        String id =  props.get(ID);
        return id;
    }
}
