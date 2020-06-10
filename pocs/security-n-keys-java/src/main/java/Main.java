import java.security.Key;
import java.util.Base64;

public class Main{
  public static void main(String args[]) throws Exception {
    Key rootKey = CryptoService.generateKey(256);
    System.out.println("Root Key: " + Base64.getEncoder().encodeToString(rootKey.getEncoded()));

    String plainText = "This is a message by Diego Pacheco!";
    System.out.println("Plain Text: " + plainText);

    CryptoService cs = new CryptoService();
    Envelope e = cs.enc(rootKey,plainText.getBytes("UTF-8"));
    System.out.println("Envelope: " + e);

    byte[] result = cs.dec(rootKey,e);
    System.out.println("Decrypted Data from Envelope: " + new String(result,"UTF-8"));
  }
}
