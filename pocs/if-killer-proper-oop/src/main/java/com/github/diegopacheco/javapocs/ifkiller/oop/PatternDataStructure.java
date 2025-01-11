package com.github.diegopacheco.javapocs.ifkiller.oop;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PatternDataStructure {

    final Map<String,String> countries = new HashMap<>();

    public PatternDataStructure(){
        countries.put("Brazil","Portuguese");
        countries.put("Argentina","Spanish");
        countries.put("Guiana","French");
    }

    public Optional<String> getLanguage(String source){
        return Optional.of(countries.get(source));
    }

    public static void main(String[] args) {
        PatternDataStructure ap = new PatternDataStructure();
        System.out.println(ap.getLanguage("Brazil"));
        System.out.println(ap.getLanguage("Argentina"));
        System.out.println(ap.getLanguage("Guiana"));
    }

}
