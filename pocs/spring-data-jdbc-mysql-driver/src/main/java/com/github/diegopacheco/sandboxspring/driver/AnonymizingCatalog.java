package com.github.diegopacheco.sandboxspring.driver;

import java.util.HashMap;
import java.util.Map;

public class AnonymizingCatalog {

    private final Map<String, Anonymizing> anonymizingFields = new HashMap<>();
    private static AnonymizingCatalog instance = null;
    private AnonymizingCatalog(){}

    public static AnonymizingCatalog getInstance(){
        if (null==instance){
            instance = new AnonymizingCatalog();
        }
        return instance;
    }

    public void addAnonymizingField(String tableKey,String fieldName,Anonymizing anonymizing){
        anonymizingFields.put(tableKey.toLowerCase()+"."+fieldName.toLowerCase(),anonymizing);
    }

    public boolean isAnonymizingField(String tableKey,String fieldName){
        return anonymizingFields.containsKey(tableKey+"."+fieldName);
    }

    public String applyStrategy(String value, String tableKey,String fieldName){
        Anonymizing anonymizing = anonymizingFields.get(tableKey+"."+fieldName);
        if (null==anonymizing){
            return value;
        }

        AnonymizingStrategy strategy = anonymizing.strategy();
        return strategy.getApplication().execute(value);
    }
}
