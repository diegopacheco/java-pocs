package com.github.diegopacheco.design.patterns.structural.facde;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.util.Base64;

public class Encryptor {

    public String encrypt(String input, SecretKey key, IvParameterSpec iv){
        try{
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key, iv);
            byte[] cipherText = cipher.doFinal(input.getBytes());
            return Base64.getEncoder().encodeToString(cipherText);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public SecretKey generateKey(int n){
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

    public IvParameterSpec generateIv() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }

}
