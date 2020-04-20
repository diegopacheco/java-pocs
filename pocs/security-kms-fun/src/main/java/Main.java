import java.util.Collections;
import java.util.Map;

import com.amazonaws.encryptionsdk.AwsCrypto;
import com.amazonaws.encryptionsdk.CryptoResult;
import com.amazonaws.encryptionsdk.kms.KmsMasterKey;
import com.amazonaws.encryptionsdk.kms.KmsMasterKeyProvider;

public class Main {

  private static String keyArn = "arn:aws:kms:us-east-1:000000000000:key/3c6c6917-6f79-4951-a6ad-4e20fc67df26";
  private static String data = "Diego Pacheco";

  public static void main(String[] args) throws Exception {

    final AwsCrypto crypto = new AwsCrypto();

    final KmsMasterKeyProvider prov = KmsMasterKeyProvider.builder()
                                      .withKeysForEncryption(keyArn).build();

    // Encrypt the data
    //
    // Most encrypted data should have an associated encryption context
    // to protect integrity. This sample uses placeholder values.
    //
    // For more information see:
    // blogs.aws.amazon.com/security/post/Tx2LZ6WBJJANTNW/How-to-Protect-the-Integrity-of-Your-Encrypted-Data-by-Using-AWS-Key-Management
    final Map<String, String> context = Collections.singletonMap("Example", "String");

    final String ciphertext = crypto.encryptString(prov, data, context).getResult();
    System.out.println("Ciphertext: " + ciphertext);

    // Decrypt the data
    final CryptoResult<String, KmsMasterKey> decryptResult = crypto.decryptString(prov, ciphertext);

    // Before returning the plaintext, verify that the customer master key that
    // was used in the encryption operation was the one supplied to the master key
    // provider.
    if (!decryptResult.getMasterKeyIds().get(0).equals(keyArn)) {
      throw new IllegalStateException("Wrong key ID!");
    }

    // Also, verify that the encryption context in the result contains the
    // encryption context supplied to the encryptString method. Because the
    // SDK can add values to the encryption context, don't require that
    // the entire context matches.
    for (final Map.Entry<String, String> e : context.entrySet()) {
      if (!e.getValue().equals(decryptResult.getEncryptionContext().get(e.getKey()))) {
        throw new IllegalStateException("Wrong Encryption Context!");
      }
    }

    // Now we can return the plaintext data
    System.out.println("Decrypted: " + decryptResult.getResult());
  }
}