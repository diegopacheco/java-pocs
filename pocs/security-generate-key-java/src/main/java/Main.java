import javax.crypto.SecretKey;
import java.security.KeyPair;
import java.util.Base64;

public class Main{
  public static void main(String args[]){
    SecretKey keyGen    = SecurityService.generateKey();
    SecretKey keyImport = SecurityService.importKey(new byte[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
    KeyPair keyRSA      = SecurityService.generateAsymmetricKey();
    workWithKey(keyGen);
    workWithKey(keyImport);
    workWithKeyRSA(keyRSA);

    System.out.println("\n\nHashing/Message Digest a password with SHA-512 : (admin) == " +
            SecurityService.generateHash("admin") );
  }

  private static void workWithKey(SecretKey key) {
    System.out.println("****** Using key: " + Base64.getEncoder().encodeToString(key.getEncoded()) + " @ " + key.getAlgorithm());
    Long start = System.currentTimeMillis();
    String cipher = SecurityService.enc("This is a secret msg by Diego.",key);
    String text   = SecurityService.dec(cipher,key);
    Long end = System.currentTimeMillis();
    System.out.println("Cipher: " + cipher);
    System.out.println("Text  : " + text);
    System.out.println("Enc/Dec in: " + (end-start) + " ms");
  }

  private static void workWithKeyRSA(KeyPair key) {
    System.out.println("****** Using key Public : " + Base64.getEncoder().encodeToString(key.getPublic().getEncoded()) + " @ " + key.getPublic());
    System.out.println("****** Using key Private : " + Base64.getEncoder().encodeToString(key.getPrivate().getEncoded()) + " @ " + key.getPublic());
    Long start = System.currentTimeMillis();
    String cipher = SecurityService.encRSA("This is a secret msg by Diego.",key);
    String text   = SecurityService.decRSA(cipher,key);
    Long end = System.currentTimeMillis();
    System.out.println("Cipher: " + cipher);
    System.out.println("Text  : " + text);
    System.out.println("Enc/Dec in: " + (end-start) + " ms");
  }

}
