package com.github.diegopacheco.docker.testing.redis;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.testcontainers.containers.GenericContainer;

import redis.clients.jedis.Jedis;

public class DockerRedistesting {

	static {
		System.setProperty("DOCKER_HOST", "tcp://192.168.99.100:2376");
		System.setProperty("DOCKER_CERT_PATH", "c:/users/diego/.docker/machine/machines/default");
		System.setProperty("DOCKER_TLS_VERIFY","0");
		System.setProperty("DOCKER_MACHINE_NAME","default");
	}

	private Jedis jedis = null;
	
	@Rule
	public GenericContainer redis = new GenericContainer("redis:3.0.6").withExposedPorts(6379);
	
	@Before
	public void setUp() throws Exception {
		 jedis = new Jedis(redis.getIpAddress(), redis.getMappedPort(6379));
	}

	@Test
	public void testRedisWithDocker() {
		Object result = jedis.set("k1", "docker-junit");
		System.out.println("Adding key: key " + result);
		
		result = jedis.get("k1");
		System.out.println("Getting k1 from Jedis: " + result);
	}

}
