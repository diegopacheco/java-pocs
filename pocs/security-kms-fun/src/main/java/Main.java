import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.encryptionsdk.AwsCrypto;
import com.amazonaws.encryptionsdk.CryptoResult;
import com.amazonaws.encryptionsdk.kms.KmsMasterKey;
import com.amazonaws.encryptionsdk.kms.KmsMasterKeyProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import java.util.Base64;

public class Main {

    public static void main(String[] args) throws Exception {
        CryptoService cs = CryptoService.getInstance();
        String cipherText = cs.encrypt("Diego");
        System.out.println("Cipher text as Base64: " + cipherText);
        System.out.println("Decrypted: " + cs.decrypt(cipherText));
    }

}