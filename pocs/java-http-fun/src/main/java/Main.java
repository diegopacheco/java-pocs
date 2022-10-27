import io.fusionauth.http.server.HTTPHandler;
import io.fusionauth.http.server.HTTPListenerConfiguration;
import io.fusionauth.http.server.HTTPServer;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicBoolean;

public class Main{
  public static void main(String args[]){
    AtomicBoolean shouldRun = new AtomicBoolean(true);
    HTTPHandler handler = (req, res) -> {
      System.out.println("[new request] " + req.getPath());
      if (req.getPath().equals("/")){
        res.getWriter().write("works");
        res.getWriter().flush();
        return;
      }
      if (req.getPath().equals("/shutdown")){
        System.out.println("Shuting donw");
        shouldRun.set(false);
        return;
      }

      res.getWriter().write("Path: [" + req.getPath() + "] not mapped");
      res.getWriter().flush();
    };

    System.out.println("running on http://127.0.0.1:8080/");
    try (HTTPServer server = new HTTPServer().withHandler(handler).
            withNumberOfWorkerThreads(10).
            withShutdownDuration(Duration.ofSeconds(1000)).
            withListener(new HTTPListenerConfiguration(8080))
    ) {
      server.start();
      while(shouldRun.get()){
        Thread.sleep(2000);
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
