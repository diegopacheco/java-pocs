package com.github.diegopacheco.design.patterns.structural.proxy;

import java.util.UUID;

public class DatabaseIDGenerator implements IDGenerator {

    @Override
    public UUID getNext() {
        // Fetch real data from database... simulate slow call...
        silentSleepy();
        return UUID.randomUUID();
    }

    private static void silentSleepy(){
        try{
            Thread.sleep(3000L);
        }catch(Exception e){}
    }

}
