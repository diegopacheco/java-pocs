package com.github.diegopacheco.sandbox.java.vertx.fun;

import org.vertx.java.core.Handler;
import org.vertx.java.core.net.NetSocket;
import org.vertx.java.core.streams.Pump;
import org.vertx.java.platform.Verticle;

public class Server extends Verticle {

  public void start() {
    vertx.createNetServer().connectHandler(new Handler<NetSocket>() {
      public void handle(final NetSocket socket) {
        Pump.createPump(socket, socket).start();
      }
    }).listen(1234);
  }
  
}