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
        String USER_ID="diego.pacheco.it@gmail.com";

        PGPKeyRingGenerator krGen =
                com.github.diegopacheco.bouncycastle.openpgp.rsa.GenerateRSAKey.
                        generateKeyRingGenerator("", PASSPHRASE.toCharArray());

        PGPPublicKeyRing pubKey = krGen.generatePublicKeyRing();

        PGPSecretKeyRing secKey = PGPainless.generateKeyRing()
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
                ).withPrimaryUserId(USER_ID)
                .withPassphrase(Passphrase.fromPassword(PASSPHRASE))
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
                                        .addPassphrase(Passphrase.fromPassword(PASSPHRASE)),
                                new SigningOptions()
                                        .addInlineSignature(secProc, secKey, DocumentSignatureType.BINARY_DOCUMENT)
                                        .addDetachedSignature(secProc, secKey, DocumentSignatureType.BINARY_DOCUMENT)
                                        .overrideHashAlgorithm(HashAlgorithm.SHA256)
                        ).setAsciiArmor(true)
                );

        Streams.pipeAll(plaintextInputStream, encryptionStream);
        encryptionStream.close();

        FileInputStream encryptedInputStream = new FileInputStream("/tmp/out-painless.txt");

        DecryptionStream decryptionStream = PGPainless.decryptAndOrVerify()
                .onInputStream(encryptedInputStream)
                .decryptWith(secProc, secKey)
                .verifyWith(pubKey)
                .ignoreMissingPublicKeys()
                .build();

        Streams.pipeAll(decryptionStream, outputStream);
        decryptionStream.close();

        // Result contains information like signature status etc.
        OpenPgpMetadata metadata = decryptionStream.getResult();
        System.out.println(metadata);

        System.out.println("DONE.");
        System.out.println("Look: /tmp/out-painless.txt");
    }
}
