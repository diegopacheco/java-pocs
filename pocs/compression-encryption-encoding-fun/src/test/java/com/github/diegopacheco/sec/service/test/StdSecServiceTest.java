package com.github.diegopacheco.sec.service.test;

import com.github.diegopacheco.sec.service.StdSecService;
import com.github.diegopacheco.sec.service.contract.SecService;
import org.junit.jupiter.api.Test;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

public class StdSecServiceTest {

    private SecService secService = new StdSecService();
    private String keyAlias = "developer";

    @Test
    public void allBytesTest(){
        byte[] plainText = "Okay, this is a string? right!".getBytes(StandardCharsets.UTF_8);
        byte[] result = secService.compressEncryptEncode(keyAlias,plainText);
        assertNotNull(result);
        System.out.println("Compressed/Encrypted/Encoded == " + result.length);

        byte[] rawStr = secService.decodeDecryptDecompress(keyAlias,result);
        assertNotNull(rawStr);
        System.out.println("Decoded/Decrypted/Uncompressed == " + rawStr.length);

        assertArrayEquals(plainText,rawStr);
    }

    @Test
    public void allStringTest(){
        String plainText = "Okay, this is a string? right!";
        String result = secService.compressEncryptEncode(keyAlias,plainText);
        assertNotNull(result);
        System.out.println("Compressed/Encrypted/Encoded == " + result + " - size: " + result.length());

        String rawStr = secService.decodeDecryptDecompress(keyAlias,result);
        assertNotNull(rawStr);
        System.out.println("Decoded/Decrypted/Uncompressed == " + rawStr + " - size: " + rawStr.length());
        assertEquals(plainText,rawStr);
    }

}
