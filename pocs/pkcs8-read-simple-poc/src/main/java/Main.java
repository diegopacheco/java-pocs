import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemObjectGenerator;
import org.bouncycastle.util.io.pem.PemWriter;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;

public class Main {
    public static void main(String args[]) {
        generatePKCS8_PublicPrivateKeyPairs();
        System.out.println("DONE");
    }

    public static void generatePKCS8_PublicPrivateKeyPairs() {
        try {
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
            keyPairGen.initialize(2048);

            KeyPair pair = keyPairGen.generateKeyPair();
            PrivateKey privateKey = pair.getPrivate();
            PublicKey publicKey = pair.getPublic();

            System.out.println("Private Key:\n" + new String(Base64.getEncoder().encode(privateKey.getEncoded()), "UTF-8"));
            System.out.println("Public Key:\n" + new String(Base64.getEncoder().encode(publicKey.getEncoded()), "UTF-8"));
            System.out.println("Private key Format " + privateKey.getFormat());
            System.out.println("Public key Format " + privateKey.getFormat());

            writeKey(pair);

            KeyPair kp = getKeys();
            System.out.println(kp.getPrivate());
            System.out.println(kp.getPublic());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void writeKey(KeyPair pair) {
        try {
            StringWriter sw = new StringWriter();
            try (PemWriter writer = new PemWriter(sw);) {
                writer.writeObject((PemObjectGenerator) new PemObject("PRIVATE KEY", pair.getPrivate().getEncoded()));
                writer.writeObject((PemObjectGenerator) new PemObject("PUBLIC KEY", pair.getPublic().getEncoded()));
            }
            String pemFormat = sw.toString();
            System.out.println(pemFormat);

            keyToDisk(pair.getPrivate().getEncoded(),"PRIVATE KEY","target/private-key.pem");
            keyToDisk(pair.getPrivate().getEncoded(),"PUBLIC KEY","target/public-key.pem");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void keyToDisk(byte[] key, String desc, String path) {
        try {
            PrintWriter diskWriter = new PrintWriter(path, "UTF-8");
            diskWriter.println(keyToString(key,desc));
            diskWriter.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String keyToString(byte[] key, String desc) {
        try {
            StringWriter sw = new StringWriter();
            try (PemWriter writer = new PemWriter(sw);) {
                writer.writeObject((PemObjectGenerator) new PemObject(desc, key));
            }
            return sw.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] readKey(String keyPath) {
        try {
            File file = new File(keyPath);
            FileInputStream fis = new FileInputStream(file);
            DataInputStream dis = new DataInputStream(fis);

            byte[] keyBytes = new byte[(int) file.length()];
            dis.readFully(keyBytes);
            dis.close();

            return keyBytes;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static KeyPair getKeys() {
        try {
            byte[] privateKeyBytes = readKey("target/private-key.pem");
            byte[] publicKeyBytes = readKey("target/public-key.pem");

            KeyFactory kf = KeyFactory.getInstance("RSA");
            RSAPrivateKey privKey = (RSAPrivateKey) kf.generatePrivate(new PKCS8EncodedKeySpec(cleanup(privateKeyBytes)));
            RSAPublicKey pubKey = (RSAPublicKey) kf.generatePublic(new RSAPublicKeySpec(
                    new BigInteger(1,cleanup(publicKeyBytes)),
                    new BigInteger(1,"65537".getBytes(StandardCharsets.UTF_8))));

            return new KeyPair((PublicKey) pubKey, (PrivateKey) privKey);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] cleanup(byte[] key){
        try{
            String rawStr = new String(key, StandardCharsets.UTF_8);
            String cleanStr = rawStr.replaceAll("-----BEGIN PRIVATE KEY-----","");
            cleanStr = cleanStr.replaceAll("-----END PRIVATE KEY-----","");
            cleanStr = cleanStr.replaceAll("-----BEGIN PUBLIC KEY-----","");
            cleanStr = cleanStr.replaceAll("-----END PUBLIC KEY-----","");
            cleanStr = cleanStr.replaceAll("\n","");
            return Base64.getDecoder().decode(cleanStr.getBytes(StandardCharsets.UTF_8));
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
