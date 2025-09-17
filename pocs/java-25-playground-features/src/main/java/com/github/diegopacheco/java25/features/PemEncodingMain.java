package com.github.diegopacheco.java25.features;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

/*
 * Pem Encoding (JEP 470)
 * https://openjdk.org/jeps/470
 */
public class PemEncodingMain {

    public static void main(String[] args) {
        System.out.println("=== Java 25 PEM Encoding Examples (JEP 470) ===\n");
        try {
            basicPemExample();
            certificateExample();
            privateKeyExample();
            multiplePemExample();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void basicPemExample() {
        System.out.println("1. Basic PEM Encoding/Decoding Example:");
        System.out.println("----------------------------------------");

        byte[] data = "Hello, Java 25 PEM encoding!".getBytes();
        String pemEncoded = Base64.getMimeEncoder(64, "\n".getBytes())
                .encodeToString(data);

        String pemFormatted = "-----BEGIN MESSAGE-----\n" +
                             pemEncoded + "\n" +
                             "-----END MESSAGE-----";

        System.out.println("Original data: " + new String(data));
        System.out.println("PEM encoded:\n" + pemFormatted);

        String base64Content = pemFormatted
                .replace("-----BEGIN MESSAGE-----", "")
                .replace("-----END MESSAGE-----", "")
                .replaceAll("\\s", "");

        byte[] decoded = Base64.getDecoder().decode(base64Content);
        System.out.println("Decoded data: " + new String(decoded));
        System.out.println();
    }

    private static void certificateExample() throws NoSuchAlgorithmException {
        System.out.println("2. Certificate PEM Example:");
        System.out.println("---------------------------");

        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();

        byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
        String publicKeyPem = formatAsPem("PUBLIC KEY", publicKeyBytes);

        System.out.println("Public Key PEM format:");
        System.out.println(publicKeyPem);

        String base64PublicKey = extractBase64Content(publicKeyPem);
        byte[] decodedPublicKey = Base64.getDecoder().decode(base64PublicKey);

        System.out.println("Original key length: " + publicKeyBytes.length + " bytes");
        System.out.println("Decoded key length: " + decodedPublicKey.length + " bytes");
        System.out.println("Keys match: " + java.util.Arrays.equals(publicKeyBytes, decodedPublicKey));
        System.out.println();
    }

    private static void privateKeyExample() throws NoSuchAlgorithmException {
        System.out.println("3. Private Key PEM Example:");
        System.out.println("---------------------------");

        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();

        byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
        String privateKeyPem = formatAsPem("PRIVATE KEY", privateKeyBytes);

        System.out.println("Private Key PEM format (first 500 chars):");
        System.out.println(privateKeyPem.substring(0, Math.min(500, privateKeyPem.length())) + "...");

        System.out.println("Key algorithm: " + keyPair.getPrivate().getAlgorithm());
        System.out.println("Key format: " + keyPair.getPrivate().getFormat());
        System.out.println("Key size: " + privateKeyBytes.length + " bytes");
        System.out.println();
    }

    private static void multiplePemExample() {
        System.out.println("4. Multiple PEM Objects Example:");
        System.out.println("--------------------------------");

        String cert1 = formatAsPem("CERTIFICATE", "MIICert1Data".getBytes());
        String cert2 = formatAsPem("CERTIFICATE", "MIICert2Data".getBytes());
        String key = formatAsPem("PRIVATE KEY", "MIIPrivateKeyData".getBytes());

        String combinedPem = cert1 + "\n" + cert2 + "\n" + key;

        System.out.println("Combined PEM file:");
        System.out.println(combinedPem);

        List<String> pemObjects = parsePemObjects(combinedPem);
        System.out.println("Found " + pemObjects.size() + " PEM objects:");
        for (int i = 0; i < pemObjects.size(); i++) {
            String type = extractPemType(pemObjects.get(i));
            System.out.println("  " + (i + 1) + ". " + type);
        }
        System.out.println();
    }

    private static String formatAsPem(String type, byte[] data) {
        String base64 = Base64.getMimeEncoder(64, "\n".getBytes())
                .encodeToString(data);
        return "-----BEGIN " + type + "-----\n" +
               base64 + "\n" +
               "-----END " + type + "-----";
    }

    private static String extractBase64Content(String pem) {
        return pem.replaceAll("-----BEGIN [^-]+-----", "")
                  .replaceAll("-----END [^-]+-----", "")
                  .replaceAll("\\s", "");
    }

    private static String extractPemType(String pem) {
        String[] lines = pem.split("\n");
        for (String line : lines) {
            if (line.startsWith("-----BEGIN ")) {
                return line.replace("-----BEGIN ", "").replace("-----", "");
            }
        }
        return "UNKNOWN";
    }

    private static List<String> parsePemObjects(String combinedPem) {
        List<String> objects = new java.util.ArrayList<>();
        String[] parts = combinedPem.split("(?=-----BEGIN)");

        for (String part : parts) {
            if (part.trim().startsWith("-----BEGIN")) {
                objects.add(part.trim());
            }
        }

        return objects;
    }
}
