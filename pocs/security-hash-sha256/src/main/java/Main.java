import com.google.common.hash.Hashing;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.util.encoders.Hex;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;

public class Main{

  private static byte[] salt = getSalt();

  public static void main(String args[]) throws Exception{
    String originalString = "123456789";
    System.out.println("Original String        : " + originalString);

    System.out.println("=== SALT Method 1 ");
    System.out.println("Generated Hash         : " + bytesToHex(hash(originalString)));
    System.out.println("Generated Hash         : " + bytesToHex(hash(originalString)));
    System.out.println("Generated Hash (BC)    : " + hashBC(originalString));
    System.out.println("Generated Hash (BC)    : " + hashBC(originalString));

    System.out.println("=== SALT Method 2 ");
    System.out.println("Generated Hash (Guava) : " + hashGuava(originalString));
    System.out.println("Generated Hash (Guava) : " + hashGuava(originalString));
    System.out.println("Generated Hash (CD)    : " + hashCD(originalString));
    System.out.println("Generated Hash (CD)    : " + hashCD(originalString));
  }

  private static byte[] getSalt() {
    try{
      SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
      byte[] salt = new byte[16];
      sr.nextBytes(salt);
      return salt;
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }

  private static String hashGuava(String message){
    try{
      String sha256hex = Hashing.sha256()
              .hashString(message + new String(salt,"UTf-8"), StandardCharsets.UTF_8)
              .toString();
      return sha256hex;
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }

  private static String hashCD(String originalString){
    try{
      String sha256hex = DigestUtils.sha256Hex(originalString + new String(salt,"UTf-8"));
      return sha256hex;
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }

  private static String hashBC(String originalString) throws Exception{
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    digest.update(salt);
    byte[] hash = digest.digest(
            originalString.getBytes(StandardCharsets.UTF_8));
    String sha256hex = new String(Hex.encode(hash));
    return sha256hex;
  }

  private static byte[] hash(String originalString){
    try{
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      digest.update(salt);
      byte[] encodedhash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
      return encodedhash;
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }

  private static String bytesToHex(byte[] hash) {
    StringBuffer hexString = new StringBuffer();
    for (int i = 0; i < hash.length; i++) {
      String hex = Integer.toHexString(0xff & hash[i]);
      if(hex.length() == 1) hexString.append('0');
      hexString.append(hex);
    }
    return hexString.toString();
  }

}
