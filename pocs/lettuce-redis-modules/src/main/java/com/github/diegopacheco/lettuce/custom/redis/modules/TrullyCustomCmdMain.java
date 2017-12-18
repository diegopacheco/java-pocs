package com.github.diegopacheco.lettuce.custom.redis.modules;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.dynamic.Commands;
import io.lettuce.core.dynamic.RedisCommandFactory;
import io.lettuce.core.dynamic.annotation.Command;

public class TrullyCustomCmdMain {

	public interface DateCommands extends Commands {
		@Command("DP.DATE")
		RedisFuture<String> dpDate();
	}

	public static void main(String[] args) throws Throwable {

		RedisClient redisClient = RedisClient.create("redis://127.0.0.1:6379");
		StatefulRedisConnection<String, String> connection = redisClient.connect();

		RedisCommandFactory cmdFactory = new RedisCommandFactory(connection);
		DateCommands dateCmd = cmdFactory.getCommands(DateCommands.class);

		RedisFuture<String> aResult = dateCmd.dpDate();
		System.out.println("Real Custom Command[dp.DATE]: " + aResult.get());

		connection.close();
		redisClient.shutdown();

	}

}