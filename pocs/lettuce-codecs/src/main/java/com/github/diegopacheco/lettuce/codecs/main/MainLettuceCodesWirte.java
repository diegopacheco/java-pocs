package com.github.diegopacheco.lettuce.codecs.main;

import com.lambdaworks.redis.RedisAsyncConnection;
import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisFuture;
import com.lambdaworks.redis.codec.ByteArrayCodec;
import com.lambdaworks.redis.codec.RedisCodec;
import static com.github.diegopacheco.lettuce.codecs.CodecUtils.*;

public class MainLettuceCodesWirte {
	public static void main(String[] args) throws Throwable {
		RedisCodec<byte[], byte[]> codec = new ByteArrayCodec();

		RedisClient client = RedisClient.create("redis://localhost:6379");
		RedisAsyncConnection<byte[], byte[]> connection = client.connectAsync(codec);
		
		connection.del(encodeStr("myhash1"),encodeStr("myhash2")).get();
		
		RedisFuture<Boolean> cmd = connection.hset(encodeStr("myhash1"), encodeStr("age"), encodeLong(3L));
		System.out.println("binary [myhash1] hset " + cmd.get());
		
		RedisFuture<Boolean> cmd2 = connection.hset(newEncodingMethod("myhash2"), newEncodingMethod("age"),newEncodingMethod(new String("3")));
		System.out.println("string [myhash2] hset " + cmd2.get());
	}
}
