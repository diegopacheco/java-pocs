import com.github.diegopacheco.poison.pill.pattern.Message;
import com.github.diegopacheco.poison.pill.pattern.PoisonPill;
import com.github.diegopacheco.poison.pill.pattern.Worker;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String args[]) throws Exception {
        BlockingQueue<Message> queue = new LinkedBlockingQueue<>();
        Worker worker = new Worker(queue);
        Thread workerThread = new Thread(worker, "Worker-1");
        workerThread.start();
        queue.put(new Message("Task A"));
        queue.put(new Message("Task B"));

        // Send the Poison Pill to signal termination
        queue.put(new PoisonPill());

        workerThread.join();
        System.out.println("Worker stopped gracefully.");
    }
}
