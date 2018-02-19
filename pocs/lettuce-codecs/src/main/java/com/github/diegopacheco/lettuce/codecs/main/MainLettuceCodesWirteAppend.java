package com.github.diegopacheco.lettuce.codecs.main;

import static com.github.diegopacheco.lettuce.codecs.CodecUtils.decodeLong;
import static com.github.diegopacheco.lettuce.codecs.CodecUtils.encodeLong;
import static com.github.diegopacheco.lettuce.codecs.CodecUtils.encodeStr;
import static com.github.diegopacheco.lettuce.codecs.CodecUtils.newEncodingMethod;
import static com.github.diegopacheco.lettuce.codecs.CodecUtils.printByteArray;

import java.nio.ByteBuffer;
import java.util.List;

import com.github.diegopacheco.lettuce.codecs.CodecUtils;
import com.lambdaworks.redis.RedisAsyncConnection;
import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisFuture;
import com.lambdaworks.redis.ScriptOutputType;
import com.lambdaworks.redis.codec.ByteArrayCodec;
import com.lambdaworks.redis.codec.RedisCodec;

public class MainLettuceCodesWirteAppend {
	public static void main(String[] args) throws Throwable {
		
		RedisCodec<byte[], byte[]> codec = new ByteArrayCodec();

		RedisClient client = RedisClient.create("redis://localhost:6379");
		RedisAsyncConnection<byte[], byte[]> connection = client.connectAsync(codec);
		
		RedisFuture<Boolean> cmd = connection.hset(encodeStr("myhash1"), encodeStr("age"), encodeLong(3L));
		System.out.println("binary [myhash1] hset " + cmd.get());
		
		RedisFuture<Boolean> cmd2 = connection.hset(newEncodingMethod("myhash2"), newEncodingMethod("age"),newEncodingMethod(new String("3")));
		System.out.println("string [myhash2] hset " + cmd2.get());
		
		//RedisFuture<List<String>> cmdAppend = connection.eval("return redis.call('HP.HAPPEND', KEYS[1],'age','" + newEncodingMethod("3") + "')", ScriptOutputType.MULTI, encodeStr(new String("myhash1")));
		//System.out.println("string [myhash1] HP.APPEND " + cmdAppend.get());
		
		RedisFuture<List<String>> cmdAppend2 = connection.eval("return redis.call('HP.HAPPEND', KEYS[1],'age','3')", ScriptOutputType.MULTI, encodeStr(new String("myhash2")));
		System.out.println("string [myhash2] HP.APPEND " + cmdAppend2.get());
		
		byte[] result = connection.hget(encodeStr("myhash1"), encodeStr("age")).get();
		System.out.print("binary [myhash1] hget => " + result + " bytes: ");
		printByteArray(result);
		System.out.println("binary [myhash1] hget => " + decodeLong(result));
		
		result = connection.hget(encodeStr("myhash2"), encodeStr("age")).get();
		System.out.print("string [myhash2] hget => " + result + " bytes: ");
		printByteArray(result);
		System.out.println("string [myhash2] hget => " + CodecUtils.decodeStr(ByteBuffer.wrap(result)));
		
	}
}
