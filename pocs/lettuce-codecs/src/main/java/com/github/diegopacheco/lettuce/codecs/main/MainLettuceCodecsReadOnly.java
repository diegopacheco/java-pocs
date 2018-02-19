package com.github.diegopacheco.lettuce.codecs.main;

import static com.github.diegopacheco.lettuce.codecs.CodecUtils.decodeLong;
import static com.github.diegopacheco.lettuce.codecs.CodecUtils.encodeStr;
import static com.github.diegopacheco.lettuce.codecs.CodecUtils.printByteArray;

import java.nio.ByteBuffer;

import com.github.diegopacheco.lettuce.codecs.CodecUtils;
import com.lambdaworks.redis.RedisAsyncConnection;
import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.codec.ByteArrayCodec;
import com.lambdaworks.redis.codec.RedisCodec;

public class MainLettuceCodecsReadOnly {
	public static void main(String[] args) throws Throwable {
			
		RedisCodec<byte[], byte[]> codec = new ByteArrayCodec();

		RedisClient client = RedisClient.create("redis://localhost:6379");
		RedisAsyncConnection<byte[], byte[]> connection = client.connectAsync(codec);

		byte[] result = connection.hget(encodeStr("myhash1"), encodeStr("age")).get();
		System.out.print("[myhash1] => Result get byteArray from redis: " + result + " bytes: ");
		printByteArray(result);
		System.out.println("[myhash1] => Result get long  from redis: " + decodeLong(result));
		
		result = connection.hget(encodeStr("myhash2"), encodeStr("age")).get();
		System.out.print("[myhash2] => Result get byteArray from redis: " + result + " bytes: ");
		printByteArray(result);
		System.out.println("[myhash2] => Result get long  from redis: " + CodecUtils.decodeStr(ByteBuffer.wrap(result)));
		
	}
}
