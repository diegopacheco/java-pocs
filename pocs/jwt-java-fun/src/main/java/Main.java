import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.DefaultJwtSignatureValidator;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

import static io.jsonwebtoken.SignatureAlgorithm.HS256;

public class Main {

    private static final String SECRET_KEY = "SECRET_KEY_123456";

    public static String decodeJWTToken(String token, String secretKey) {
        try{
            Base64.Decoder decoder = Base64.getDecoder();
            String[] chunks = token.split("\\.");

            String header = new String(decoder.decode(chunks[0]));
            String payload = new String(decoder.decode(chunks[1]));

            String tokenWithoutSignature = chunks[0] + "." + chunks[1];
            String signature = chunks[2];

            SignatureAlgorithm sa = HS256;
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes(), sa.getJcaName());

            DefaultJwtSignatureValidator validator = new DefaultJwtSignatureValidator(sa, secretKeySpec);
            if (!validator.isValid(tokenWithoutSignature, signature)) {
                throw new Exception("Could not verify JWT token integrity!");
            }
            return header + " " + payload;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public static String encodeJWT(String id, String issuer, String subject, long ttlMillis) {

        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder().setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .setIssuer(issuer)
                .signWith(signatureAlgorithm, signingKey);

        //if it has been specified, let's add the expiration
        if (ttlMillis > 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }

    public static Claims decodeJWT(String jwt) {
        //This line will throw an exception if it is not a signed JWS (as expected)
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
                .parseClaimsJws(jwt).getBody();
        return claims;
    }

    public static void main(String args[]) {

        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9." +
                "eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkJhZWxkdW5nIFVzZXIiLCJpYXQiOjE1MTYyMzkwMjJ9." +
                "qH7Zj_m3kY69kxhaQXTa-ivIpytKXXjZc1ZSmapZnGE";
        String key = "MySecretKey";
        String result = decodeJWTToken(token,key);
        System.out.println(result);

        System.out.println("......");

        String newToken = encodeJWT("1","diegopacheco","header_version=v2",500000);
        System.out.println(newToken);
        System.out.println(decodeJWT(newToken));
    }
}
