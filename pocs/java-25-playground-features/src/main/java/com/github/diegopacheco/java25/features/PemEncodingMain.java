package com.github.diegopacheco.java25.features;

import java.security.*;
import java.security.spec.*;
import java.util.Base64;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

/*
 * PEM Encoding (JEP 470)
 * https://openjdk.org/jeps/470
 *
 * This demonstrates the new PemEncoder and PemDecoder concepts
 * introduced in Java 25 for handling PEM format encoding/decoding
 *
 * Note: Since PemEncoder/PemDecoder classes are not yet available in this build,
 * we simulate their functionality to show how they would work.
 */
public class PemEncodingMain {

    public static void main(String[] args) {
        System.out.println("=== Java 25 PEM Encoding Concepts (JEP 470) ===\n");

        try {
            basicPemConcepts();
            certificatePemConcepts();
            privateKeyPemConcepts();
            encryptedPrivateKeyConcepts();
            customPemRecordConcepts();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void basicPemConcepts() throws NoSuchAlgorithmException, InvalidKeySpecException {
        System.out.println("1. Basic PEM Encoding/Decoding Concepts:");
        System.out.println("----------------------------------------");

        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();

        String publicKeyPem = encodeToPem("PUBLIC KEY", keyPair.getPublic().getEncoded());
        System.out.println("Public Key PEM (simulated PemEncoder):");
        System.out.println(publicKeyPem);

        byte[] decodedBytes = decodeFromPem(publicKeyPem);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decodedBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey decodedPublicKey = keyFactory.generatePublic(keySpec);

        System.out.println("Original algorithm: " + keyPair.getPublic().getAlgorithm());
        System.out.println("Decoded algorithm: " + decodedPublicKey.getAlgorithm());
        System.out.println("Keys match: " + keyPair.getPublic().equals(decodedPublicKey));
        System.out.println();
    }

    private static void certificatePemConcepts() throws NoSuchAlgorithmException, InvalidKeySpecException {
        System.out.println("2. Certificate PEM Concepts:");
        System.out.println("----------------------------");

        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("EC");
        keyGen.initialize(256);
        KeyPair keyPair = keyGen.generateKeyPair();

        String publicKeyPem = encodeToPem("PUBLIC KEY", keyPair.getPublic().getEncoded());
        System.out.println("EC Public Key PEM (simulated):");
        System.out.println(publicKeyPem);

        byte[] decodedBytes = decodeFromPem(publicKeyPem);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decodedBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("EC");
        PublicKey decodedKey = keyFactory.generatePublic(keySpec);

        System.out.println("Key algorithm: " + decodedKey.getAlgorithm());
        System.out.println("Key format: " + decodedKey.getFormat());
        System.out.println();
    }

    private static void privateKeyPemConcepts() throws NoSuchAlgorithmException, InvalidKeySpecException {
        System.out.println("3. Private Key PEM Concepts:");
        System.out.println("----------------------------");

        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("Ed25519");
        KeyPair keyPair = keyGen.generateKeyPair();

        String privateKeyPem = encodeToPem("PRIVATE KEY", keyPair.getPrivate().getEncoded());
        System.out.println("Ed25519 Private Key PEM (first 300 chars):");
        System.out.println(privateKeyPem.substring(0, Math.min(300, privateKeyPem.length())) + "...");

        byte[] decodedBytes = decodeFromPem(privateKeyPem);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decodedBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("Ed25519");
        PrivateKey decodedPrivateKey = keyFactory.generatePrivate(keySpec);

        System.out.println("Key algorithm: " + decodedPrivateKey.getAlgorithm());
        System.out.println("Key format: " + decodedPrivateKey.getFormat());
        System.out.println("Keys match: " + keyPair.getPrivate().equals(decodedPrivateKey));
        System.out.println();
    }

    private static void encryptedPrivateKeyConcepts() throws GeneralSecurityException {
        System.out.println("4. Encrypted Private Key Concepts:");
        System.out.println("----------------------------------");

        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();

        char[] password = "mySecretPassword".toCharArray();
        String unencryptedPem = encodeToPem("PRIVATE KEY", keyPair.getPrivate().getEncoded());
        System.out.println("Unencrypted Private Key PEM (first 200 chars):");
        System.out.println(unencryptedPem.substring(0, Math.min(200, unencryptedPem.length())) + "...");
        System.out.println();
    }

    private static void customPemRecordConcepts() {
        System.out.println("5. Custom PemRecord Concepts:");
        System.out.println("-----------------------------");

        String customType = "CUSTOM OBJECT";
        String customContent = "VGhpcyBpcyBhIGN1c3RvbSBQRU0gY29udGVudA=="; // Base64 encoded

        String customPem = encodeToPem(customType, Base64.getDecoder().decode(customContent));

        System.out.println("Custom PEM Object (simulated PemRecord):");
        System.out.println(customPem);

        String extractedType = extractPemType(customPem);
        byte[] extractedContent = decodeFromPem(customPem);
        String extractedBase64 = Base64.getEncoder().encodeToString(extractedContent);

        System.out.println("Decoded type: " + extractedType);
        System.out.println("Content matches: " + customContent.equals(extractedBase64));
        System.out.println();
    }

    private static String encodeToPem(String type, byte[] data) {
        String base64 = Base64.getMimeEncoder(64, System.lineSeparator().getBytes())
                .encodeToString(data);
        return "-----BEGIN " + type + "-----" + System.lineSeparator() +
               base64 + System.lineSeparator() +
               "-----END " + type + "-----";
    }

    private static byte[] decodeFromPem(String pem) {
        String base64Content = pem
                .replaceAll("-----BEGIN [^-]+-----", "")
                .replaceAll("-----END [^-]+-----", "")
                .replaceAll("\\s", "");
        return Base64.getDecoder().decode(base64Content);
    }

    private static String extractPemType(String pem) {
        String[] lines = pem.split(System.lineSeparator());
        for (String line : lines) {
            if (line.startsWith("-----BEGIN ")) {
                return line.replace("-----BEGIN ", "").replace("-----", "");
            }
        }
        return "UNKNOWN";
    }
}
