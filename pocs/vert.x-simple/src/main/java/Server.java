import io.vertx.core.AbstractVerticle;

public class Server extends AbstractVerticle {
    public void start() {
      vertx.createHttpServer().requestHandler(req -> {
        req.response()
          .putHeader("content-type", "text/plain")
          .end("Hello from Vert.x!");
      }).listen(8080);
    }
  }