package com.github.diegopacheco.redis.module.pocs;

import redis.clients.jedis.Jedis;

public class SimpleJedis {
	public static void main(String[] args) {
		Jedis jedis = new Jedis("127.0.0.1");
		jedis.set("foo", "bar");
		String value = jedis.get("foo");
		System.out.println(value);
	}
}
