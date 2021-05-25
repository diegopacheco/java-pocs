package com.github.diegopacheco.bouncycastle.openpgp.rsa;

import org.bouncycastle.bcpg.ArmoredOutputStream;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.*;
import org.bouncycastle.openpgp.jcajce.JcaPGPObjectFactory;
import org.bouncycastle.openpgp.operator.PBESecretKeyDecryptor;
import org.bouncycastle.openpgp.operator.bc.BcKeyFingerprintCalculator;
import org.bouncycastle.openpgp.operator.bc.BcPBESecretKeyDecryptorBuilder;
import org.bouncycastle.openpgp.operator.bc.BcPGPDigestCalculatorProvider;
import org.bouncycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator;
import org.bouncycastle.openpgp.operator.jcajce.JcePGPDataEncryptorBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcePublicKeyDataDecryptorFactoryBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcePublicKeyKeyEncryptionMethodGenerator;
import org.bouncycastle.util.io.Streams;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.util.Base64;
import java.util.Iterator;

public class KeyBasedLargeFileProcessor {

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

    private static PGPPublicKey readPublicKey(InputStream in) {
        try {
            in = PGPUtil.getDecoderStream(in);
            PGPPublicKeyRingCollection pgpPub = new PGPPublicKeyRingCollection(in, new BcKeyFingerprintCalculator());
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
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void decryptFile(
            String inputFileName,
            String keyFileName,
            char[] passwd,
            String defaultFileName)
            throws IOException, NoSuchProviderException {
        InputStream in = new BufferedInputStream(new FileInputStream(inputFileName));
        InputStream keyIn = new BufferedInputStream(new FileInputStream(keyFileName));
        decryptFile(in, keyIn, passwd, defaultFileName);
        keyIn.close();
        in.close();
    }

    private static void decryptFile(
            InputStream in,
            InputStream keyIn,
            char[] passwd,
            String defaultFileName)
            throws IOException, NoSuchProviderException {
        in = PGPUtil.getDecoderStream(in);
        try {
            JcaPGPObjectFactory pgpF = new JcaPGPObjectFactory(in);
            PGPEncryptedDataList enc;

            Object o = pgpF.nextObject();
            //
            // the first object might be a PGP marker packet.
            //
            if (o instanceof PGPEncryptedDataList) {
                enc = (PGPEncryptedDataList) o;
            } else {
                enc = (PGPEncryptedDataList) pgpF.nextObject();
            }

            //
            // find the secret key
            //
            Iterator it = enc.getEncryptedDataObjects();
            PGPPrivateKey sKey = null;
            PGPPublicKeyEncryptedData pbe = null;
            PGPSecretKeyRingCollection pgpSec = new PGPSecretKeyRingCollection(
                    PGPUtil.getDecoderStream(keyIn), new JcaKeyFingerprintCalculator());

            while (sKey == null && it.hasNext()) {
                pbe = (PGPPublicKeyEncryptedData) it.next();
                sKey = findSecretKey(pgpSec, pbe.getKeyID(), passwd);
            }

            if (sKey == null) {
                throw new IllegalArgumentException("secret key for message not found.");
            }

            InputStream clear = pbe.getDataStream(new JcePublicKeyDataDecryptorFactoryBuilder().setProvider("BC").build(sKey));
            JcaPGPObjectFactory plainFact = new JcaPGPObjectFactory(clear);
            PGPCompressedData cData = (PGPCompressedData) plainFact.nextObject();
            InputStream compressedStream = new BufferedInputStream(cData.getDataStream());
            JcaPGPObjectFactory pgpFact = new JcaPGPObjectFactory(compressedStream);

            Object message = pgpFact.nextObject();
            if (message instanceof PGPLiteralData) {
                PGPLiteralData ld = (PGPLiteralData) message;

                String outFileName = ld.getFileName();
                /*
                if (outFileName.length() == 0) {
                    outFileName = defaultFileName;
                }*/
                outFileName = defaultFileName;
                System.out.println("using: " + outFileName);

                InputStream unc = ld.getInputStream();
                OutputStream fOut = new BufferedOutputStream(new FileOutputStream(outFileName));

                Streams.pipeAll(unc, fOut);

                fOut.close();
            } else if (message instanceof PGPOnePassSignatureList) {
                throw new PGPException("encrypted message contains a signed message - not literal data.");
            } else {
                throw new PGPException("message is not a simple encrypted file - type unknown.");
            }

            if (pbe.isIntegrityProtected()) {
                if (!pbe.verify()) {
                    System.err.println("message failed integrity check");
                } else {
                    System.err.println("message integrity check passed");
                }
            } else {
                System.err.println("no message integrity check");
            }
        } catch (PGPException e) {
            System.err.println(e);
            if (e.getUnderlyingException() != null) {
                e.getUnderlyingException().printStackTrace();
            }
        }
    }

    private static void encryptFile(
            String outputFileName,
            String inputFileName,
            String encKeyFileName,
            boolean armor,
            boolean withIntegrityCheck)
            throws IOException, NoSuchProviderException, PGPException {
        OutputStream out = new BufferedOutputStream(new FileOutputStream(outputFileName));
        FileInputStream pubKey = new FileInputStream(encKeyFileName);
        PGPPublicKey encKey = readPublicKey(pubKey);
        encryptFile(out, inputFileName, encKey, armor, withIntegrityCheck);
        out.close();
    }

    private static void encryptFile(
            OutputStream out,
            String fileName,
            PGPPublicKey encKey,
            boolean armor,
            boolean withIntegrityCheck)
            throws IOException, NoSuchProviderException {
        if (armor) {
            out = new ArmoredOutputStream(out);
        }

        try {
            PGPEncryptedDataGenerator cPk = new PGPEncryptedDataGenerator(
                    new JcePGPDataEncryptorBuilder(PGPEncryptedData.CAST5).
                            setWithIntegrityPacket(withIntegrityCheck).
                            setSecureRandom(new SecureRandom()).
                            setProvider("BC"));

            cPk.addMethod(new JcePublicKeyKeyEncryptionMethodGenerator(encKey).setProvider("BC"));
            OutputStream cOut = cPk.open(out, new byte[1 << 16]);

            PGPCompressedDataGenerator comData = new PGPCompressedDataGenerator(
                    PGPCompressedData.ZIP);
            PGPUtil.writeFileToLiteralData(comData.open(cOut), PGPLiteralData.BINARY, new File(fileName), new byte[1 << 16]);
            comData.close();
            cOut.close();

            if (armor) {
                out.close();
            }
        } catch (PGPException e) {
            System.err.println(e);
            if (e.getUnderlyingException() != null) {
                e.getUnderlyingException().printStackTrace();
            }
        }
    }

    public static void writeMsgToDisk(String message) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("/tmp/msg.txt"));
        pw.write(message);
        pw.close();
    }

