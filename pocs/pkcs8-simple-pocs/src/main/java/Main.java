import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemObjectGenerator;
import org.bouncycastle.util.io.pem.PemWriter;

import java.io.StringWriter;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class Main{
  public static void main(String args[]){
    generatePKCS8_PublicPrivateKeyPairs();
    System.out.println("DONE");
  }

  public static void generatePKCS8_PublicPrivateKeyPairs(){
    try{
      KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
      keyPairGen.initialize(2048);

      KeyPair pair = keyPairGen.generateKeyPair();
      PrivateKey privateKey = pair.getPrivate();
      PublicKey publicKey   = pair.getPublic();

      System.out.println("Private Key:\n" + new String(Base64.getEncoder().encode(privateKey.getEncoded()), "UTF-8"));
      System.out.println("Public Key:\n" + new String(Base64.getEncoder().encode(publicKey.getEncoded()), "UTF-8"));
      System.out.println("Private key Format " + privateKey.getFormat());
      System.out.println("Public key Format " + privateKey.getFormat());

      writeKey(pair);

    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }

  private static void writeKey(KeyPair pair){
    try{
      StringWriter sw = new StringWriter();
      try (PemWriter writer = new PemWriter(sw);) {
        writer.writeObject((PemObjectGenerator)new PemObject("PRIVATE KEY", pair.getPrivate().getEncoded()));
        writer.writeObject((PemObjectGenerator)new PemObject("PUBLIC KEY", pair.getPublic().getEncoded()));
      }
      String pemFormat = sw.toString();
      System.out.println(pemFormat);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }

}
