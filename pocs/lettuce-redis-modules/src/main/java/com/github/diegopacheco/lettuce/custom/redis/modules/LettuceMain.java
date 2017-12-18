package com.github.diegopacheco.lettuce.custom.redis.modules;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisStringAsyncCommands;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.dynamic.Commands;
import io.lettuce.core.dynamic.RedisCommandFactory;
import io.lettuce.core.dynamic.annotation.Command;

public class LettuceMain {

	public interface AsyncGetCommands extends Commands {
		
		@Command("GET")
		RedisFuture<String> get(String key);
		
	}

	public static void main(String[] args) throws Throwable {

		RedisClient redisClient = RedisClient.create("redis://localhost:6379/0");
		StatefulRedisConnection<String, String> connection = redisClient.connect();
		RedisCommands<String, String> syncCommands = connection.sync();
		RedisStringAsyncCommands<String, String> async = connection.async();

		syncCommands.set("key", "Hello, Redis!");
		System.out.println(syncCommands.get("key"));

		RedisFuture<String> get = async.get("key");
		System.out.println("Async get: " + get.get());
		
		RedisCommandFactory cmdFactory = new RedisCommandFactory(connection);
		AsyncGetCommands agCmd = cmdFactory.getCommands(AsyncGetCommands.class);
		RedisFuture<String>  aResult = agCmd.get("key");
		System.out.println("Custom Command: " + aResult.get());
		
		connection.close();
		redisClient.shutdown();

	}
}
