package com.github.diegopacheco.sandbox.java.sockets;

import java.io.IOException;

// http://www.geeksforgeeks.org/introducing-threads-socket-programming-java/
public class MainApp {
	
	public static void run(Runnable r){
		new Thread(r).start();
	}
	
	public static void main(final String[] args) throws Throwable {
		
		run(new Runnable() {
			@Override
			public void run() {
				try {
					Server.main(args);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		run(new Runnable() {
			@Override
			public void run() {
				try {
					Client.main(args);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}
