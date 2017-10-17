package com.github.diegopacheco.sandbox.java.jwt;

import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;

public class Application {
	
	private static final String SECRET = "mysecret";
	
    private static JWTSigner signer = new JWTSigner(SECRET);
    private static JWTVerifier verifier = new JWTVerifier(SECRET, "audience");
    private static HashMap<String, Object> claims = new HashMap<String, Object>();
	
    private static void loadClaims(){
    	claims.put("name", "Diego Pacheco");
    	claims.put("lang", "Java8");
    	claims.put("twitter", "@diego_pacheco");
    }
    
	public static void main (String [] args) throws Throwable {
        try {
        	loadClaims();
        	String token = signer.sign(claims);
        	System.out.println("JWT Token: " + token);
        	
            Map<String,Object> decodedPayload = verifier.verify(token);
            
            // Get custom fields from decoded Payload
            System.out.println("JWT decoded Payload: " + decodedPayload);
            System.out.println("Name: " + decodedPayload.get("name"));
            System.out.println("Lang: " + decodedPayload.get("lang"));
            System.out.println("Twitter: " + decodedPayload.get("twitter"));
            
        } catch (SignatureException signatureException) {
            System.err.println("Invalid signature!");
        } catch (IllegalStateException illegalStateException) {
            System.err.println("Invalid Token! " + illegalStateException);
        }
    }
}
