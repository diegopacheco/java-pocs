import org.tinylog.Logger;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String args[]) {

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                Logger.info("App is going down! Bye. ");
            }
        });

        Logger.info("Hello World from TinyLog 2");

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ses.scheduleAtFixedRate( () -> {
            Logger.info(UUID.randomUUID().toString() + " - " + System.nanoTime());
        }, 0, 5, TimeUnit.SECONDS);

    }
}
