package com.github.diegopacheco.vertx.epoll;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.core.VertxOptions;
import io.vertx.core.net.NetSocket;
import io.vertx.core.net.SocketAddress;
import io.vertx.core.parsetools.RecordParser;
import java.util.stream.Stream;

public class Client extends AbstractVerticle{
	
	 @Override
   public void start() throws Exception {
       vertx.createNetClient ().connect(SocketAddress.domainSocketAddress("/tmp/testsocket.sock"), res -> {
           if (res.succeeded ()) {
               NetSocket socket = res.result ();
               RecordParser.newDelimited ("\n", socket)
                       .endHandler (v -> socket.close ())
                       .exceptionHandler (t -> {
                           t.printStackTrace ();
                           socket.close ();
                       })
                       .handler (buffer -> {
                           String line = buffer.toString("UTF-8");
                           System.out.println ("Net Client receiving: " + line);
                       });
               Stream.of("John", "Joe", "Lisa", "Bill").forEach (name -> {
                   System.out.println ("Net Client sending: " + name);
                   socket.write(name).write("\n");
               });
           } else {
               System.out.println ("Failed to connect " + res.cause ());
           }
       });
   }

   public static void main(String[] args) {
       VertxOptions vertxOptions = new VertxOptions ().
               setPreferNativeTransport (true);
       Vertx vertx = Vertx.vertx (vertxOptions);
       boolean usingNative = vertx.isNativeTransportEnabled();
       System.out.println("Running with native: " + usingNative);

       vertx.deployVerticle (new Client());
   }
	
}
