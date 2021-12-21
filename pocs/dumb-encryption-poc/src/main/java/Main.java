import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Main {
    public static void main(String args[]) throws Exception {
        SecretKey key256_1 = generate256Key();
        SecretKey key256_2 = generate256Key();
        String name = "Diego Pacheco";
        String cipherText1 = new String(Base64.getEncoder().encode(encrypt(key256_1,name.getBytes(StandardCharsets.UTF_8))),StandardCharsets.UTF_8);
        String cipherText2 = new String(Base64.getEncoder().encode(encrypt(key256_1,name.getBytes(StandardCharsets.UTF_8))),StandardCharsets.UTF_8);
        String cipherText3 = new String(Base64.getEncoder().encode(encrypt(key256_2,name.getBytes(StandardCharsets.UTF_8))),StandardCharsets.UTF_8);
        System.out.println("Name is: " + name);
        System.out.println("Ciphertext 1 - key 1: " + cipherText1);
        System.out.println("Ciphertext 2 - key 1: " + cipherText2);
        System.out.println("Ciphertext 3 - key 2: " + cipherText3);
        System.out.println("Name back is        : " + new String(decrypt(key256_1,Base64.getDecoder().
                decode(cipherText1.getBytes(StandardCharsets.UTF_8))),StandardCharsets.UTF_8));
    }

    private static SecretKey generate256Key() {
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

    public static byte[] encrypt(SecretKey key, byte[] plaintext) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(new byte[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);
            byte[] cipherText = cipher.doFinal(plaintext);
            return cipherText;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] decrypt(SecretKey key, byte[] cipherText) {
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(new byte[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
            byte[] plaintext = cipher.doFinal(cipherText);
            return plaintext;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
