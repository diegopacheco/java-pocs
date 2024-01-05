import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Main {
    public static void main(String args[]) throws InterruptedException {

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        AtomicInteger counter = new AtomicInteger(1);

        List<Thread> vThreads = IntStream.range(0, 10).
                mapToObj(i -> Thread.ofVirtual().unstarted(() -> {
                    threadLocal.set(" ***** [" + Thread.currentThread().toString() + "] nun: " + (counter.incrementAndGet()));
                    System.out.println(">>> Current Thread : " +
                            Thread.currentThread().toString() +
                            " Thread Local: " + threadLocal.get());
                })).toList();
        vThreads.forEach(Thread::start);
        for (Thread t : vThreads) {
            t.join();
        }
    }
}
