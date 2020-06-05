import javax.crypto.SecretKey;
import java.security.KeyPair;

public class Main{
  public static void main(String args[]){
    SecretKey keyGen    = SecurityService.generateKey();
    SecretKey keyImport = SecurityService.importKey(new byte[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
    KeyPair keyRSA      = SecurityService.generateAsymmetricKey();
    workWithKey(keyGen);
    workWithKey(keyImport);
    workWithKeyRSA(keyRSA);
  }

  private static void workWithKey(SecretKey key) {
    System.out.println("****** Using key: " + key + " @ " + key.getAlgorithm());
    String cipher = SecurityService.enc("This is a secret msg by Diego.",key);
    String text   = SecurityService.dec(cipher,key);
    System.out.println("Cipher: " + cipher);
    System.out.println("Text  : " + text);
  }

  private static void workWithKeyRSA(KeyPair key) {
    System.out.println("****** Using key: " + key + " @ " + key.getPublic());
    String cipher = SecurityService.encRSA("This is a secret msg by Diego.",key);
    String text   = SecurityService.decRSA(cipher,key);
    System.out.println("Cipher: " + cipher);
    System.out.println("Text  : " + text);
  }

}
