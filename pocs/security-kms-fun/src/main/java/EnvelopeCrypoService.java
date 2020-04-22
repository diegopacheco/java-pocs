import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.encryptionsdk.AwsCrypto;
import com.amazonaws.encryptionsdk.CryptoResult;
import com.amazonaws.encryptionsdk.kms.KmsMasterKey;
import com.amazonaws.encryptionsdk.kms.KmsMasterKeyProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import com.amazonaws.services.kms.model.DataKeySpec;
import com.amazonaws.services.kms.model.DecryptRequest;
import com.amazonaws.services.kms.model.GenerateDataKeyRequest;
import com.amazonaws.services.kms.model.GenerateDataKeyResult;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.ByteBuffer;
import java.util.Base64;

public class EnvelopeCrypoService {

    // ./create-key.sh
    private static String masterKey = System.getenv().getOrDefault("KMS_KEY","arn:aws:kms:us-east-1:000000000000:key/0c4c4b39-9992-4df7-bdd5-75359b78980b").toString();
    private static final AwsCrypto crypto = new AwsCrypto();
    private static KmsMasterKeyProvider prov;
    private static AWSKMS client;

    private static EnvelopeCrypoService INSTANCE;
    public static synchronized EnvelopeCrypoService getInstance(){
        if (null==INSTANCE){
            INSTANCE=new EnvelopeCrypoService();
        }
        return INSTANCE;
    }

    private EnvelopeCrypoService(){
        if (null==prov){
            System.out.println("MASTER KEY ARN: " + masterKey);

            this.client = AWSKMSClientBuilder.standard().withEndpointConfiguration(
                    new AwsClientBuilder.
                            EndpointConfiguration("http://localhost:4566", Regions.US_EAST_1.getName())
            ).build();

            this.prov = KmsMasterKeyProvider.builder()
                    .withCustomClientFactory( (regionName -> client ))
                    .withDefaultRegion(Regions.US_EAST_1.getName())
                    .withKeysForEncryption(masterKey).build();
        }
    }

    public EnvelopeEncryptedMessage encrypt(String str){
        try{
            GenerateDataKeyResult dataKey = generateDataKey();
            SecretKeySpec key = new SecretKeySpec(dataKey.getPlaintext().array(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] enc = cipher.doFinal(str.getBytes());
            String cipherText = Base64.getEncoder().encodeToString(enc);

            EnvelopeEncryptedMessage envelope = new EnvelopeEncryptedMessage();
            envelope.setEncryptedKey(dataKey.getCiphertextBlob().array());
            envelope.setCiphertext(cipherText);
            return envelope;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public String decrypt(EnvelopeEncryptedMessage envelope){
        try{
            ByteBuffer encryptedKey = ByteBuffer.wrap(envelope.getEncryptedKey());
            DecryptRequest decryptRequest = new DecryptRequest().withCiphertextBlob(encryptedKey);
            ByteBuffer plainTextKey = client.decrypt(decryptRequest).getPlaintext();
            SecretKeySpec keyspec = new SecretKeySpec(plainTextKey.array(), "AES");

            byte[] decodeBase64src = Base64.getDecoder().decode(envelope.getCiphertext());
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, keyspec);
            return new String(cipher.doFinal(decodeBase64src));

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    private GenerateDataKeyResult generateDataKey() {
        GenerateDataKeyRequest generateDataKeyRequest = new GenerateDataKeyRequest();
        generateDataKeyRequest.setKeyId(masterKey);
        generateDataKeyRequest.setKeySpec(DataKeySpec.AES_256);
        GenerateDataKeyResult dataKeyResult = client.generateDataKey(generateDataKeyRequest);
        return dataKeyResult;
    }

}
