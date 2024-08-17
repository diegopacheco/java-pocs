import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;

public class MathServiceTest {

    @Test
    public void testSum() {
        MathService mathService = new MathService();
        mathService.sum(10, 5);
    }

    @Test
    public void testSub() {
        MathService mathService = new MathService();
        mathService.sub(10, 5);
    }

    @Test
    public void stress() throws InterruptedException {
        MathService mathService = new MathService();
        int numThreads = 10;
        int numTasks = 50;
        CountDownLatch latch = new CountDownLatch(numThreads);
        for (int i = 0; i < numThreads; i++) {
            new Thread(() -> {
                for (int j = 0; j < numTasks; j++) {
                    mathService.sum(5, 4);
                }
                latch.countDown();
            }).start();
        }
        latch.await();
    }

}
