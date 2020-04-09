import java.math.BigInteger;
import java.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Main{
 
  private static class HMAC {

    public static byte[] hmac256(String secretKey,String message){
      try{
        return hmac256(secretKey.getBytes("UTF-8"), message.getBytes("UTF-8"));
      }catch(Exception e){
        throw new RuntimeException("Failed to generate HMACSHA256 encrypt",e);
      }
    }

    public static byte[] hmac256(byte[] secretKey,byte[] message){
      byte[] hmac256 = null;
      try{
        Mac mac = Mac.getInstance("HmacSHA256");
        SecretKeySpec sks = new SecretKeySpec(secretKey, "HmacSHA256");
        mac.init(sks);
        hmac256 = mac.doFinal(message);
        return hmac256;
      }catch(Exception e){
        throw new RuntimeException("Failed to generate HMACSHA256 encrypt ");
      } 
    }
  }

  public static void main(String args[]){
    byte[] hmacSha256 = HMAC.hmac256("secreT1_", "Hello world from Java!");
    System.out.println(String.format("Hex: %032x", new BigInteger(1, hmacSha256)));
    
    String base64HmacSha256 = Base64.getEncoder().encodeToString(hmacSha256);
    System.out.println("Base64: " + base64HmacSha256);
  }
}
