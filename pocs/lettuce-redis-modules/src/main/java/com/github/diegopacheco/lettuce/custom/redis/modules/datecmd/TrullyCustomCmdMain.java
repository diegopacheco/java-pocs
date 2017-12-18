package com.github.diegopacheco.lettuce.custom.redis.modules.datecmd;

import java.util.Arrays;

import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.codec.ByteArrayCodec;
import io.lettuce.core.codec.StringCodec;
import io.lettuce.core.dynamic.RedisCommandFactory;
import io.lettuce.core.protocol.LettuceCharsets;

public class TrullyCustomCmdMain {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) throws Throwable {

		RedisClient redisClient = RedisClient.create("redis://localhost:6379/0");
		StatefulRedisConnection connection = redisClient.connect();

		RedisCommandFactory cmdFactory = new RedisCommandFactory(connection, Arrays.asList(new ByteArrayCodec(), new StringCodec(LettuceCharsets.UTF8)));
		DateCommands dateCmd = cmdFactory.getCommands(DateCommands.class);

		//RedisFuture<String> aResult = dateCmd.dpDate();
		Object aResult = dateCmd.dpDate();
		System.out.println("Real Custom Command[dp.DATE]: " + aResult);

		connection.close();
		redisClient.shutdown();

	}

}