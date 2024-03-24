package com.github.diegopacheco.pocs.seda.seda;

import com.github.diegopacheco.pocs.seda.event.Event;
import com.github.diegopacheco.pocs.seda.synthetic.RequestGenerator;
import com.github.diegopacheco.pocs.seda.worker.*;
import com.github.diegopacheco.pocs.seda.worker.snapshot.SnapshotWorker;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.*;

@Component
public class SEDAManager {

    private static final Integer TOTAL_THREADS_PER_WORKER = 3;

    private static ExecutorService poolSanitizer = Executors.newFixedThreadPool(TOTAL_THREADS_PER_WORKER, Thread.ofVirtual().factory());
    private static ExecutorService poolCat = Executors.newFixedThreadPool(TOTAL_THREADS_PER_WORKER, Thread.ofVirtual().factory());
    private static ExecutorService poolConsole = Executors.newFixedThreadPool(TOTAL_THREADS_PER_WORKER, Thread.ofVirtual().factory());

    private static ScheduledExecutorService poolSnapshoting = Executors.newScheduledThreadPool(1, Thread.ofVirtual().factory());

    private static Map<Queues, Map<UUID,Runnable>> processes = new ConcurrentHashMap<>();

    public void run(){
        System.out.println("**************************");
        System.out.println("*** Quem tem SEDA ? ******");
        System.out.println("**************************");
        System.out.println("* ");
        System.out.println("* SEDA Manager ");
        System.out.println("* ");
        System.out.println("*                      |-------------------|                |-------------------|                |-------------------| ");
        System.out.println("* events --> [exe-pool]|-- sanitizer(W1) --|  ==> [exe-pool]|-- cat(W2) --------|  ==> [exe-pool]|-- console(W3) ----| ");
        System.out.println("*                      |-------------------|                |-------------------|                |-------------------| ");
        System.out.println("* ");
        System.out.println("* STARTED !");

        processes.put(Queues.SANITIZER_QUEUE,new ConcurrentHashMap<>());
        processes.put(Queues.CAT_QUEUE,new ConcurrentHashMap<>());
        processes.put(Queues.CONSOLE_QUEUE,new ConcurrentHashMap<>());
        poolSnapshoting.scheduleAtFixedRate(new SnapshotWorker(processes),0, 2,TimeUnit.SECONDS);

        generate(1);
        System.out.println("* SEDA Manager done provisioned  " + TOTAL_THREADS_PER_WORKER +
                            "  thread pools per worker ");
    }

    public boolean publish(Queues queue,Event<String> event){
        if (null!=event){
            switch (queue){
                case SANITIZER_QUEUE -> {
                    UUID id = UUID.randomUUID();
                    Runnable worker = newSanitizerWorker(event,id);
                    processes.get(Queues.SANITIZER_QUEUE).put(id,worker);
                    poolSanitizer.submit(worker);
                }
                case CAT_QUEUE -> {
                    UUID id = UUID.randomUUID();
                    Runnable worker = newCatWorker(event,id);
                    processes.get(Queues.CAT_QUEUE).put(id,worker);
                    poolCat.submit(worker);
                }
                case CONSOLE_QUEUE -> {
                    UUID id = UUID.randomUUID();
                    Runnable worker = newConsoleWorker(event,id);
                    processes.get(Queues.CONSOLE_QUEUE).put(id,worker);
                    poolConsole.submit(worker);
                }
            }
            return true;
        }
        return false;
    }

    public CompletionHandler createCompletionHandler(Queues queue,UUID id){
        return new CompletionHandler(){
            @Override
            public void signalDone() {
                processes.get(queue).remove(id);
            }
        };
    }

    private Worker newSanitizerWorker(Event<String> event,UUID id){
        WorkerContext ctx = new WorkerContext(this,Queues.CAT_QUEUE, event,createCompletionHandler(Queues.SANITIZER_QUEUE, id));
        return new SanitizerWorker(ctx);
    }

    private Worker newCatWorker(Event<String> event,UUID id){
        WorkerContext ctx = new WorkerContext(this,Queues.CONSOLE_QUEUE, event,createCompletionHandler(Queues.CAT_QUEUE, id));
        return new CatWorker(ctx,poolCat);
    }

    private Worker newConsoleWorker(Event<String> event, UUID id){
        WorkerContext ctx = new WorkerContext(this,Queues.END, event,createCompletionHandler(Queues.CONSOLE_QUEUE, id));
        return new ConsoleWorker(ctx);
    }

    public void generate(int amount){
        RequestGenerator generator = new RequestGenerator();
        generator.generate(amount).forEach(event -> publish(Queues.SANITIZER_QUEUE,event));
        System.out.println("* >>> " + amount + " events generated! ");
    }

}