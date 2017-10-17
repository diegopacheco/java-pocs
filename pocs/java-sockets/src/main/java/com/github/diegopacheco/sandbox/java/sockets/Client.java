package com.github.diegopacheco.sandbox.java.sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws IOException {
		try {
			Scanner scn = new Scanner(System.in);
			
			System.out.println("Client trying to connect on 127.0.0.1:5056...");
			
			InetAddress ip = InetAddress.getByName("localhost");
			Socket s = new Socket(ip, 5056);

			DataInputStream dis = new DataInputStream(s.getInputStream());
			DataOutputStream dos = new DataOutputStream(s.getOutputStream());
			
			while (true) {
				System.out.println(dis.readUTF());
				String tosend = scn.nextLine();
				dos.writeUTF(tosend);

				if (tosend.equals("Exit")) {
					System.out.println("Closing this connection : " + s);
					s.close();
					System.out.println("Connection closed");
					break;
				}

				String received = dis.readUTF();
				System.out.println(received);
			}

			scn.close();
			dis.close();
			dos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}