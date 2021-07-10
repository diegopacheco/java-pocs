import org.apache.commons.crypto.cipher.CryptoCipher;
import org.apache.commons.crypto.utils.Utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws Exception{

        final SecretKeySpec key = new SecretKeySpec(getUTF8Bytes("1234567890123456"), "AES");
        final IvParameterSpec iv = new IvParameterSpec(getUTF8Bytes("1234567890123456"));
        final Properties properties = new Properties();
        final String transform = "AES/CBC/PKCS5Padding";
        final ByteBuffer outBuffer;
        final int bufferSize = 1024;
        final int updateBytes;
        final int finalBytes;
        try (CryptoCipher encipher = Utils.getCipherInstance(transform, properties)) {
            final ByteBuffer inBuffer = ByteBuffer.allocateDirect(bufferSize);
            outBuffer = ByteBuffer.allocateDirect(bufferSize);
            inBuffer.put(getUTF8Bytes("hello world!"));

            inBuffer.flip(); // ready for the cipher to read it
            System.out.println("inBuffer=" + asString(inBuffer));

            encipher.init(Cipher.ENCRYPT_MODE, key, iv);
            updateBytes = encipher.update(inBuffer, outBuffer);
            System.out.println(updateBytes);

            finalBytes = encipher.doFinal(inBuffer, outBuffer);
            System.out.println(finalBytes);
        }

        outBuffer.flip(); // ready for use as decrypt
        final byte[] encoded = new byte[updateBytes + finalBytes];
        outBuffer.duplicate().get(encoded);
        System.out.println(Arrays.toString(encoded));

        try (CryptoCipher decipher = Utils.getCipherInstance(transform, properties)) {
            decipher.init(Cipher.DECRYPT_MODE, key, iv);
            final ByteBuffer decoded = ByteBuffer.allocateDirect(bufferSize);
            decipher.update(outBuffer, decoded);
            decipher.doFinal(outBuffer, decoded);
            decoded.flip(); // ready for use
            System.out.println("decoded=" + asString(decoded));
        }
    }

    private static byte[] getUTF8Bytes(final String input) {
        return input.getBytes(StandardCharsets.UTF_8);
    }

    private static String asString(final ByteBuffer buffer) {
        final ByteBuffer copy = buffer.duplicate();
        final byte[] bytes = new byte[copy.remaining()];
        copy.get(bytes);
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