    public static String readAllFileContent(String file){
        try{
            return new String(Files.readAllBytes(Paths.get(file)), StandardCharsets.UTF_8);
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    private static String byteToBase64ToUtf8String(byte[] data){
        try{
            return new String(Base64.getEncoder().encode(data),"UTF-8");
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        PGPKeyRingGenerator krgen =
                GenerateRSAKey.
                        generateKeyRingGenerator("diego.pacheco.it@gmail.com", PASSPHRASE.toCharArray());

        PGPSecretKeyRing sec = krgen.generateSecretKeyRing();
        BufferedOutputStream secout = new BufferedOutputStream(new FileOutputStream("/tmp/sec.key"));
        sec.encode(secout);
        secout.close();
        System.out.println("Private Key: " + byteToBase64ToUtf8String(sec.getSecretKey().getEncoded()));

        PGPPublicKeyRing pub = krgen.generatePublicKeyRing();
        BufferedOutputStream pubout = new BufferedOutputStream(new FileOutputStream("/tmp/pub.key"));
        pub.encode(pubout);
        pubout.close();
        System.out.println("Public Key: " + byteToBase64ToUtf8String(pub.getPublicKey().getEncoded()));

        String originalMsg = "This is a test message with PGP";
        writeMsgToDisk(originalMsg);
        System.out.println("Original Message: " + originalMsg);

        encryptFile("/tmp/msg.asc","/tmp/msg.txt","/tmp/pub.key",true,true);
        System.out.println("Enc file: " + readAllFileContent("/tmp/msg.asc"));

        decryptFile("/tmp/msg.asc","/tmp/sec.key",PASSPHRASE.toCharArray(),"/tmp/msg.out");
        System.out.println("Dec file: " + readAllFileContent("/tmp/msg.out"));
        System.out.println("DONE");
    }

}
