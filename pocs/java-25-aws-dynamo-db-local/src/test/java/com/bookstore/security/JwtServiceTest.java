package com.bookstore.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class JwtServiceTest {

    private static final String SECRET = "unit-test-secret-key-for-hs256-signing-abcdefghijklmnop";

    @Test
    void issuesTokenThatVerifiesBackToSubject() {
        JwtService service = new JwtService(SECRET, 60);
        String token = service.issue("admin");
        assertEquals("admin", service.verify(token), "verify must return the subject the token was issued for");
    }

    @Test
    void rejectsTamperedSignature() {
        JwtService service = new JwtService(SECRET, 60);
        String token = service.issue("admin");
        String tampered = token.substring(0, token.length() - 2) + (token.endsWith("aa") ? "bb" : "aa");
        assertThrows(JwtException.class, () -> service.verify(tampered),
                "a token whose signature was altered must be rejected so it cannot be forged");
    }

    @Test
    void rejectsTokenSignedWithDifferentSecret() {
        String token = new JwtService("another-secret-key-that-is-long-enough-for-hs256-000", 60).issue("admin");
        assertThrows(JwtException.class, () -> new JwtService(SECRET, 60).verify(token),
                "a token signed with a different key must not validate against our key");
    }

    @Test
    void rejectsExpiredToken() {
        JwtService service = new JwtService(SECRET, -1);
        String token = service.issue("admin");
        assertThrows(JwtException.class, () -> service.verify(token),
                "an expired token must be rejected to bound the session lifetime");
    }

    @Test
    void rejectsMalformedToken() {
        JwtService service = new JwtService(SECRET, 60);
        assertThrows(JwtException.class, () -> service.verify("not-a-jwt"));
    }
}
