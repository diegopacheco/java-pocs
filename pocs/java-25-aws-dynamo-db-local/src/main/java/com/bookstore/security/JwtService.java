package com.bookstore.security;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.Instant;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtService {

    private static final String HEADER = "{\"alg\":\"HS256\",\"typ\":\"JWT\"}";
    private static final Base64.Encoder ENCODER = Base64.getUrlEncoder().withoutPadding();
    private static final Base64.Decoder DECODER = Base64.getUrlDecoder();

    private final byte[] secret;
    private final long expirationSeconds;

    public JwtService(@Value("${jwt.secret}") String secret,
                      @Value("${jwt.expiration-minutes}") long expirationMinutes) {
        this.secret = secret.getBytes(StandardCharsets.UTF_8);
        this.expirationSeconds = expirationMinutes * 60;
    }

    public long expirationSeconds() {
        return expirationSeconds;
    }

    public String issue(String subject) {
        long now = Instant.now().getEpochSecond();
        String header = encode(HEADER.getBytes(StandardCharsets.UTF_8));
        String payload = encode(("{\"sub\":\"" + subject + "\",\"iat\":" + now + ",\"exp\":" + (now + expirationSeconds) + "}")
                .getBytes(StandardCharsets.UTF_8));
        String signingInput = header + "." + payload;
        String signature = encode(hmac(signingInput));
        return signingInput + "." + signature;
    }

    public String verify(String token) {
        String[] parts = token.split("\\.");
        if (parts.length != 3) {
            throw new JwtException("malformed token");
        }
        String signingInput = parts[0] + "." + parts[1];
        String expected = encode(hmac(signingInput));
        if (!MessageDigest.isEqual(expected.getBytes(StandardCharsets.UTF_8), parts[2].getBytes(StandardCharsets.UTF_8))) {
            throw new JwtException("invalid signature");
        }
        String payload = new String(DECODER.decode(parts[1]), StandardCharsets.UTF_8);
        if (Instant.now().getEpochSecond() >= readLong(payload, "exp")) {
            throw new JwtException("token expired");
        }
        return readString(payload, "sub");
    }

    private byte[] hmac(String input) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret, "HmacSHA256"));
            return mac.doFinal(input.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            throw new JwtException("unable to sign token");
        }
    }

    private static String encode(byte[] bytes) {
        return ENCODER.encodeToString(bytes);
    }

    private static long readLong(String json, String field) {
        String marker = "\"" + field + "\":";
        int start = json.indexOf(marker) + marker.length();
        int end = start;
        while (end < json.length() && (Character.isDigit(json.charAt(end)))) {
            end++;
        }
        return Long.parseLong(json.substring(start, end));
    }

    private static String readString(String json, String field) {
        String marker = "\"" + field + "\":\"";
        int start = json.indexOf(marker) + marker.length();
        int end = json.indexOf('"', start);
        return json.substring(start, end);
    }
}
