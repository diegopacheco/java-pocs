package com.github.diegopacheco.lettuce.custom.redis.modules.datecmd;

import io.lettuce.core.ReadFrom;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.codec.Utf8StringCodec;
import io.lettuce.core.dynamic.RedisCommandFactory;
import io.lettuce.core.masterslave.MasterSlave;
import io.lettuce.core.masterslave.StatefulRedisMasterSlaveConnection;

public class TrullyCustomCmdMain {

	public static void main(String[] args) throws Throwable {
		
		RedisClient redisClient = RedisClient.create();
		
		StatefulRedisMasterSlaveConnection<String, String> connection = MasterSlave.connect(redisClient, new Utf8StringCodec(),RedisURI.create("redis://localhost"));
		connection.setReadFrom(ReadFrom.MASTER_PREFERRED);
		
		RedisCommandFactory cmdFactory = new RedisCommandFactory(connection);
		DateCommands dateCmd = cmdFactory.getCommands(DateCommands.class);

		Object aResult = dateCmd.dpDate("s");
		System.out.println("Real Custom Command[dp.DATE]: " + aResult);
		
		connection.close();
		redisClient.shutdown();

	}

}