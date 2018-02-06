import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import com.lambdaworks.redis.RedisAsyncConnection;
import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisFuture;
import com.lambdaworks.redis.codec.ByteArrayCodec;
import com.lambdaworks.redis.codec.RedisCodec;

public class MainLettuceCodes {

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

	public static void main(String[] args) throws Throwable {

		RedisCodec<byte[], byte[]> codec = new ByteArrayCodec();

		RedisClient client = RedisClient.create("redis://localhost:8102");
		RedisAsyncConnection<byte[], byte[]> connection = client.connectAsync(codec);

		// works
		RedisFuture<Boolean> cmd = connection.hset(newEncodingMethod("myhash1"),newEncodingMethod("age"),newEncodingMethod(new String("33")));

		// dont work
		//RedisFuture<Boolean> cmd = connection.hset(encodeStr("myhash1"), encodeStr("age"), encodeLong(33L));
		
		// another try - dont work
		//RedisFuture<Boolean> cmd = connection.hset(encodeStr("myhash1"), encodeStr("age"), longToBytes(33L));

		System.out.println("result: " + cmd.get());

	}
}
