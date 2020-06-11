import java.security.Key;
import java.util.Base64;

public class Main{
  public static void main(String args[]) throws Exception {
    bench("this is a secret"); //16
    bench("this is a secretthis is a secret"); // 32
    bench("this is a secretthis is a secretthis is a secretthis is a secret"); // 64
    bench("this is a secretthis is a secretthis is a secretthis is a secretthis is a secretthis is a secretthis is a secretthis is a secret"); // 128
  }

  private static void bench(String plainText){
    try{
      System.out.println("******** Plain Text Size: " + plainText.length());
      Key rootKey = CryptoService.generateKey(256);
      System.out.println("Root Key: " + Base64.getEncoder().encodeToString(rootKey.getEncoded()));
      System.out.println("Plain Text: " + plainText);

      CryptoService cs = new CryptoService();
      Long start = System.currentTimeMillis();
      Envelope e = cs.enc(rootKey,plainText.getBytes("UTF-8"));
      Long end   = System.currentTimeMillis();
      System.out.println("Envelope: " + e);
      System.out.println("Envelope Encryption time: " + (end-start) + " ms");

      start = System.currentTimeMillis();
      byte[] result = cs.dec(rootKey,e);
      end   = System.currentTimeMillis();
      System.out.println("Decrypted Data from Envelope: " + new String(result,"UTF-8"));
      System.out.println("Envelope Decryption time: " + (end-start) + " ms");
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }

}
