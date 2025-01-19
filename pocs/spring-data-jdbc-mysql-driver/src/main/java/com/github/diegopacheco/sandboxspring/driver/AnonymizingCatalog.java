package com.github.diegopacheco.sandboxspring.driver;

import java.util.HashMap;
import java.util.Map;

public class AnonymizingCatalog {

    private final Map<String, String> anonymizingFields = new HashMap<>();
    private static AnonymizingCatalog instance = null;
    private AnonymizingCatalog(){}

    public static AnonymizingCatalog getInstance(){
        if (null==instance){
            instance = new AnonymizingCatalog();
        }
        return instance;
    }

    public void addAnonymizingField(String tableKey,String fieldName){
        anonymizingFields.put(tableKey.toLowerCase(),fieldName.toLowerCase());
    }

    public boolean isAnonymizingField(String tableKey,String fieldName){
        boolean key =  anonymizingFields.containsKey(tableKey);
        if (!key){
            return false;
        }
        String field = anonymizingFields.get(tableKey);
        return null!=field && field.equals(fieldName);
    }
}
