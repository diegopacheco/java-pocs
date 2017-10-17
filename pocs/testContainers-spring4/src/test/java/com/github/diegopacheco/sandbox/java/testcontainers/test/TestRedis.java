package com.github.diegopacheco.sandbox.java.testcontainers.test;

import org.junit.Assert;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.testcontainers.containers.GenericContainer;

import com.github.diegopacheco.sandbox.java.testcontainers.AppConfig;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@SuppressWarnings("rawtypes")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class TestRedis {
	
	@ClassRule
	public static GenericContainer redis = new GenericContainer("redis:3.0.4").withExposedPorts(6379);
	
	@Test
	public void testRedis(){
		
		String redisUrl = redis.getContainerIpAddress();

		JedisPool pool = new JedisPool(new JedisPoolConfig(), redisUrl);
		try (Jedis jedis = pool.getResource()) {
			 jedis.set("foo", "bar");
			 String foobar = jedis.get("foo");
			 Assert.assertNotNull(foobar);
			 System.out.println(foobar);
		}
		pool.close();
		pool.destroy();
		
	}
	
}
