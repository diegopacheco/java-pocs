package com.github.diegopacheco.java27.pem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.security.KeyPair;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PemCodecTest {

    private static KeyPair keyPair;

    @BeforeAll
    static void generate() throws Exception {
        keyPair = PemCodec.generateKeyPair();
    }

    @Test
    void aPublicKeySurvivesARoundTripThroughPemText() {
        String pem = PemCodec.encode(keyPair.getPublic());
        assertEquals("PUBLIC KEY", PemCodec.typeOf(pem));
        assertEquals(keyPair.getPublic(), PemCodec.decodePublicKey(pem));
    }

    @Test
    void theEncodedTextIsTheStandardRfc7468Format() {
        String pem = PemCodec.encode(keyPair.getPublic());
        assertTrue(pem.startsWith("-----BEGIN PUBLIC KEY-----"));
        assertTrue(pem.strip().endsWith("-----END PUBLIC KEY-----"));
    }

    @Test
    void aPrivateKeyCanBeEncryptedOnTheWayOutAndDecryptedOnTheWayBack() {
        char[] password = "correct horse".toCharArray();
        String pem = PemCodec.encrypt(keyPair.getPrivate(), password);
        assertEquals("ENCRYPTED PRIVATE KEY", PemCodec.typeOf(pem));
        assertEquals(keyPair.getPrivate(), PemCodec.decrypt(pem, password));
    }

    @Test
    void theWrongPasswordCannotRecoverThePrivateKey() {
        String pem = PemCodec.encrypt(keyPair.getPrivate(), "correct horse".toCharArray());
        assertThrows(RuntimeException.class, () -> PemCodec.decrypt(pem, "wrong horse".toCharArray()));
    }

    @Test
    void encryptedTextNeverLeaksThePlainKeyMaterial() {
        String plain = PemCodec.encode(keyPair.getPublic());
        String encrypted = PemCodec.encrypt(keyPair.getPrivate(), "pwd".toCharArray());
        assertNotEquals(plain, encrypted);
    }
}
