package com.github.diegopacheco.sec.service.contract;

public interface SecService {

    String compressEncryptEncode(String keyAlias,String plainText);
    byte[] compressEncryptEncode(String keyAlias,byte[] plainText);

    String decodeDecryptDecompress(String keyAlias,String plainText);
    byte[] decodeDecryptDecompress(String keyAlias,byte[] plainText);

}
