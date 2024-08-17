import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicLong;

public class MathService {

    private ExecutorService es = Executors.newFixedThreadPool(10);
    private AtomicLong submittedTasks = new AtomicLong(0);
    private AtomicLong completedTasks = new AtomicLong(0);
    private long startTime;

    private ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);

    public MathService() {
        this.startTime = System.currentTimeMillis();
        ses.scheduleAtFixedRate(() -> printStats(), 0, 1, java.util.concurrent.TimeUnit.SECONDS);
    }

    public void sum(int a, int b) {
        sleep();
        submittedTasks.incrementAndGet();
        es.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Sum: " + (a + b));
                sleep();
                sleep();
                completedTasks.incrementAndGet();
            }
        });
    }

    public void sub(int a, int b) {
        sleep();
        submittedTasks.incrementAndGet();
        es.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Sub: " + (a - b));
                sleep();
                sleep();
                completedTasks.incrementAndGet();
            }
        });
    }

    private void printStats() {
        ThreadPoolExecutor executor = (ThreadPoolExecutor) es;
        int activeCount = executor.getActiveCount();
        long completedTaskCountES = executor.getCompletedTaskCount();
        long taskCount = executor.getTaskCount();
        int queueSize = executor.getQueue().size();
        long submittedTaskCount = submittedTasks.get();
        long completedTaskCountCT = completedTasks.get();

        long elapsedTime = (System.currentTimeMillis() - startTime) / 1000; // in seconds
        double arrivalRate = 0;
        double departureRate = 0;
        double throughput = 0;

        if (elapsedTime > 0) {
            arrivalRate = (double) submittedTaskCount / elapsedTime;
            departureRate = (double) completedTaskCountCT / elapsedTime;
            throughput = (double) completedTaskCountCT / elapsedTime;
        }

        System.out.println("Stats ***");
        System.out.println("Active Threads: " + activeCount);
        System.out.println("Completed Tasks: " + completedTaskCountES);
        System.out.println("Total Tasks: " + taskCount);
        System.out.println("Queue Size: " + queueSize);
        System.out.println("Arrival Rate/s   : " + arrivalRate);
        System.out.println("Departure Rate/s : " + departureRate);
        System.out.println("Throughput/s     : " + throughput);
        System.out.println("");
    }

    private static void sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}
    }

}