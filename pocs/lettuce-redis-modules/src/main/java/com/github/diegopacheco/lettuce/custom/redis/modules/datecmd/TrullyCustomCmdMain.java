package com.github.diegopacheco.lettuce.custom.redis.modules.datecmd;

import io.lettuce.core.ReadFrom;
import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.async.RedisAsyncCommands;
import io.lettuce.core.codec.RedisCodec;
import io.lettuce.core.codec.StringCodec;
import io.lettuce.core.codec.Utf8StringCodec;
import io.lettuce.core.masterslave.MasterSlave;
import io.lettuce.core.masterslave.StatefulRedisMasterSlaveConnection;
import io.lettuce.core.output.StatusOutput;
import io.lettuce.core.protocol.CommandArgs;
import io.lettuce.core.protocol.LettuceCharsets;
import io.lettuce.core.protocol.ProtocolKeyword;

public class TrullyCustomCmdMain {
	
	public enum DP implements ProtocolKeyword{
		DATE;

	    public final byte[] bytes;

	    private DP() {
	        bytes = "dp.DATE".getBytes(LettuceCharsets.ASCII);
	    }
	    @Override
	    public byte[] getBytes() {
	        return bytes;
	    }
	}
	
	public static void main(String[] args) throws Throwable {
		
		RedisClient redisClient = RedisClient.create();
		
		StatefulRedisMasterSlaveConnection<String, String> connection = MasterSlave.connect(redisClient, new Utf8StringCodec(),RedisURI.create("redis://localhost"));
		connection.setReadFrom(ReadFrom.MASTER_PREFERRED);
		
		RedisAsyncCommands<String, String> ayncCmds = connection.async();
		RedisCodec<String, String> codec = StringCodec.UTF8;
		
		RedisFuture<String> result = ayncCmds.dispatch(DP.DATE, 
														new StatusOutput<>(codec),
														new CommandArgs<>(codec).add(""));
		 
		System.out.println("Real Custom Command[dp.DATE]: " + result.get());
		
		connection.close();
		redisClient.shutdown();

	}

}