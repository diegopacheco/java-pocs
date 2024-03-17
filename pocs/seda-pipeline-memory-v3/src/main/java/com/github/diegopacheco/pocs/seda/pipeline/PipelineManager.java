package com.github.diegopacheco.pocs.seda.pipeline;

import com.github.diegopacheco.pocs.seda.queue.QueueManager;
import com.github.diegopacheco.pocs.seda.synthetic.RequestGenerator;
import com.github.diegopacheco.pocs.seda.worker.CatWorker;
import com.github.diegopacheco.pocs.seda.worker.ConsoleWorker;
import com.github.diegopacheco.pocs.seda.worker.SanitizerWorker;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class PipelineManager {

    private static final Integer TOTAL_THREADS_PER_WORKER = 7;

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
            poolConsole.submit(newConsoleWorker());
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

    private Runnable newSanitizerWorker(){
        SanitizerWorker worker = new SanitizerWorker(queueSanitizer,queueCat);
        return worker::run;
    }

    private Runnable newCatWorker(){
        CatWorker worker = new CatWorker(queueCat,queueConsole);
        return worker::run;
    }

    private Runnable newConsoleWorker(){
        ConsoleWorker worker = new ConsoleWorker(queueConsole);
        return worker::run;
    }

}
