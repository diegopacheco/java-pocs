package com.github.diegopacheco.pocs.seda.worker;

import com.github.diegopacheco.pocs.seda.ff.FeatureFlagManager;
import com.github.diegopacheco.pocs.seda.metrics.MetricsManager;
import com.github.diegopacheco.pocs.seda.queue.QueueManager;
import com.github.diegopacheco.pocs.seda.thread.SilentThread;

import java.util.Date;

public class ConsoleWorker extends DynamicBaseWorker implements Worker {

    private QueueManager<String> inQueue;

    public ConsoleWorker(QueueManager<String> inQueue) {
        this.inQueue = inQueue;
    }

    @Override
    public void run() {
        while (true) {
            if (isRunning()){
                String event = inQueue.consume();
                if (null != event) {
                    try{
                        SilentThread.sleep(FeatureFlagManager.get(FeatureFlagManager.WORKER_CONSOLE_TIME_BACKPRESSURE_MS));
                        System.out.println(new Date() + " - event finish pipeline.");
                        System.out.println(event);

                        MetricsManager.ok(inQueue.getName(),ConsoleWorker.class.getSimpleName());
                    }catch(Exception e){
                        MetricsManager.error(inQueue.getName(),ConsoleWorker.class.getSimpleName());
                    }
                }
            }else{
                break; // finish the task, since was drained. Therefore, we let the Runnable complete to avoid using cpu.
            }
        }
        System.out.println("Worker[" + this.getClass().getSimpleName() +
                "~" + Thread.currentThread().getName() +
                "] completed. ");
    }
}
