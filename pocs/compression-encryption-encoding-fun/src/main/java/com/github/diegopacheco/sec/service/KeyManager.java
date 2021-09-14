package com.github.diegopacheco.sec.service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class KeyManager {

    private Map<String,KeyIVPair> keys = new ConcurrentHashMap<>();

    public KeyIVPair getKey(String keyAlias){
        if ("developer".equals(keyAlias)){
            synchronized (KeyManager.class){
                if (null==keys.get(keyAlias)){
                    KeyIVPair keyIVPair = new KeyIVPair();
                    keyIVPair.key = generate256Key();
                    keyIVPair.iv = new byte[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
                    keys.put(keyAlias,keyIVPair);
                }
            }
            return keys.get(keyAlias);
        }
        // magically and as safe retrieve the key materials from external KMS System for the right microservice. :-)
        return null;
    }

    private static SecretKey generate256Key(){
        KeyGenerator generator = null;
        try {
            generator = KeyGenerator.getInstance("AES");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        generator.init(256);
        SecretKey key = generator.generateKey();
        return key;
    }

    public static class KeyIVPair{
        public SecretKey key;
        public byte[] iv;
    }

}
