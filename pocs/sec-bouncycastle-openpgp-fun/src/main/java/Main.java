import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.*;
import org.bouncycastle.openpgp.operator.PBESecretKeyDecryptor;
import org.bouncycastle.openpgp.operator.PGPDataEncryptorBuilder;
import org.bouncycastle.openpgp.operator.bc.*;

import java.io.*;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Date;
import java.util.Iterator;

public class Main {

    private static final String PASSPHRASE = "Password123456";

    private static PGPPrivateKey findSecretKey(PGPSecretKeyRingCollection pgpSec, long keyID, char[] pass) {
        try {
            PGPSecretKey pgpSecKey = pgpSec.getSecretKey(keyID);
            if (pgpSecKey == null) {
                return null;
            }
            PBESecretKeyDecryptor decryptorFactory = new BcPBESecretKeyDecryptorBuilder(
                    new BcPGPDigestCalculatorProvider()).build(PASSPHRASE.toCharArray());

            return pgpSecKey.extractPrivateKey(decryptorFactory);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] encrypt(byte[] clearData, PGPPublicKey encKey,
                                 String fileName, boolean withIntegrityCheck, boolean armor){
        try{
            if (fileName == null) {
                fileName = PGPLiteralData.CONSOLE;
            }

            ByteArrayOutputStream encOut = new ByteArrayOutputStream();
            OutputStream out = encOut;
            if (armor) {
                out = new ArmoredOutputStream(out);
            }

            ByteArrayOutputStream bOut = new ByteArrayOutputStream();
            PGPCompressedDataGenerator comData = new PGPCompressedDataGenerator(
                    PGPCompressedDataGenerator.ZIP);
            OutputStream cos = comData.open(bOut); // open it with the final
            // destination
            PGPLiteralDataGenerator lData = new PGPLiteralDataGenerator();
            // we want to generate compressed data. This might be a user option
            // later,
            // in which case we would pass in bOut.
            OutputStream pOut = lData.open(cos, // the compressed output stream
                    PGPLiteralData.BINARY, fileName, // "filename" to store
                    clearData.length, // length of clear data
                    new Date() // current time
            );
            pOut.write(clearData);

            lData.close();
            comData.close();

            PGPDataEncryptorBuilder encryptorBuilder = new BcPGPDataEncryptorBuilder( PGPEncryptedData.CAST5)
                    .setWithIntegrityPacket(withIntegrityCheck)
                    .setSecureRandom(new SecureRandom());

            PGPEncryptedDataGenerator cPk = new PGPEncryptedDataGenerator(encryptorBuilder);
            cPk.addMethod(new BcPublicKeyKeyEncryptionMethodGenerator(encKey));

            byte[] bytes = bOut.toByteArray();
            OutputStream cOut = cPk.open(out, bytes.length);
            cOut.write(bytes); // obtain the actual bytes from the compressed stream
            cOut.close();
            out.close();

            return encOut.toByteArray();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public static byte[] decrypt(byte[] encrypted, InputStream keyIn, char[] password){
        try{
            InputStream in = new ByteArrayInputStream(encrypted);
            in = PGPUtil.getDecoderStream(in);

            PGPObjectFactory pgpF = new PGPObjectFactory(in, new BcKeyFingerprintCalculator());
            PGPEncryptedDataList enc = null;
            Object o = pgpF.nextObject();

            // the first object might be a PGP marker packet.
            if (o instanceof PGPEncryptedDataList) {
                enc = (PGPEncryptedDataList) o;
            } else {
                enc = (PGPEncryptedDataList) pgpF.nextObject();
            }

            Iterator it = enc.getEncryptedDataObjects();
            PGPPrivateKey sKey = null;
            PGPPublicKeyEncryptedData pbe = null;
            PGPSecretKeyRingCollection pgpSec = new PGPSecretKeyRingCollection(
                    PGPUtil.getDecoderStream(keyIn),
                    new BcKeyFingerprintCalculator());

            while (sKey == null && it.hasNext()) {
                pbe = (PGPPublicKeyEncryptedData) it.next();

                sKey = findSecretKey(pgpSec, pbe.getKeyID(), password);
            }

            if (sKey == null) {
                throw new IllegalArgumentException(
                        "secret key for message not found.");
            }

            BcPublicKeyDataDecryptorFactory decryptorFactory = new BcPublicKeyDataDecryptorFactory(sKey);
            InputStream clear = pbe.getDataStream(decryptorFactory);
            PGPObjectFactory pgpFact = new PGPObjectFactory(clear, new BcKeyFingerprintCalculator());
            PGPCompressedData cData = (PGPCompressedData) pgpFact.nextObject();
            pgpFact = new PGPObjectFactory(cData.getDataStream(),new BcKeyFingerprintCalculator());

            PGPLiteralData ld = (PGPLiteralData) pgpFact.nextObject();
            InputStream unc = ld.getInputStream();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int ch;

            while ((ch = unc.read()) >= 0) {
                out.write(ch);
            }

            byte[] returnBytes = out.toByteArray();
            out.close();
            return returnBytes;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public static byte[] getBytesFromFile(File file) throws IOException {
        InputStream is = new FileInputStream(file);
        long length = file.length();
        if (length > Integer.MAX_VALUE) {
            // File is too large
            throw new RuntimeException("File too large - cant load into memory");
        }
        // Create the byte array to hold the data
        byte[] bytes = new byte[(int)length];

        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while (offset < bytes.length
                && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
            offset += numRead;
        }

        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file "+file.getName());
        }

        // Close the input stream and return bytes
        is.close();
        return bytes;
    }

    private static PGPPublicKey readPublicKey(InputStream in) {
        try{
            in = PGPUtil.getDecoderStream(in);
            PGPPublicKeyRingCollection pgpPub = new PGPPublicKeyRingCollection(in,new BcKeyFingerprintCalculator());
            //
            // we just loop through the collection till we find a key suitable for
            // encryption, in the real
            // world you would probably want to be a bit smarter about this.
            //
            Iterator rIt = pgpPub.getKeyRings();
            while (rIt.hasNext()) {
                PGPPublicKeyRing kRing = (PGPPublicKeyRing) rIt.next();
                Iterator kIt = kRing.getPublicKeys();
                while (kIt.hasNext()) {
                    PGPPublicKey k = (PGPPublicKey) kIt.next();

                    if (k.isEncryptionKey()) {
                        return k;
                    }
                }
            }
            throw new IllegalArgumentException("Can't find encryption key in key ring.");
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String args[]) throws Exception{
        Security.addProvider(new BouncyCastleProvider());

        byte[] original = "Hello world".getBytes();
        System.out.println("Starting PGP test");

        FileInputStream pubKey = new FileInputStream("/tmp/pub.key");
        byte[] encrypted = encrypt(original, readPublicKey(pubKey), null,
                true, true);

        FileOutputStream dfis = new FileOutputStream("/tmp/enc.asc");
        dfis.write(encrypted);
        dfis.close();

        byte[] encFromFile = getBytesFromFile(new File("/tmp/enc.asc"));
        FileInputStream secKey = new FileInputStream("/tmp/sec.key");

        System.out.println("\nencrypted data = '" + new String(encrypted) + "'");
        byte[] decrypted = decrypt(encFromFile, secKey, "passphrase".toCharArray());

        System.out.println("\ndecrypted data = '" + new String(decrypted) + "'");
    }
}
