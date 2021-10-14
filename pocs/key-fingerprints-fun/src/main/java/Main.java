import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.MessageDigest;

public class Main {

    public static void main(String args[]) {
        SecretKey key = generateKey();
        System.out.println("Key                  : " + toHex(key.getEncoded()));
        System.out.println("FingerPrint (MD5)    : " + toHex(generateFingerPrint(key,"MD5")));
        System.out.println("FingerPrint (SHA256) : " + toHex(generateFingerPrint(key,"SHA256")));
    }

    private static byte[] generateFingerPrint(SecretKey key,String algo) {
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