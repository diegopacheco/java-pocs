package com.github.diegopacheco.vertx.epoll;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.net.SocketAddress;
import io.vertx.core.parsetools.RecordParser;

// Unix domain socket
public class Server extends AbstractVerticle {

	@Override
	public void start() throws Exception {
		vertx.createNetServer().connectHandler(sock -> {
			RecordParser parser = RecordParser.newDelimited("\n", sock);
			parser.endHandler(v -> sock.close()).exceptionHandler(t -> {
				t.printStackTrace();
				sock.close();
			}).handler(buffer -> {
				String line = buffer.toString("UTF-8");
				System.out.println("Received: " + line);
				sock.write("Received : " + line + "\n", "UTF-8");
			});
		}).listen(SocketAddress.domainSocketAddress("/tmp/testsocket.sock"));
		System.out.println("Echo domain socket is listening");
	}

	public static void main(String[] args) {
		VertxOptions vertxOptions = new VertxOptions().setPreferNativeTransport(true);
		Vertx vertx = Vertx.vertx(vertxOptions);

		boolean usingNative = vertx.isNativeTransportEnabled();
		System.out.println("Running with native: " + usingNative);
		vertx.deployVerticle(new Server());
		
		// sudo apt install -y socat
		// socat - UNIX-CONNECT:/tmp/testsocket.sock
		// nc -U /tmp/testsocket.sock
		// ls -lsa /tmp/testsocket.sock
	}

}
