package com.github.diegopacheco.sandbox.java.redis;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.lambdaworks.redis.RedisAsyncConnection;
import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisFuture;

public class LettuceMain {
	public static void main(String[] args) throws Throwable {
		
		RedisClient client = RedisClient.create("redis://localhost:6379");
		RedisAsyncConnection<String, String> connection = client.connectAsync();
		
		RedisFuture<String> set = connection.set("K1", "k1-lettuce-works-" + new Date().toString());
		RedisFuture<String> get = connection.get("K1");
		
		System.out.println("Set: " + set.get(3000, TimeUnit.SECONDS));
		System.out.println("Get: " + get.get(3000, TimeUnit.SECONDS));
		
		System.out.println("Set-Error: " + set.getError());
		System.out.println("Get-Error: " + get.getError());
		
	}
}
