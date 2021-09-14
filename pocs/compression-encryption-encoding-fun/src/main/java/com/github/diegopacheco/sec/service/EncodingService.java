package com.github.diegopacheco.sec.service;

import java.util.Base64;

class EncodingService {

    public byte[] encode(byte[] cleanText){
        return Base64.getEncoder().encode(cleanText);
    }

    public byte[] decode(byte[] cipherText){
        return Base64.getDecoder().decode(cipherText);
    }

}
