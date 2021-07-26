package com.github.diegopacheco.design.patterns.structural.facde;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class KeyMaterial {

    private SecretKey key;
    private IvParameterSpec iv;

    public KeyMaterial(SecretKey key, IvParameterSpec iv) {
        this.key = key;
        this.iv = iv;
    }

    public static KeyMaterial of(SecretKey key, IvParameterSpec iv){
        return new KeyMaterial(key,iv);
    }

    public SecretKey getKey() {
        return key;
    }
    public IvParameterSpec getIv() {
        return iv;
    }
}
