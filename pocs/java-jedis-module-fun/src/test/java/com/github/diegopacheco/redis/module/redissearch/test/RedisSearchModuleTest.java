package com.github.diegopacheco.redis.module.redissearch.test;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.github.diegopacheco.redis.module.redissearch.RedisSearchModule;

import redis.clients.jedis.exceptions.JedisDataException;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RedisSearchModuleTest {

	@Test
	public void test1Create(){
		RedisSearchModule rsm = new RedisSearchModule();
		String result = rsm.FT_CREATE(new String[]{"myIdx","title", "5.0", "body", "1.0", "url", "1.0"});
		Assert.assertNotNull(result);
		System.out.println("FT_CREATE: " + result);
	}
	
	@Test
	public void test2Add(){
		try{
			RedisSearchModule rsm = new RedisSearchModule();
			String result = rsm.FT_ADD(new String[]{"myIdx", "doc1", "1.0","fields", "title", "hello world","body", "lorem ipsum", "url", "http://redis.io"});
			Assert.assertNotNull(result);
			System.out.println("FT_ADD: " + result);
		}catch(JedisDataException jde){
			System.out.println("FT_ADD: " + jde.getMessage());	
		}
	}
	
	@Test
	public void test3Sugadd(){
		RedisSearchModule rsm = new RedisSearchModule();
		Long result = rsm.FT_SUGADD(new String[]{"autocomplete", "hello world", "100"});
		Assert.assertNotNull(result);
		System.out.println("FT_SUGADD: " + result);
	}
	
	@Test
	public void test4Sugget(){
		RedisSearchModule rsm = new RedisSearchModule();
		List<String> result = rsm.FT_SUGGET(new String[]{"autocomplete", "he"});
		Assert.assertNotNull(result);
		System.out.println("FT_SUGGET: " + result);
	}
	
	@Test
	public void test5Search(){
		RedisSearchModule rsm = new RedisSearchModule();
		List<Map<String,Object>> result = rsm.FT_SEARCH(new String[]{"myIdx", "hello world", "LIMIT", "0", "10"});
		Assert.assertNotNull(result);
		System.out.println("FT_SEARCH: " + result);
	}
	
	@Ignore
	@Test
	public void test6Drop(){
		RedisSearchModule rsm = new RedisSearchModule();
		String result = rsm.FT_DROP(new String[]{"myIdx"});
		Assert.assertNotNull(result);
		System.out.println("FT_DROP: " + result);
	}
	
}
