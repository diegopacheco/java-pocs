import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.MessageDigest;

public class Main {

    public static void main(String args[]) {
        SecretKey keyA = generateKey();
        System.out.println("Key A                : " + toHex(keyA.getEncoded()));
        System.out.println("FingerPrint (MD5)    : " + toHex(generateFingerPrint(keyA, "MD5")));
        System.out.println("FingerPrint (SHA256) : " + toHex(generateFingerPrint(keyA, "SHA256")));

        SecretKey keyB = generateKey();
        System.out.println("Key B                : " + toHex(keyB.getEncoded()));
        System.out.println("FingerPrint (MD5)    : " + toHex(generateFingerPrint(keyB, "MD5")));
        System.out.println("FingerPrint (SHA256) : " + toHex(generateFingerPrint(keyB, "SHA256")));

        System.out.println("Key A == Key B FingerPrints ? " + validate(keyA,keyB));
        System.out.println("Key A == Key A FingerPrints ? " + validate(keyA,keyA));
        System.out.println("Key B == Key B FingerPrints ? " + validate(keyB,keyB));
    }

    private static boolean validate(SecretKey keyA, SecretKey keyB) {
        try {
            byte[] finger1 = generateFingerPrint(keyA,"MD5");
            byte[] finger2 = generateFingerPrint(keyB,"MD5");
            String hex1    = toHex(finger1);
            String hex2    = toHex(finger2);
            return hex1.equals(hex2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] generateFingerPrint(SecretKey key, String algo) {
        try {
            MessageDigest digest = MessageDigest.getInstance(algo);
            byte[] result = digest.digest(key.getEncoded());
            //String output = Base64.getEncoder().encodeToString(result);
            return result;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String toHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();
    }

    private static SecretKey generateKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            SecretKey key = keyGenerator.generateKey();
            return key;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}