package com.github.diegopacheco.javapocs.features21.keyencapsulationmechanism;

import javax.crypto.KEM;
import javax.crypto.SecretKey;
import java.security.*;

//
// NoSuchAlgorithmException: RSA-KEM KEM not available
//
public class Main {
    public static void main(String[] args) throws Throwable {
        // Receiver side
        KeyPairGenerator g = KeyPairGenerator.getInstance("RSA");
        KeyPair kp = g.generateKeyPair();

        // Sender side
        KEM kemS = KEM.getInstance("RSA-KEM");
        PublicKey pkR = kp.getPublic();
        //ABCKEMParameterSpec specS = new ABCKEMParameterSpec(...);
        KEM.Encapsulator e = kemS.newEncapsulator(pkR, null, null);
        KEM.Encapsulated enc = e.encapsulate();
        SecretKey secS = enc.key();

    }
}