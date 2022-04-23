package com.github.diegopacheco.sandboxspring.dao;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class CapitalsDao {

    private Map<String,String> db = new ConcurrentHashMap<>();

    public CapitalsDao(){
        db.put("NY","NY");
        db.put("CA","Sacramento");
        db.put("OR","Salem");
        db.put("AZ","Phoenix");
        db.put("CO","Denver");
        db.put("GA","Atlanta");
        db.put("LA","Baton Rouge");
        db.put("MA","Boston");
        db.put("MS","Jackson");
        db.put("TN","Nashville");
        db.put("VA","Richmond");
    }

    public String getCapital(String state){
        System.out.println("Hitting the DB... ");
        simulateDBLoad();
        return db.get(state);
    }

    private static void simulateDBLoad(){
        try{ Thread.sleep(3000L); }catch(Exception e){}
    }

}
