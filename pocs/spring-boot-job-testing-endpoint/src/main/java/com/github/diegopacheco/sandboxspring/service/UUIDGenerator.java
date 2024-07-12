package com.github.diegopacheco.sandboxspring.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UUIDGenerator {

    public List<String> generateUUIDs(int amount){
        List<String> result = new ArrayList<>(amount);
        for(int i=0;i<amount;i++){
            result.add(java.util.UUID.randomUUID().toString());
        }
        return result;
    }

}
