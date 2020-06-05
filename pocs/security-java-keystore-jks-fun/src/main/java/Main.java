import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.KeyStore;
import java.util.Base64;

/**
 * Run with: -Dkeystore.type=pkcs12
 */
public class Main{

  private static final char[] pwdArray = "password".toCharArray();

  public static void main(String args[]){
    try {
      KeyStore ks = KeyStore.getInstance("pkcs12");
      ks.load(null, pwdArray);
      writeKeyStore(ks);
      ks = readKeyStore();
      ks = storeSymmetricKey(ks);
      Key dbKey = ks.getKey("db-encryption-secret", pwdArray);
      System.out.println("DB Key from JKS: " + Base64.getEncoder().encodeToString(dbKey.getEncoded()) + " @ " + dbKey.getAlgorithm() );
      writeKeyStore(ks);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

  }

  public static void writeKeyStore(KeyStore ks){
    try{
      try (FileOutputStream fos = new FileOutputStream("ks.jks")) {
        ks.store(fos,pwdArray);
      }
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }

  public static KeyStore readKeyStore(){
    try {
      KeyStore ks = KeyStore.getInstance("JKS");
      ks.load(new FileInputStream("ks.jks"), pwdArray);
      return ks;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  public static KeyStore storeSymmetricKey(KeyStore ks){
    try {
      SecretKey key = KeyGenerator.getInstance("AES").generateKey();
      KeyStore.SecretKeyEntry secret = new KeyStore.SecretKeyEntry(key);
      KeyStore.ProtectionParameter password = new KeyStore.PasswordProtection(pwdArray);
      ks.setEntry("db-encryption-secret", secret, password);
      return ks;
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }

}
