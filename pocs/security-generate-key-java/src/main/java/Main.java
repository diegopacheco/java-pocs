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
    Long start = System.currentTimeMillis();
    String cipher = SecurityService.enc("This is a secret msg by Diego.",key);
    String text   = SecurityService.dec(cipher,key);
    Long end = System.currentTimeMillis();
    System.out.println("Cipher: " + cipher);
    System.out.println("Text  : " + text);
    System.out.println("Enc/Dec in: " + (end-start) + " ms");
  }

  private static void workWithKeyRSA(KeyPair key) {
    System.out.println("****** Using key: " + key + " @ " + key.getPublic());
    Long start = System.currentTimeMillis();
    String cipher = SecurityService.encRSA("This is a secret msg by Diego.",key);
    String text   = SecurityService.decRSA(cipher,key);
    Long end = System.currentTimeMillis();
    System.out.println("Cipher: " + cipher);
    System.out.println("Text  : " + text);
    System.out.println("Enc/Dec in: " + (end-start) + " ms");
  }

}
