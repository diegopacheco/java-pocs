import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class Main {
  public static void main(String args[]) throws InterruptedException {
    Set<String> vthreadNames = ConcurrentHashMap.newKeySet();
    Set<String> pthreadNames = ConcurrentHashMap.newKeySet();
    Instant start = Instant.now();

    List<Thread> vThreads = IntStream.range(0, 10_000_000).mapToObj(i -> Thread.ofVirtual().unstarted(() -> {
      vthreadNames.add(Thread.currentThread().toString());
      pthreadNames.add(Thread.currentThread().getName());
    })).toList();
    vThreads.forEach(Thread::start);
    for (Thread t : vThreads) {
      t.join();
    }
    Instant end = Instant.now();
    System.out.println("Execution time: " + Duration.between(start, end).toMillis() + " ms");
    System.out.println("| Total OS Threads: " + pthreadNames.size());
    System.out.println("| Total Cores: " + Runtime.getRuntime().availableProcessors());
    System.out.println("| Total Virtual Threads: " + vthreadNames.size());
  }
}
