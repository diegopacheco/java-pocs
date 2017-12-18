package com.github.diegopacheco.lettuce.custom.redis.modules;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisStringAsyncCommands;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.dynamic.Commands;
import io.lettuce.core.dynamic.domain.Timeout;

public class LettuceMain {

	public interface AsyncGetCommands extends Commands {
		RedisFuture<String> get(String key, Timeout timeout);
	}

	public static void main(String[] args) throws Throwable {

		RedisClient redisClient = RedisClient.create("redis://localhost:6379/0");
		StatefulRedisConnection<String, String> connection = redisClient.connect();
		RedisCommands<String, String> syncCommands = connection.sync();
		RedisStringAsyncCommands<String, String> async = connection.async();

		syncCommands.set("key", "Hello, Redis!");
		System.out.println(syncCommands.get("key"));

		RedisFuture<String> get = async.get("key");
		System.out.println("Async get: " + async.get("key").get());

		connection.close();
		redisClient.shutdown();

	}
}
