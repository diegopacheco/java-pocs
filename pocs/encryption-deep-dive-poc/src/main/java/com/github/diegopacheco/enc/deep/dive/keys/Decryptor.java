package com.github.diegopacheco.enc.deep.dive.keys;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Decryptor {
    public static String decrypt(String ciphertext, SecretKey key, byte[] iv){
        try{
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec spec = new SecretKeySpec(Base64.getDecoder().decode
                    (key.getEncoded()), "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(Base64.getDecoder().decode(iv));
            cipher.init(Cipher.DECRYPT_MODE,spec,ivSpec);
            byte[] plaintext = cipher.doFinal(Base64.getDecoder().
                    decode(ciphertext.getBytes(StandardCharsets.UTF_8)));
            return new String(plaintext,StandardCharsets.UTF_8);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        SecretKey key =
                new SecretKeySpec(
                        new String("oVMYqd8mOqQ7dfhtvLow4aKbmcNt6VeuDq7l9Hnn/kQ=").
                                getBytes(StandardCharsets.UTF_8),"AES"
        );
        byte[] iv = new String("sl/btZyVkW02bMnyESCh/A==").getBytes(StandardCharsets.UTF_8);
        System.out.println("Plaintext: " +
                Decryptor.decrypt(
                        "kfweYmu0G5UcJOmrQ7MeKTy1l5HPynRf8zYcDjvX/4c=",
                         key,iv
                ));
    }
}
