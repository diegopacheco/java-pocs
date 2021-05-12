package com.github.diegopacheco.java.pocs.visibility.core.protection;

public class CacheLoader {
    public static void load(){
        CacheService cs = CacheService.getInstance();
        cs.set(new LazyPair<String>("1","it works"));
    }
}
