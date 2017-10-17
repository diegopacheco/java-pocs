package com.github.diegopacheco.redis.module.pocs;

import java.util.List;

import redis.clients.jedis.Connection;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Module;
import redis.clients.jedis.commands.ProtocolCommand;
import redis.clients.util.SafeEncoder;

public class JedisModuleMain {
	
	static enum SearchModuleCommand implements ProtocolCommand {
	    SEARCH("FT.SEARCH");

	    private final byte[] raw;

	    SearchModuleCommand(String alt) {
	      raw = SafeEncoder.encode(alt);
	    }

	    @Override
	    public byte[] getRaw() {
	      return raw;
	    }
	  }

	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Jedis jedis = new Jedis("127.0.0.1");
		
		try{
			String res = jedis.moduleLoad("/home/diego/home2/diego/github/misc/RediSearch/src/module.so");
			System.out.println(res);
		}catch(Exception e){
			System.out.println("Could not load the module. Maybe was loaded already! ");
		}
		
		List<Module> modules = jedis.moduleList();
		for(Module m: modules){
			System.out.println(m.getName() + "-" + m.getVersion() + "-" + m.getClass());
		}
		
		String[] cmdArgs = {"myIdx", "hello world"};
		
		Connection c = jedis.getClient().sendCommand(SearchModuleCommand.SEARCH,cmdArgs);
		
		List<byte[]> out = c.getBinaryMultiBulkReply();
		for(Object bs : out){
			if ("class java.lang.Long".equals(bs.getClass().toString())){
				System.out.println("Result count: " + new Long(bs.toString()));
			}
			if ("class [B".equals(bs.getClass().toString())){
				System.out.println("Doc: " + new String((byte[])bs) );
			}
			if ("class java.util.ArrayList".equals(bs.getClass().toString())){
				List<Object> objs = (List)bs;
				for(Object o: objs){
					System.out.println( new String((byte[])o) );
				}
			}
		}
		
		/*
		Object o2 = c.getOne();
		System.out.println(o2);
		*/
		
	}
}
