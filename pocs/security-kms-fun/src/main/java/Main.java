import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.encryptionsdk.AwsCrypto;
import com.amazonaws.encryptionsdk.CryptoResult;
import com.amazonaws.encryptionsdk.kms.KmsMasterKey;
import com.amazonaws.encryptionsdk.kms.KmsMasterKeyProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.apigateway.model.EndpointConfiguration;

import java.util.Collections;
import java.util.Map;


public class Main {

  private static BasicAWSCredentials awsCreds = new BasicAWSCredentials("0", "0");

  // ./create-key.sh
  private static String keyArn = "arn:aws:kms:us-east-1:000000000000:key/d2baffab-0150-4604-aec1-8714602f551c";
  private static String data = "Diego Pacheco";

  public static void main(String[] args) throws Exception {

    final AwsCrypto crypto = new AwsCrypto();

    final KmsMasterKeyProvider prov = KmsMasterKeyProvider.builder()
                                      .withDefaultRegion(Regions.US_EAST_1.getName())
                                      .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                                      .withKeysForEncryption(keyArn).build();

    final String ciphertext = new String(crypto.encryptData(prov,data.getBytes()).getResult());
    System.out.println("Ciphertext: " + ciphertext);

    final CryptoResult<byte[], KmsMasterKey> decryptResult = crypto.decryptData(prov,ciphertext.getBytes());
    System.out.println("Decrypted: " + decryptResult.getResult());
  }
}