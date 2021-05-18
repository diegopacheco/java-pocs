package com.github.diegopacheco.enc.deep.dive.keys;

import com.github.diegopacheco.enc.deep.dive.prng.SecureRandomGenerator;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Encryptor {
    public static String encrypt(String plaintext, SecretKey key,byte[] iv){
        try{
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec spec = new SecretKeySpec(key.getEncoded(), "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(iv);
            cipher.init(Cipher.ENCRYPT_MODE,spec,ivSpec);
            byte[] cipherText = cipher.doFinal(plaintext.getBytes(StandardCharsets.UTF_8));
            return new String(Base64.getEncoder().
                    encode(cipherText),StandardCharsets.UTF_8);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws Exception{
        SecretKey key = SimpleKeyGenerator.generate256Key();
        System.out.println("Key: " + new String(
                Base64.getEncoder().encode(key.getEncoded()),StandardCharsets.UTF_8));
        byte[] iv = SecureRandomGenerator.generate();
        System.out.println("IV: " + new String(
                Base64.getEncoder().encode(iv),StandardCharsets.UTF_8));
        System.out.println("Ciphertext: " + Encryptor.encrypt(
                "this is a test message!",
                 key, iv));
        // it will print something like:
        // Key: oVMYqd8mOqQ7dfhtvLow4aKbmcNt6VeuDq7l9Hnn/kQ=
        // IV: sl/btZyVkW02bMnyESCh/A==
        // Ciphertext: kfweYmu0G5UcJOmrQ7MeKTy1l5HPynRf8zYcDjvX/4c=
    }
}
