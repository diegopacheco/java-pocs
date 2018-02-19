package com.github.diegopacheco.lettuce.codecs;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public class CodecUtils {
	
	public static String decodeStr(ByteBuffer bytes) {
		return StandardCharsets.UTF_8.decode(bytes).toString();
	}

	public static byte[] encodeStr(String key) {
		return key.getBytes(StandardCharsets.UTF_8);
	}

	public static byte[] encodeLong(long l) {
		return ByteBuffer.wrap(new byte[8]).putLong(l).array();
	}

	public static long decodeLong(byte[] data) {
		return ByteBuffer.wrap(data).getLong();
	}

	public static byte[] newEncodingMethod(String str) {
		return str.getBytes();
	}

	public static byte[] longToBytes(long l) {
		byte[] result = new byte[8];
		for (int i = 7; i >= 0; i--) {
			result[i] = (byte) (l & 0xFF);
			l >>= 8;
		}
		return result;
	}
	public static long bytesToLong(byte[] b) {
    long result = 0;
    for (int i = 0; i < 8; i++) {
        result <<= 8;
        result |= (b[i] & 0xFF);
    }
    return result;
	}
	
	public static void printByteArray(byte[] byteArray) {
		for(int i=0; i<byteArray.length;i++) {
			System.out.print(byteArray[i] + " ");
		}; System.out.println("");
	}
	
}
