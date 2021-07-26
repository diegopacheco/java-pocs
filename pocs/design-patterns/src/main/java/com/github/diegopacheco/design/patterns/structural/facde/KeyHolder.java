package com.github.diegopacheco.design.patterns.structural.facde;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class KeyHolder {

    private static IvParameterSpec defaultIv = new Encryptor().generateIv();
    private static SecretKey defaultKey = new Encryptor().generateKey(256);
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

}
