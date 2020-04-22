import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.encryptionsdk.AwsCrypto;
import com.amazonaws.encryptionsdk.CryptoResult;
import com.amazonaws.encryptionsdk.kms.KmsMasterKey;
import com.amazonaws.encryptionsdk.kms.KmsMasterKeyProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import java.util.Base64;

public class Main {

  // ./create-key.sh
  private static String keyArn = System.getenv().getOrDefault("KMS_KEY","arn:aws:kms:us-east-1:000000000000:key/0c4c4b39-9992-4df7-bdd5-75359b78980b").toString();
  private static String data = "Diego Pacheco";

  public static void main(String[] args) throws Exception {

    System.out.println("KEY ARN: " + keyArn);

    final KmsMasterKeyProvider prov = KmsMasterKeyProvider.builder()
          .withCustomClientFactory(
                  (regionName ->
                          AWSKMSClientBuilder.standard().withEndpointConfiguration(
                              new AwsClientBuilder.EndpointConfiguration("http://localhost:4566",Regions.US_EAST_1.getName())
                          ).build()
                  )
          )
            .withDefaultRegion(Regions.US_EAST_1.getName())
            .withKeysForEncryption(keyArn).build();

    final AwsCrypto crypto = new AwsCrypto();

    final CryptoResult<byte[], KmsMasterKey> result = crypto.encryptData(prov,data.getBytes());
    System.out.println("Ciphertext as Base64: " + Base64.getEncoder().encodeToString(result.getResult()));

    final CryptoResult<byte[], KmsMasterKey> decryptResult = crypto.decryptData(prov,result.getResult());
    System.out.println("Decrypted: " + new String(decryptResult.getResult(),"UTF-8"));
  }
}