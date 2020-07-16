import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class Main{
  public static void main(String args[]) throws Exception{
    String originalString = "123456789";
    System.out.println("Original String: " + originalString);
    System.out.println("Generated Hash : " + bytesToHex(hash(originalString)));
    System.out.println("Generated Hash : " + bytesToHex(hash(originalString)));
  }

  private static byte[] hash(String originalString) throws Exception{
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    byte[] encodedhash = digest.digest(originalString.getBytes(StandardCharsets.UTF_8));
    return encodedhash;
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
