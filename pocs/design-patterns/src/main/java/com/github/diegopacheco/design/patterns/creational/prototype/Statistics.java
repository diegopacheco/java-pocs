package com.github.diegopacheco.design.patterns.creational.prototype;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Statistics {

    private Map<String,Integer> sucess = new HashMap<String, Integer>();
    private Map<String,Integer> error = new HashMap<String, Integer>();

    public Statistics(){}

    public Statistics(Map<String, Integer> sucess, Map<String, Integer> error) {
        this.sucess = sucess;
        this.error = error;
    }

    public void registerSucess(String key){
        Integer count = sucess.get(key);
        if (null==count){
            sucess.put(key,1);
        }else{
            sucess.put(key,count+1);
        }
    }

    public void registerError(String key){
        Integer count = error.get(key);
        if (null==count){
            error.put(key,1);
        }else{
            error.put(key,count+1);
        }
    }

    public Statistics clone() {
        return new Statistics(copy(sucess),copy(error));
    }

    private Map<String,Integer> copy(Map<String,Integer> source){
        HashMap<String, Integer> shallowCopy = new HashMap<String, Integer>();
        Set<Map.Entry<String, Integer>> entries = source.entrySet();
        for (Map.Entry<String, Integer> mapEntry : entries) {
            shallowCopy.put(mapEntry.getKey(), mapEntry.getValue());
        }
        return shallowCopy;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "sucess=" + sucess +
                ", error=" + error +
                '}';
    }
}
