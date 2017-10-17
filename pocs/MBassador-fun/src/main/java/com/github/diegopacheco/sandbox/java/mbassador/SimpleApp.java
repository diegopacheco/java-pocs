package com.github.diegopacheco.sandbox.java.mbassador;

import java.io.File;

import net.engio.mbassy.bus.MBassador;

public class SimpleApp {
	
	public static void main(String[] args) {
		
		MBassador<File> bus = new MBassador<File>();
		SimpleFileListener listener = new SimpleFileListener();
		bus.subscribe (listener);
		bus.post(new File("/tmp/smallfile.csv")).now();
		bus.post(new File("/tmp/bigfile.csv")).asynchronously();
		
	}
	
}
