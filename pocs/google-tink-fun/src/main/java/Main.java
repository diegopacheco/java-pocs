import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AeadKeyTemplates;
import com.google.crypto.tink.config.TinkConfig;

public class Main {
  public static void main(String args[]) throws Exception {

      TinkConfig.register();

      // 1. Generate the key material.
      KeysetHandle keysetHandle = KeysetHandle.generateNew(
        AeadKeyTemplates.AES128_GCM);
  
      // 2. Get the primitive.
      Aead aead = keysetHandle.getPrimitive(Aead.class);
  
      // 3. Use the primitive.
      byte[] ciphertext = aead.encrypt("this is a message".getBytes(), "1234".getBytes());
      System.out.println("Cipher text: " + ciphertext.toString());

  }
}
