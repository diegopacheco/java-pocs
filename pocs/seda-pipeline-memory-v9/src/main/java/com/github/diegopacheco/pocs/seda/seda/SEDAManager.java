package com.github.diegopacheco.pocs.seda.seda;

import com.github.diegopacheco.pocs.seda.event.Event;
import com.github.diegopacheco.pocs.seda.synthetic.RequestGenerator;
import com.github.diegopacheco.pocs.seda.worker.*;
import com.github.diegopacheco.pocs.seda.worker.snapshot.SnapshotWorker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.*;
import java.util.stream.Stream;

@Component
public class SEDAManager {

    private static final Integer TOTAL_THREADS_PER_WORKER = 3;

    private static final Integer SNAPSHOTTING_INTERVAL_SEC = 30;

    private static ExecutorService poolSanitizer = Executors.newFixedThreadPool(TOTAL_THREADS_PER_WORKER, Thread.ofVirtual().factory());
    private static ExecutorService poolCat = Executors.newFixedThreadPool(TOTAL_THREADS_PER_WORKER, Thread.ofVirtual().factory());
    private static ExecutorService poolConsole = Executors.newFixedThreadPool(TOTAL_THREADS_PER_WORKER, Thread.ofVirtual().factory());

    private static ScheduledExecutorService poolSnapshoting = Executors.newScheduledThreadPool(1, Thread.ofVirtual().factory());

    private static Map<Queues, Map<UUID,Runnable>> processes = new ConcurrentHashMap<>();

    private Gson gson;

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
        poolSnapshoting.scheduleAtFixedRate(new SnapshotWorker(processes),0, SNAPSHOTTING_INTERVAL_SEC,TimeUnit.SECONDS);

        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        builder.addSerializationExclusionStrategy(new WokerContextExclusionStrategy());
        this.gson = builder.create();

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

    public void restore(){
        try{
            String path = new File(".").getCanonicalPath() + "/target/snapshot/";
            if (!new File(path).exists()){
                new File(path).mkdirs();
            }
            try (Stream<Path> paths = Files.walk(Paths.get(path))) {
                paths
                    .filter(Files::isRegularFile)
                    .forEach( p -> restoreEvent(p));
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    private void restoreEvent(Path path){
        try{
            String json = new String(Files.readAllBytes(Paths.get(path.toAbsolutePath().toString())));
            Event event = gson.fromJson(json, Event.class);

            String[] data = path.getFileName().toFile().toString().split("_@_");
            Queues queue = Queues.fromName(data[0]);
            UUID id = UUID.fromString(data[1]);

            System.out.println(">>> Restoring: " + queue + " id: " + id  + " event: " + event);
            publish(queue,event);
            System.out.println(">>> Restore done. ");

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}