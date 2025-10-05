import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class RemoteService {
    private final Random random = new Random();
    private final AtomicInteger callCount = new AtomicInteger(0);

    public String call() throws Exception {
        int count = callCount.incrementAndGet();

        if (count % 10 == 0) {
            Thread.sleep(3000);
            throw new Exception("Timeout after 3 seconds");
        }

        if (count % 3 == 0) {
            throw new Exception("Service temporarily unavailable");
        }

        Thread.sleep(100);
        return "Service response for call #" + count;
    }

    public String slowCall() throws Exception {
        Thread.sleep(2000);
        return "Slow response";
    }

    public void reset() {
        callCount.set(0);
    }

    public int getCallCount() {
        return callCount.get();
    }
}
