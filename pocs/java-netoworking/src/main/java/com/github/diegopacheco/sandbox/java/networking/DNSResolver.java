package com.github.diegopacheco.sandbox.java.networking;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DNSResolver {
	
	public static String resolve(String name){
		InetAddress address;
		try {
			address = InetAddress.getByName(name);
			return address.getHostAddress();
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static List<String> resolveList(String name){
		InetAddress[] address;
		try {
			address = InetAddress.getAllByName(name);
			return Arrays.stream(address).map( e -> e.getHostAddress() ).collect(Collectors.toList());
		} catch (UnknownHostException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void main(String[] args) {
		
		String ip = DNSResolver.resolve("gooogle.com");
		System.out.format("Google IP %s ",ip);
		
	}
	
}
