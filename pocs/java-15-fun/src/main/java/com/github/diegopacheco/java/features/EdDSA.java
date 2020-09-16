package com.github.diegopacheco.java.features;

import java.math.BigInteger;
import java.security.*;
import java.security.spec.EdECPoint;
import java.security.spec.EdECPublicKeySpec;
import java.security.spec.NamedParameterSpec;

public class EdDSA {
    public static void main(String[] args) throws Exception {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("Ed25519");
        KeyPair keyPair = keyPairGen.generateKeyPair();
        // use Ed25519 algorithm
        Signature signature = Signature.getInstance("Ed25519");
        signature.initSign(keyPair.getPrivate());
        signature.update("hi this is a message".getBytes());
        byte[] s = signature.sign();
        System.out.println("signed bytes: " + s);

        KeyFactory keyFactory = KeyFactory.getInstance("EdDSA");
        boolean param1 = true;
        BigInteger param2 = new BigInteger("1");
        NamedParameterSpec paramsSpec = new NamedParameterSpec("Ed25519");
        EdECPublicKeySpec publicSpec = new EdECPublicKeySpec(paramsSpec, new EdECPoint(param1, param2));
        PublicKey publicKey = keyFactory.generatePublic(publicSpec);
        System.out.println("public key: " + publicKey);
    }
}
