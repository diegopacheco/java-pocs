import javax.crypto.SecretKey;

public class Main{
  public static void main(String args[]){
    SecretKey keyGen    = SecurityService.generateKey();
    SecretKey keyImport = SecurityService.importKey(new byte[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0});
    workWithKey(keyGen);
    workWithKey(keyImport);
  }

  private static void workWithKey(SecretKey key) {
    System.out.println("****** Using key: " + key + " @ " + key.getAlgorithm());
    String cipher = SecurityService.enc("This is a secret msg by Diego.",key);
    String text   = SecurityService.dec(cipher,key);
    System.out.println("Cipher: " + cipher);
    System.out.println("Text  : " + text);
  }

}
