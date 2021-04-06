package com.github.diegopacheco.java.pocs.utils;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;

public class OSEnvUtils {

    public static void setOSEnvVar(String key, String value) {
        try {
            Map<String, String> env = System.getenv();
            Class<?> cl = env.getClass();
            Field field = cl.getDeclaredField("m");
            field.setAccessible(true);
            Map<String, String> writableEnv = (Map<String, String>) field.get(env);
            writableEnv.put(key, value);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to set environment variable: " + key + " value: " + value, e);
        }
    }

    public static boolean isThisCodeRunningOnEC2(){
        Optional<Region> region = Optional.ofNullable(Regions.getCurrentRegion());
        return region.isPresent();
    }

}
