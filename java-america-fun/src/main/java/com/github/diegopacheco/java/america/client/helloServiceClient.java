package com.github.diegopacheco.java.america.client;

import org.apache.thrift.TException;

import com.github.diegopacheco.java.america.HelloService;
import com.linecorp.armeria.client.Clients;

public class helloServiceClient {
	public static void main(String[] args) throws TException {
		HelloService.Iface helloService = Clients.newClient("tbinary+http://127.0.0.1:8080/hello",HelloService.Iface.class); // or AsyncIface.class
		String greeting = helloService.hello("Armerian World");
		assert greeting.equals("Hello, Armerian World!");
		System.out.println("America Client Thrift: " + greeting);
	}
}
