package com.github.diegopacheco.design.patterns.structural.facde;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Hasher {

    private MessageDigest digest;

    public Hasher(){
        try{
             digest = MessageDigest.getInstance("SHA-256");
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public String hash(String source){
        byte[] encodedhash = digest.digest(source.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(encodedhash);
    }

    private String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }

}