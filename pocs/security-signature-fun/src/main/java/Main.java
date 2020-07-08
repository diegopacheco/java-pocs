import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.Signature;

public class Main{
  public static void main(String args[]){
    try{
      KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("DSA");
      keyPairGen.initialize(2048);
      KeyPair pair = keyPairGen.generateKeyPair();

      PrivateKey privKey = pair.getPrivate();
      Signature sign = Signature.getInstance("SHA256withDSA");
      sign.initSign(privKey);

      byte[] bytes = "Hello how are you".getBytes();
      sign.update(bytes);
      byte[] signature = sign.sign();
      System.out.println("Digital signature for given text: "+new String(signature, "UTF8"));

      sign.initVerify(pair.getPublic());
      sign.update(bytes);
      boolean bool = sign.verify(signature);
      System.out.println("Signature verification, is okay: " + bool);

    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
}
