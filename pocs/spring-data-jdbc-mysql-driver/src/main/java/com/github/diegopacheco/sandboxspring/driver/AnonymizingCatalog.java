package com.github.diegopacheco.sandboxspring.driver;

import java.util.HashMap;
import java.util.Map;

public class AnonymizingCatalog {

    private final Map<String, Boolean> anonymizingFields = new HashMap<>();
    private static AnonymizingCatalog instance = null;
    private AnonymizingCatalog(){}

    public static AnonymizingCatalog getInstance(){
        if (null==instance){
            instance = new AnonymizingCatalog();
        }
        return instance;
    }

    public void addAnonymizingField(String tableKey,String fieldName){
        anonymizingFields.put(tableKey.toLowerCase()+fieldName.toLowerCase(),true);
    }

    public boolean isAnonymizingField(String tableKey,String fieldName){
        return anonymizingFields.containsKey(tableKey+fieldName);
    }
}
