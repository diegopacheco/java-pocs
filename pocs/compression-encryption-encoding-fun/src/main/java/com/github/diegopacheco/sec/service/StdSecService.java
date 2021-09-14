package com.github.diegopacheco.sec.service;

import com.github.diegopacheco.sec.service.contract.SecService;
import java.nio.charset.StandardCharsets;

public class StdSecService implements SecService {

    private KeyManager keyManager = new KeyManager();
    private CompressionService compression = new CompressionService();
    private EncodingService encoding = new EncodingService();
    private SymmetricEncryptionService encryption = new SymmetricEncryptionService();

    @Override
    public String compressEncryptEncode(String keyAlias, String plainText) {
        byte[] result = compressEncryptEncode(keyAlias,plainText.getBytes(StandardCharsets.UTF_8));
        String strResult = new String(result,StandardCharsets.UTF_8);
        return strResult;
    }

    @Override
    public byte[] compressEncryptEncode(String keyAlias,byte[] plainText) {
        validate(keyAlias,plainText);
        try{
            KeyManager.KeyIVPair keyIVPair = keyManager.getKey(keyAlias);
            byte[] compressed = compression.compress(plainText);
            byte[] encrypted = encryption.encrypt(keyIVPair,compressed);
            byte[] encoded = encoding.encode(encrypted);
            return encoded;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public String decodeDecryptDecompress(String keyAlias, String cipherText) {
        byte[] result = decodeDecryptDecompress(keyAlias,cipherText.getBytes(StandardCharsets.UTF_8));
        String strResult = new String(result,StandardCharsets.UTF_8);
        return strResult;
    }

    @Override
    public byte[] decodeDecryptDecompress(String keyAlias, byte[] cipherText) {
        validate(keyAlias,cipherText);
        try{
            KeyManager.KeyIVPair keyIVPair = keyManager.getKey(keyAlias);
            byte[] decoded = encoding.decode(cipherText);
            byte[] decrypted = encryption.decrypt(keyIVPair,decoded);
            byte[] uncompressed = compression.decompress(decrypted);
            return uncompressed;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    private void validate(String keyAlias, byte[] bytes) {
        if (null==keyAlias || "".equals(keyAlias)){
            throw new IllegalArgumentException("keyAlias cannot be empty nor null!");
        }
        if (null==bytes || bytes.length<=0){
            throw new IllegalArgumentException("byte[] with the data cannot be null or zero length");
        }
    }

}
