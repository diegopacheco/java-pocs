package com.github.diegopacheco.java.pocs.visibility.core.protection;

import com.github.diegopacheco.java.pocs.visibility.core.Readable;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheService implements Writeable<String>, Readable<String> {

    private static volatile CacheService INSTANCE;
    private static Map<String,String> innerCache = new ConcurrentHashMap<>();

    public static CacheService getInstance(){
        if (null==INSTANCE){
            synchronized (CacheService.class){
                if (null==INSTANCE){
                    INSTANCE=new CacheService();
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public String get(String key) {
        return innerCache.get(key);
    }

    @Override
    public void set(String key, String value) {
        innerCache.put(key,value);
    }
}
