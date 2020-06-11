import java.security.Key;
import java.util.Base64;

public class Main{
  public static void main(String args[]) throws Exception {
    Key rootKey = CryptoService.generateKey(256);

    bench(rootKey,generatePlainText(16));
    bench(rootKey,generatePlainText(32));
    bench(rootKey,generatePlainText(64));
    bench(rootKey,generatePlainText(128));
    bench(rootKey,generatePlainText(256));
    bench(rootKey,generatePlainText(512));
    bench(rootKey,generatePlainText(1024));
    bench(rootKey,generatePlainText(2048));
    bench(rootKey,generatePlainText(4096));
  }

  private static String generatePlainText(int size){
      String base = "this is a secret";
      StringBuilder plainText = new StringBuilder();
      for(int i=0;i<(size/16);i++){
        plainText.append(base);
      }
      return plainText.toString();
  }

  private static void bench(Key rootKey,String plainText){
    try{
      System.out.println("******** Plain Text Size: " + plainText.length());
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
