package com.github.diegopacheco.design.patterns.structural.facde;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class KeyHolder {

    private static IvParameterSpec defaultIv = generateIv();
    private static SecretKey defaultKey = generateKey(256);
    private static Map<String, SecretKey> keys = new ConcurrentHashMap<>();

    static{
        // should pre-load all custom keys from KMS like Vault.
    }

    public KeyMaterial getKey(String alias){
        SecretKey key = keys.get(alias);
        if (null==key){
            key=defaultKey;
        }
        return  KeyMaterial.of(key,defaultIv);
    }

    public static SecretKey generateKey(int n){
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(n);
            SecretKey key = keyGenerator.generateKey();
            return key;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static IvParameterSpec generateIv() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }


}
