package com.github.diegopacheco.sandbox.java.proxy;

import java.io.IOException;
import java.net.ServerSocket;

public class ProxyServer {

	public static void main(String[] args) throws IOException {

		ServerSocket serverSocket = null;
		boolean listening = true;

		try {
			serverSocket = new ServerSocket(8888);
			System.out.println("Started on: " + 8888);
		} catch (IOException e) {
			System.err.println("Could not listen on port: " + 8888);
			System.exit(-1);
		}

		while (listening) {
			new ProxyThread(serverSocket.accept()).start();
		}
		serverSocket.close();
	}

}
