package com.github.diegopacheco.design.patterns.structural.facde;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
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
}
