import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;

public class MathService {

    private final AtomicInteger tasksSubmitted = new AtomicInteger(0);
    private final AtomicInteger tasksCompleted = new AtomicInteger(0);
    private final long startTime;
    private long lastSubmissionTime;

    public MathService() {
        this.startTime = System.currentTimeMillis();
        this.lastSubmissionTime = startTime;
    }

    public CompletableFuture<Integer> sum(Integer a, Integer b) {
        printStats();
        tasksSubmitted.incrementAndGet();
        CompletableFuture<Integer> result = CompletableFuture.completedFuture(a + b)
                .thenApply(res -> {
                    sleep();
                    tasksCompleted.incrementAndGet();
                    return res;
                });
        printStats();
        return result;
    }

    public CompletableFuture<Integer> sub(Integer a, Integer b) {
        printStats();
        tasksSubmitted.incrementAndGet();
        CompletableFuture<Integer> result = CompletableFuture.supplyAsync(() -> a - b)
                .thenApply(res -> {
                    sleep();
                    tasksCompleted.incrementAndGet();
                    return res;
                });
        printStats();
        return result;
    }

    public CompletableFuture<Integer> mul(Integer a, Integer b) {
        printStats();
        tasksSubmitted.incrementAndGet();
        CompletableFuture<Integer> result = CompletableFuture.supplyAsync(() -> a * b)
                .thenApply(res -> {
                    sleep();
                    tasksCompleted.incrementAndGet();
                    return res;
                });
        printStats();
        return result;
    }

    public void printStats() {
        long currentTime = System.currentTimeMillis();
        long elapsedTime = currentTime - startTime;
        double elapsedTimeInSeconds = elapsedTime / 1000.0;

        long interArrivalTime = currentTime - lastSubmissionTime;
        double interArrivalTimeInSeconds = interArrivalTime / 1000.0;
        double arrivalRate = interArrivalTimeInSeconds > 0 ? 1.0 / interArrivalTimeInSeconds : Double.POSITIVE_INFINITY;

        double departureRate = elapsedTimeInSeconds > 0 ? tasksCompleted.get() / elapsedTimeInSeconds : Double.NaN;

        lastSubmissionTime = currentTime;

        System.out.println("ForkJoinPool.commonPool()");
        System.out.println("Size " + ForkJoinPool.commonPool().getPoolSize());
        System.out.println("Parallelism " + ForkJoinPool.commonPool().getParallelism());
        System.out.println("Queued " + ForkJoinPool.commonPool().getQueuedTaskCount());
        System.out.println("Steal " + ForkJoinPool.commonPool().getStealCount());
        System.out.println("Thread count " + Thread.activeCount());
        System.out.println("Tasks Submitted: " + tasksSubmitted.get());
        System.out.println("Tasks Completed: " + tasksCompleted.get());
        System.out.println("Arrival Rate: " + arrivalRate + " tasks/sec");
        System.out.println("Departure Rate: " + departureRate + " tasks/sec");
    }

    private static void sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
    }
}