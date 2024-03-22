package com.github.diegopacheco.pocs.seda.event;

import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EventMetadata {

    private final Map<String,String> stamps = new ConcurrentHashMap<>();

    // TODO: shallow copy - should be deep copy.
    public Map<String,String> getStamps(){
        return stamps;
    }

    public void addStage(String stage){
        stamps.put("STAGE",stage);
        stamps.put("TIMESTAMP",new Date().toString());
    }

    @Override
    public String toString() {
        return "EventMetadata{" +
                "stamps=" + stamps +
                '}';
    }
}
