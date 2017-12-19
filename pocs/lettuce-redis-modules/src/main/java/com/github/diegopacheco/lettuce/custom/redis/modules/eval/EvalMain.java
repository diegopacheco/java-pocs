package com.github.diegopacheco.lettuce.custom.redis.modules.eval;

import io.lettuce.core.ReadFrom;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.RedisURI;
import io.lettuce.core.ScriptOutputType;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.codec.Utf8StringCodec;
import io.lettuce.core.masterslave.MasterSlave;
import io.lettuce.core.masterslave.StatefulRedisMasterSlaveConnection;

public class EvalMain {
	public static void main(String[] args) throws Throwable{
		
RedisClient redisClient = RedisClient.create();
		
		StatefulRedisMasterSlaveConnection<String, String> connection = MasterSlave.connect(redisClient, new Utf8StringCodec(),RedisURI.create("redis://localhost"));
		connection.setReadFrom(ReadFrom.MASTER_PREFERRED);
		
		RedisAsyncCommands<String, String> ayncCmds = connection.async();
		
		RedisFuture<String> result = ayncCmds.eval(" return redis.call('dp.DATE') ",ScriptOutputType.VALUE);
		 
		System.out.println("Real Custom Command[dp.DATE]: " + result.get());
		
		connection.close();
		redisClient.shutdown();
		
	}
}
