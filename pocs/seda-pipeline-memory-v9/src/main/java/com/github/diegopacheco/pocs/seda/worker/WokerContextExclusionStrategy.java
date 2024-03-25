package com.github.diegopacheco.pocs.seda.worker;

import com.google.gson.FieldAttributes;

import java.util.Arrays;
import java.util.List;

public class ExclusionStrategy implements com.google.gson.ExclusionStrategy {

    private List<String> ignoreFields = Arrays.asList(new String[]{
            "sedaManager",
            "completionHandler"});
    @Override
    public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        if (ignoreFields.contains(fieldAttributes.getName()))
            return true;
        return false;
    }

    @Override
    public boolean shouldSkipClass(Class<?> aClass) {
        return false;
    }
}
