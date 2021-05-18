package com.github.diegopacheco.enc.deep.dive.keys;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SimpleKeyGenerator {
    public static SecretKey generate256Key(){
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
    public static void main(String[] args) throws Exception{
        // something like: Et3UOI0z2fQyeBoDVW1jMIKMRBNRFoJIvBP3N2V+2hk=
        System.out.println(new String(Base64.getEncoder().
                encode(SimpleKeyGenerator.generate256Key().getEncoded()
                ),"UTF-8"));
    }
}
