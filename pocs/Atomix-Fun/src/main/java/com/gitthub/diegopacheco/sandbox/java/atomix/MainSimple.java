package com.gitthub.diegopacheco.sandbox.java.atomix;

import io.atomix.AtomixReplica;
import io.atomix.catalyst.transport.Address;
import io.atomix.collections.DistributedMap;
import io.atomix.variables.DistributedValue;

public class MainSimple {
	public static void main(String[] args) throws Throwable {

		AtomixReplica atomixReplica = AtomixReplica.builder(new Address("localhost", 8700)).build().bootstrap().get();

		System.out.println(atomixReplica);

		DistributedValue<Object> value = atomixReplica.getValue("value").join();
		value.set("Hello world! VALUE").join();

		value.get().thenAccept(result -> {
			System.out.println("The value is " + result);
		});

		DistributedMap<String, String> map = atomixReplica.<String, String>getMap("map").join();
		map.put("bar", "Hello world! MAP").thenAccept(result2 -> {
			System.out.println("The value is " + result2);
		});
		System.out.println(map.get("bar"));

	}
}
