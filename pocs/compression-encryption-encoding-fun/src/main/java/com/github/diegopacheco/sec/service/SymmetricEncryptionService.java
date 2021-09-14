package com.github.diegopacheco.sec.service;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

class SymmetricEncryptionService {

    public byte[] encrypt(KeyManager.KeyIVPair keyIVPair, byte[] plaintext){
        try{
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec keySpec = new SecretKeySpec(keyIVPair.key.getEncoded(), "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(keyIVPair.iv);
            cipher.init(Cipher.ENCRYPT_MODE,keySpec,ivSpec);
            byte[] cipherText = cipher.doFinal(plaintext);
            return cipherText;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public byte[] decrypt(KeyManager.KeyIVPair keyIVPair,byte[] cipherText){
        try{
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec keySpec = new SecretKeySpec(keyIVPair.key.getEncoded(), "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(keyIVPair.iv);
            cipher.init(Cipher.DECRYPT_MODE,keySpec,ivSpec);
            byte[] plaintext = cipher.doFinal(cipherText);
            return plaintext;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
