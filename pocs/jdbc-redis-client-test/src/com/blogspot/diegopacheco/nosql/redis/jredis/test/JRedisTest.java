package com.blogspot.diegopacheco.nosql.redis.jredis.test;

import org.jredis.JRedis;
import org.jredis.ri.alphazero.JRedisClient;
import static org.jredis.ri.alphazero.support.DefaultCodec.*;

public class JRedisTest {
	public static void main(String[] args) throws Throwable {
		
		JRedis	jredis = new JRedisClient("localhost", 6379, "jredis", 0);
		jredis.ping();		
		jredis.set("diegoPachecoJRedisKey", "Pacheco Value JRedis");
		System.out.println( toStr( jredis.get("diegoPachecoJRedisKey") ) );
		
	}
}
