package com.github.diegopacheco.sandboxspring.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GreetingsService {

    private Map<String,String> greetingsMapping = new HashMap<>();

    public GreetingsService(){
        greetingsMapping.put("english","hi, how is it going?");
        greetingsMapping.put("spanish","hola que tal?");
        greetingsMapping.put("portuguese","Eae, blz?");
    }

    public String getGreetingByLanguage(String language) {
        return greetingsMapping.get(language);
    }

}
