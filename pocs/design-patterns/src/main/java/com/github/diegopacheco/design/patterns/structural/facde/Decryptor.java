package com.github.diegopacheco.design.patterns.structural.facde;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Decryptor {

    public String decrypt(String ciphertext, SecretKey key, IvParameterSpec iv){
        try{
            byte[] input = Base64.getDecoder().decode(ciphertext);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key, iv);
            byte[] plaintext = cipher.doFinal(input);
            return new String(plaintext, StandardCharsets.UTF_8);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
