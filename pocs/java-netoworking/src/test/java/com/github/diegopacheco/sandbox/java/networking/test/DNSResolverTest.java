package com.github.diegopacheco.sandbox.java.networking.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.github.diegopacheco.sandbox.java.networking.DNSResolver;

public class DNSResolverTest {
	
	@Test
	public void testResolve(){
		System.out.println("Resolve... ");
		String ip = DNSResolver.resolve("gooogle.com");
		System.out.format("Google IP %s ",ip).println();;
		Assert.assertNotNull(ip);
	}
	
	@Test
	public void testResolveList(){
		System.out.println("ResolveList... ");
		List<String> ips = DNSResolver.resolveList("google.com");
		for(String ip : ips)
			System.out.format("Google IP %s ",ip).println();;
		Assert.assertNotNull(ips);
	}
	
}
