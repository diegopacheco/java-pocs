package com.github.diegopacheco.enc.deep.dive.prng;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class SecureRandomGenerator {

    public static byte[] generate(){
        SecureRandom secureRandom = null;
        try {
            secureRandom = SecureRandom.getInstance("NativePRNG");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        byte[] rndBytes = new byte[16];
        secureRandom.nextBytes(rndBytes);
        return  rndBytes;
    }

    public static void main(String[] args) throws Exception{
        // something like: yMvz6QeIjkBkcSiYgZvfMQ==
        System.out.println(new String(Base64.getEncoder().
                encode(SecureRandomGenerator.generate()),"UTF-8"));
    }

}
