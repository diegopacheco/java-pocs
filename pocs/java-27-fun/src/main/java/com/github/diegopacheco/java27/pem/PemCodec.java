package com.github.diegopacheco.java27.pem;

import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PEMDecoder;
import java.security.PEMEncoder;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.ECGenParameterSpec;

public final class PemCodec {

    public static KeyPair generateKeyPair() throws GeneralSecurityException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("EC");
        generator.initialize(new ECGenParameterSpec("secp256r1"));
        return generator.generateKeyPair();
    }

    public static String encode(PublicKey key) {
        return PEMEncoder.of().encodeToString(key);
    }

    public static PublicKey decodePublicKey(String pem) {
        return PEMDecoder.of().decode(pem, PublicKey.class);
    }

    public static String encrypt(PrivateKey key, char[] password) {
        return PEMEncoder.of().withEncryption(password).encodeToString(key);
    }

    public static PrivateKey decrypt(String pem, char[] password) {
        return PEMDecoder.of().withDecryption(password).decode(pem, PrivateKey.class);
    }

    public static String typeOf(String pem) {
        return pem.lines().findFirst().orElse("").replace("-----BEGIN ", "").replace("-----", "");
    }
}
