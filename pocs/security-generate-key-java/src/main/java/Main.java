import javax.crypto.SecretKey;

public class Main{
  public static void main(String args[]){
    SecretKey key = SecurityService.generateKey();
    String cipher = SecurityService.enc("This is a secret msg by Diego.",key);
    String text   = SecurityService.dec(cipher,key);
    System.out.println("Key   : " + key);
    System.out.println("Cipher: " + cipher);
    System.out.println("Text  : " + text);
  }
}
