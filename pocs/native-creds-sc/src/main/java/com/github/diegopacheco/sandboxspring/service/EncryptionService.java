package com.github.diegopacheco.sandboxspring.service;

import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
public class EncryptionService {

    private KeyIVPair creds;

    private class KeyIVPair {
        public SecretKey key;
        public byte[] iv;
    }

    public EncryptionService() {
        creds = new KeyIVPair();
        creds.key = generate256Key();
        creds.iv = new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    }

    public String enc(String key, String pt) {
        byte[] cipherText = encrypt(pt.getBytes(StandardCharsets.UTF_8));
        byte[] encoded = encode(cipherText);
        String result = new String(encoded, StandardCharsets.UTF_8);
        return result;
    }

    public String dec(String key, String ct) {
        byte[] decoded = decode(ct.getBytes(StandardCharsets.UTF_8));
        byte[] plainText = decrypt(decoded);
        String result = new String(plainText, StandardCharsets.UTF_8);
        return result;
    }

    private byte[] encrypt(byte[] plaintext) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec keySpec = new SecretKeySpec(creds.key.getEncoded(), "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(creds.iv);
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
            byte[] cipherText = cipher.doFinal(plaintext);
            return cipherText;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] decrypt(byte[] cipherText) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec keySpec = new SecretKeySpec(creds.key.getEncoded(), "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(creds.iv);
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
            byte[] plaintext = cipher.doFinal(cipherText);
            return plaintext;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private byte[] encode(byte[] cleanText) {
        return Base64.getEncoder().encode(cleanText);
    }

    private byte[] decode(byte[] cipherText) {
        return Base64.getDecoder().decode(cipherText);
    }

    private SecretKey generate256Key() {
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

}
