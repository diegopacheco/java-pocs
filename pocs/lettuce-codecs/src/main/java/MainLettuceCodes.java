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
  
	public static void main(String[] args) throws Throwable{
		
		RedisCodec<byte[],byte[]> codec = new ByteArrayCodec();
		
		RedisClient client = RedisClient.create("redis://localhost:8102");
		RedisAsyncConnection<byte[], byte[]> connection = client.connectAsync(codec);
		
		RedisFuture<Boolean> cmd = connection.hset(encodeStr("myhash1"), encodeStr("age"),encodeLong(33L));
		System.out.println("result: " + cmd.get());
		
	}
}
