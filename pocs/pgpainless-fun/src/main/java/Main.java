import org.bouncycastle.openpgp.PGPKeyRingGenerator;
import org.bouncycastle.openpgp.PGPPublicKeyRing;
import org.bouncycastle.openpgp.PGPSecretKeyRing;
import org.bouncycastle.util.io.Streams;
import org.pgpainless.PGPainless;
import org.pgpainless.algorithm.*;
import org.pgpainless.decryption_verification.DecryptionStream;
import org.pgpainless.decryption_verification.OpenPgpMetadata;
import org.pgpainless.encryption_signing.EncryptionOptions;
import org.pgpainless.encryption_signing.EncryptionStream;
import org.pgpainless.encryption_signing.ProducerOptions;
import org.pgpainless.encryption_signing.SigningOptions;
import org.pgpainless.key.generation.KeySpec;
import org.pgpainless.key.generation.type.ecc.EllipticCurve;
import org.pgpainless.key.generation.type.ecc.ecdh.ECDH;
import org.pgpainless.key.generation.type.ecc.ecdsa.ECDSA;
import org.pgpainless.key.generation.type.rsa.RSA;
import org.pgpainless.key.generation.type.rsa.RsaLength;
import org.pgpainless.key.protection.PasswordBasedSecretKeyRingProtector;
import org.pgpainless.key.protection.SecretKeyRingProtector;
import org.pgpainless.util.Passphrase;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Main {
    public static void main(String args[]) throws Exception {

        String PASSPHRASE = "123456";

        PGPKeyRingGenerator krgen =
                com.github.diegopacheco.bouncycastle.openpgp.rsa.GenerateRSAKey.
                        generateKeyRingGenerator("diego.pacheco.it@gmail.com", PASSPHRASE.toCharArray());

        PGPSecretKeyRing secKey = krgen.generateSecretKeyRing();
        PGPPublicKeyRing pubKey = krgen.generatePublicKeyRing();

        // RSA key without additional subkeys
        PGPSecretKeyRing secretKeys = PGPainless.generateKeyRing()
                .simpleRsaKeyRing("Diego <di@pacheco.diego>", RsaLength._4096);

        // Customized key
        PGPSecretKeyRing keyRing = PGPainless.generateKeyRing()
                .withSubKey(
                        KeySpec.getBuilder(ECDSA.fromCurve(EllipticCurve._P256))
                                .withKeyFlags(KeyFlag.SIGN_DATA)
                                .withDetailedConfiguration()
                                .withDefaultSymmetricAlgorithms()
                                .withDefaultHashAlgorithms()
                                .withPreferredCompressionAlgorithms(CompressionAlgorithm.ZLIB)
                                .withFeature(Feature.MODIFICATION_DETECTION)
                                .done()
                ).withSubKey(
                        KeySpec.getBuilder(ECDH.fromCurve(EllipticCurve._P256))
                                .withKeyFlags(KeyFlag.ENCRYPT_COMMS, KeyFlag.ENCRYPT_STORAGE)
                                .withDefaultAlgorithms()
                ).withMasterKey(
                        KeySpec.getBuilder(RSA.withLength(RsaLength._4096))
                                .withKeyFlags(KeyFlag.SIGN_DATA, KeyFlag.CERTIFY_OTHER)
                                .withDefaultAlgorithms()
                ).withPrimaryUserId("Diego <di@pacheco.diego>")
                .withPassphrase(new Passphrase("123456".toCharArray()))
                .build();

        FileInputStream plaintextInputStream = new FileInputStream("/tmp/msg.txt");
        FileOutputStream outputStream = new FileOutputStream("/tmp/out-painless.txt");

        SecretKeyRingProtector secProc = PasswordBasedSecretKeyRingProtector.forKey(
                secKey,
                new Passphrase(PASSPHRASE.toCharArray())
        );

        EncryptionStream encryptionStream = PGPainless.encryptAndOrSign()
                .onOutputStream(outputStream)
                .withOptions(
                        ProducerOptions.signAndEncrypt(
                                new EncryptionOptions()
                                        .addRecipient(pubKey)
                                        // optionally encrypt to a passphrase
                                        .addPassphrase(Passphrase.fromPassword("123456")),
                                        // optionally override symmetric encryption algorithm,
                                new SigningOptions()
                                        // Sign in-line (using one-pass-signature packet)
                                        .addInlineSignature(secProc, secretKeys, DocumentSignatureType.BINARY_DOCUMENT)
                                        // Sign using a detached signature
                                        .addDetachedSignature(secProc, secretKeys, DocumentSignatureType.BINARY_DOCUMENT)
                                        // optionally override hash algorithm
                                        .overrideHashAlgorithm(HashAlgorithm.SHA256)
                        ).setAsciiArmor(true) // Ascii armor or not
                );

        Streams.pipeAll(plaintextInputStream, encryptionStream);
        encryptionStream.close();

        FileInputStream encryptedInputStream = new FileInputStream("/tmp/out-painless.txt");

        DecryptionStream decryptionStream = PGPainless.decryptAndOrVerify()
                .onInputStream(encryptedInputStream)
                .decryptWith(secProc, secretKeys)
                .verifyWith(pubKey)
                .ignoreMissingPublicKeys()
                .build();

        Streams.pipeAll(decryptionStream, outputStream);
        decryptionStream.close();

        // Result contains information like signature status etc.
        OpenPgpMetadata metadata = decryptionStream.getResult();
        System.out.println(metadata);

        System.out.println("DONE.");
    }
}
