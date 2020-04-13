import java.security.MessageDigest;

import org.apache.commons.codec.digest.DigestUtils;

public class Main{
  public static void main(String args[]){
      try{
        String password = "ILoveJava";
             
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();

        System.out.println("MD5 result: " + digest.toString());

        String md5Hex = DigestUtils.md5Hex(password).toUpperCase();
        System.out.println("MD5 HEX: " + md5Hex);

      }catch(Exception e){
        throw new RuntimeException(e);
      }
  }
}
