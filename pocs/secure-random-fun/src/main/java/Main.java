import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class Main{
  public static void main(String args[]) throws NoSuchAlgorithmException {

    printRandomBytes(SecureRandom.getInstance("SHA1PRNG"));
    printRandomBytes(SecureRandom.getInstance("NativePRNG"));
    printRandomBytes(SecureRandom.getInstance("NativePRNGNonBlocking"));
    printRandomBytes(SecureRandom.getInstance("NativePRNGBlocking"));

    byte[] seed = BigInteger.valueOf(System.currentTimeMillis()).toByteArray();
    SecureRandom secureRandom = new SecureRandom(seed);
    System.out.println("Seed        : " + seed);
    System.out.println("Random      : " + secureRandom);
    byte[] rndBytes = new byte[16];
    secureRandom.nextBytes(rndBytes);
    System.out.println("Sample      : " + str(Base64.getEncoder().encode(rndBytes)));

  }

  private static String str(byte[] source){
    try{
      return new String(Base64.getEncoder().encode(source),"UTF-8");
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }

  private static void printRandomBytes(SecureRandom secureRandom){
    System.out.println("Random: " + secureRandom);
    byte[] rndBytes = new byte[16];
    secureRandom.nextBytes(rndBytes);
    System.out.println("Sample: " + str(Base64.getEncoder().encode(rndBytes)));
  }

}
