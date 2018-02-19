package com.github.diegopacheco.lettuce.codecs.main;

import static com.github.diegopacheco.lettuce.codecs.CodecUtils.*;

import com.lambdaworks.redis.RedisAsyncConnection;
import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisFuture;
import com.lambdaworks.redis.codec.ByteArrayCodec;
import com.lambdaworks.redis.codec.RedisCodec;

public class MainLettuceCodes {

	public static void main(String[] args) throws Throwable {

		RedisCodec<byte[], byte[]> codec = new ByteArrayCodec();

		RedisClient client = RedisClient.create("redis://localhost:6379");
		RedisAsyncConnection<byte[], byte[]> connection = client.connectAsync(codec);

		// works
		RedisFuture<Boolean> cmd = connection.hset(newEncodingMethod("myhash2"), newEncodingMethod("age"),
		    newEncodingMethod(new String("33")));

		// dont work
		cmd = connection.hset(encodeStr("myhash1"), encodeStr("age"), encodeLong(33L));
		byte[] result = connection.hget(encodeStr("myhash1"), encodeStr("age")).get();
		System.out.print("Result get byteArray from redis: " + result + " bytes: ");
		printByteArray(result);
		System.out.println("Result get long  from redis: " + decodeLong(result));

		// another try - dont work
		// RedisFuture<Boolean> cmd = connection.hset(encodeStr("myhash1"),
		// encodeStr("age"), longToBytes(33L));

		System.out.println("was inserted: " + cmd.get());

	}
}
