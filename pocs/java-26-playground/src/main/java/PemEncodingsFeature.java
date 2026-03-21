/**
 * JEP 524: PEM Encodings of Cryptographic Objects (Second Preview)
 * Provides API for encoding/decoding cryptographic objects in PEM format using PEMEncoder and PEMDecoder.
 * @see <a href="https://openjdk.org/jeps/524">JEP 524</a>
 */
import java.security.KeyPairGenerator;
import java.security.KeyPair;
import java.security.PublicKey;
import java.security.PrivateKey;
import java.security.PEMEncoder;
import java.security.PEMDecoder;

public class PemEncodingsFeature {
    public static void run() throws Exception {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair keyPair = kpg.generateKeyPair();

        PEMEncoder pemEncoder = PEMEncoder.of();
        String publicKeyPem = pemEncoder.encodeToString(keyPair.getPublic());
        System.out.println("PEM Encoded Public Key:");
        System.out.println(publicKeyPem.substring(0, 60) + "...");

        String privateKeyPem = pemEncoder.encodeToString(keyPair.getPrivate());
        System.out.println("PEM Encoded Private Key:");
        System.out.println(privateKeyPem.substring(0, 60) + "...");

        PEMDecoder pemDecoder = PEMDecoder.of();
        PublicKey decodedPublicKey = pemDecoder.decode(publicKeyPem, PublicKey.class);
        System.out.println("Decoded Public Key Algorithm: " + decodedPublicKey.getAlgorithm());
    }
}
