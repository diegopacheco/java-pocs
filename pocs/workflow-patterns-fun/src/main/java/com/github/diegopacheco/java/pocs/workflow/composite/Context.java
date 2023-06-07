package com.github.diegopacheco.java.pocs.workflow.composite;

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

    public <T> Boolean set(String key, T value){
        map.put(key,value);
        return true;
    }

}
