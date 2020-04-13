import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Main{

  private static String plainText = "This is a plain text which will be encrypted by " +
                                    " Java AES 256 Algo in CBC mode!";

  public static void main(String args[]){
    try{
      KeyGenerator kg = KeyGenerator.getInstance("AES");
      kg.init(256); 
      
      SecretKey key = kg.generateKey();

      byte[] IV = new byte[16];
      SecureRandom random = new SecureRandom();
      random.nextBytes(IV);

      System.out.println("Original Plain Text: " + plainText);
      byte[] cipherText = encrypt(plainText.getBytes(),key,IV);
      System.out.println("Encrypted Text : " + Base64.getEncoder().encodeToString(cipherText));
        
      String decryptedText = decrypt(cipherText,key, IV);
      System.out.println("DeCrypted Text : " + decryptedText);

    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }

  private static byte[] encrypt(byte[] plaintext,SecretKey key,byte[] IV){
    try{
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      SecretKeySpec spec = new SecretKeySpec(key.getEncoded(), "AES");
      IvParameterSpec ivSpec = new IvParameterSpec(IV);
      cipher.init(Cipher.ENCRYPT_MODE,spec,ivSpec);
      byte[] cipherText = cipher.doFinal(plaintext);
      return cipherText;
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }

  public static String decrypt(byte[] cipherText,SecretKey key,byte[] IV){
    try{
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      SecretKeySpec spec = new SecretKeySpec(key.getEncoded(), "AES");
      IvParameterSpec ivSpec = new IvParameterSpec(IV);
      cipher.init(Cipher.DECRYPT_MODE, spec,ivSpec);
      byte[] decryptedText = cipher.doFinal(cipherText);
      return new String(decryptedText);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }  

}
