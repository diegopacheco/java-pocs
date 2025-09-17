package com.github.diegopacheco.java25.features;

import javax.crypto.KDF;
import javax.crypto.SecretKey;
import javax.crypto.spec.HKDFParameterSpec;

/**
 *  JEP 510: Key Derivation Function API
 *  https://openjdk.org/jeps/510
 *
 *  Introduces a new API for key derivation functions (KDFs)
 *  in the java.security and javax.crypto packages.
 *  This API provides a standard way to derive cryptographic keys
 *  from a given input keying material (IKM) using various KDF algorithms.
 *  The API includes support for popular KDFs such as PBKDF2,
 *  Scrypt, and Argon2.
 */
public class KeyDerivationFunction {
    static void main() {
        try {
            KDF hkdf = KDF.getInstance("HKDF-SHA256");

            byte[] ikm = "secret key material".getBytes();
            byte[] salt = "random salt".getBytes();
            byte[] info = "application info".getBytes();

            var params = HKDFParameterSpec.ofExtract()
                    .addIKM(ikm)
                    .addSalt(salt)
                    .thenExpand(info, 32);

            SecretKey derivedKey = hkdf.deriveKey("AES", params);
            byte[] keyBytes = derivedKey.getEncoded();

            System.out.println("Derived key length: " + keyBytes.length);
            System.out.println("Key algorithm: " + derivedKey.getAlgorithm());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
