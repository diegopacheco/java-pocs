import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.encryptionsdk.AwsCrypto;
import com.amazonaws.encryptionsdk.CryptoResult;
import com.amazonaws.encryptionsdk.MasterKey;
import com.amazonaws.encryptionsdk.kms.KmsMasterKey;
import com.amazonaws.encryptionsdk.kms.KmsMasterKeyProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.kms.AWSKMSClientBuilder;

import java.util.Base64;


public class Main {

  // ./create-key.sh
  private static String keyArn = "arn:aws:kms:us-east-1:000000000000:key/d2baffab-0150-4604-aec1-8714602f551c";
  private static String data = "Diego Pacheco";

  public static void main(String[] args) throws Exception {

    final AwsCrypto crypto = new AwsCrypto();

    final KmsMasterKeyProvider prov = KmsMasterKeyProvider.builder()
          .withCustomClientFactory(
                  (regionName ->
                          AWSKMSClientBuilder.standard().withEndpointConfiguration(
                              new AwsClientBuilder.EndpointConfiguration("http://localhost:4566",Regions.US_EAST_1.getName())
                          ).build()
                  )
          ).withKeysForEncryption(keyArn).build();

    final CryptoResult<byte[], KmsMasterKey> result = crypto.encryptData(prov,data.getBytes());
    System.out.println("Ciphertext as Base64: " + Base64.getEncoder().encodeToString(result.getResult()));

    final CryptoResult<byte[], KmsMasterKey> decryptResult = crypto.decryptData(prov,result.getResult());
    System.out.println("Decrypted: " + new String(decryptResult.getResult(),"UTF-8"));
  }
}