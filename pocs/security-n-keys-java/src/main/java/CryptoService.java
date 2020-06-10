import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;

public class CryptoService {

    public Envelope enc(Key rootKey,byte[] data){
        try{
            Key kek = generateKey(256);
            Key dek = generateKey(128);

            byte[] encData = encrypt(dek,data);
            byte[] encKek  = encrypt(rootKey,kek.getEncoded());
            byte[] encDek  = encrypt(kek,dek.getEncoded());

            Envelope e = new Envelope();
            e.setEncData(encData);
            e.setEncKek(encKek);
            e.setEncDek(encDek);
            return e;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public byte[] dec(Key rootKey,Envelope envelope){
        Key kek =  importKey(decrypt(rootKey,envelope.getEncKek()));
        Key dek =  importKey(decrypt(kek,envelope.getEncDek()));
        byte[] data = decrypt(dek, envelope.getEncData());
        return data;
    }

    private byte[] encrypt(Key key,byte[] data){
        try{
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encData = cipher.doFinal(data);
            return encData;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    private byte[] decrypt(Key key,byte[] data){
        try{
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decData = cipher.doFinal(data);
            return decData;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public static Key generateKey(int keyBitSize){
        try{
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = new SecureRandom();
            keyGenerator.init(keyBitSize, secureRandom);
            SecretKey secretKey = keyGenerator.generateKey();
            return secretKey;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public static Key importKey(byte[] data){
        return new SecretKeySpec(data,"AES");
    }

}
