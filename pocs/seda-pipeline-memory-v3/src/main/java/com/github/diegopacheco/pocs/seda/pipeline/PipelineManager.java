package com.github.diegopacheco.pocs.seda.worker;

import com.github.diegopacheco.pocs.seda.queue.QueueManager;
import com.github.diegopacheco.pocs.seda.synthetic.RequestGenerator;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class PipelineManager {

    private static final Integer TOTAL_THREADS_PER_WORKER = 10;

    private static ExecutorService poolSanitizer = Executors.newFixedThreadPool(TOTAL_THREADS_PER_WORKER);
    private static ExecutorService poolCat = Executors.newFixedThreadPool(TOTAL_THREADS_PER_WORKER);
    private static ExecutorService poolConsole = Executors.newFixedThreadPool(TOTAL_THREADS_PER_WORKER);

    private static QueueManager<String> queueSanitizer = new QueueManager<>("queue-sanitizer");
    private static QueueManager<String> queueCat = new QueueManager<>("queue-cat");
    private static QueueManager<String> queueConsole = new QueueManager<>("queue-console");

    public void run(){
        System.out.println("**************************");
        System.out.println("*** Quem tem SEDA ? ******");
        System.out.println("**************************");
        System.out.println("* ");
        System.out.println("* Pipeline Manager ");
        System.out.println("* ");
        System.out.println("*                      |-------------------|                |-------------------|                |-------------------| ");
        System.out.println("* events --> [in-queue]|-- sanitizer(W1) --|  ==> [in-queue]|-- cat(W2) --------|  ==> [in-queue]|-- console(W3) ----| ");
        System.out.println("*                      |-------------------|                |-------------------|                |-------------------| ");
        System.out.println("* ");
        System.out.println("* STARTED !");

        generate(1);
        for(int i=1;i<=TOTAL_THREADS_PER_WORKER;i++){
            poolSanitizer.submit(newSanitizerWorker());
            poolCat.submit(newCatWorker());
            poolCat.submit(newConsoleWorker());
        }
        System.out.println("* Pipeline Manager done provisioned  " + TOTAL_THREADS_PER_WORKER +
                           "  thread pools per worker ");
    }

    public void publish(String event){
        queueSanitizer.publish(event);
    }

    public void generate(int amount){
        RequestGenerator generator = new RequestGenerator();
        generator.generate(amount,queueSanitizer);
        System.out.println("* >>> " + amount + " events generated! ");
    }

    private Thread newSanitizerWorker(){
        SanitizerWorker worker = new SanitizerWorker(queueSanitizer,queueCat);
        return new Thread(worker::run);
    }

    private Thread newCatWorker(){
        CatWorker worker = new CatWorker(queueCat,queueConsole);
        return new Thread(worker::run);
    }

    private Thread newConsoleWorker(){
        ConsoleWorker worker = new ConsoleWorker(queueConsole);
        return new Thread(worker::run);
    }

}
