package com.github.diegopacheco.java.pocs.workflow.decorator;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Proverbial Bag of Cats.
public class Context {
    private Map<String, Object> map;

    public Context() {
        this.map = new ConcurrentHashMap<>();
    }

    public <T> T get(String key){
        return (T)map.get(key);
    }

    public <T> T get(String key,T defaultValue){
        T result = (T)map.get(key);
        if (null==result) return defaultValue;
        return result;
    }

    public <T> Boolean set(String key, T value){
        map.put(key,value);
        return true;
    }

}
