import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.encryptionsdk.AwsCrypto;
import com.amazonaws.encryptionsdk.CryptoResult;
import com.amazonaws.encryptionsdk.kms.KmsMasterKey;
import com.amazonaws.encryptionsdk.kms.KmsMasterKeyProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.kms.AWSKMSClientBuilder;

import java.util.Base64;

public class CryptoService {

    // ./create-key.sh
    private static String keyArn = System.getenv().getOrDefault("KMS_KEY","arn:aws:kms:us-east-1:000000000000:key/0c4c4b39-9992-4df7-bdd5-75359b78980b").toString();
    private static final AwsCrypto crypto = new AwsCrypto();
    private static KmsMasterKeyProvider prov;

    private static CryptoService INSTANCE;
    public static synchronized CryptoService getInstance(){
        if (null==INSTANCE){
            INSTANCE=new CryptoService();
        }
        return INSTANCE;
    }

    private CryptoService(){
        if (null==prov){
            System.out.println("KEY ARN: " + keyArn);
            prov = KmsMasterKeyProvider.builder()
                    .withCustomClientFactory(
                            (regionName ->
                                    AWSKMSClientBuilder.standard().withEndpointConfiguration(
                                            new AwsClientBuilder.EndpointConfiguration("http://localhost:4566", Regions.US_EAST_1.getName())
                                    ).build()
                            )
                    )
                    .withDefaultRegion(Regions.US_EAST_1.getName())
                    .withKeysForEncryption(keyArn).build();
        }
    }

    public String encrypt(String str){
        final CryptoResult<byte[], KmsMasterKey> result = crypto.encryptData(prov,str.getBytes());
        return Base64.getEncoder().encodeToString(result.getResult());
    }

    public String decrypt(String cypherText){
        try{
            byte[] result = Base64.getDecoder().decode(cypherText);
            final CryptoResult<byte[], KmsMasterKey> decryptResult = crypto.decryptData(prov,result);
            return new String(decryptResult.getResult(),"UTF-8");
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
