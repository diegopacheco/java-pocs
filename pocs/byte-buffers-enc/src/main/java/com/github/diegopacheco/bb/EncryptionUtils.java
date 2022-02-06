package com.github.diegopacheco.bb;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;

public class EncryptionUtils {

    private static byte[] key128;
    private static byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    private static IvParameterSpec ivspec = new IvParameterSpec(iv);
    private static SecretKeySpec secret;

    static{
        try{
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(128);
            key128 = kg.generateKey().getEncoded();
            secret = new SecretKeySpec(key128, "AES");
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public static ByteBuffer encrypt(ByteBuffer bb){
        try{
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secret, ivspec);
            byte[] cipherText = cipher.doFinal(bb.array());
            return ByteBuffer.wrap(cipherText);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public static ByteBuffer decrypt(ByteBuffer bb){
        try{
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secret, ivspec);
            byte[] cipherText = cipher.doFinal(bb.array());
            return ByteBuffer.wrap(cipherText);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
