import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.File;

public class Main{
  public static void main(String args[]){
    fileEncDec();
  }

  private static void fileEncDec(){
    try{
      String originalContent = "This is my original message, in plain text, ok?";
      SecretKey secretKey = KeyGenerator.getInstance("AES").generateKey();

      String basePath = new File(".").getCanonicalPath() + "/";

      FileEncrypterDecrypter fileEncrypterDecrypter = new FileEncrypterDecrypter(secretKey, "AES/CBC/PKCS5Padding");
      fileEncrypterDecrypter.encrypt(originalContent, basePath + "baz.enc");

      String decryptedContent = fileEncrypterDecrypter.decrypt(basePath + "baz.enc");
      assert(decryptedContent.equals(originalContent));

    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
}
