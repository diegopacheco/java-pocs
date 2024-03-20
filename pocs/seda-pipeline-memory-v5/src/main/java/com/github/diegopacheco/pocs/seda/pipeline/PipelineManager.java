package com.github.diegopacheco.pocs.seda.pipeline;

import com.github.diegopacheco.pocs.seda.queue.QueueManager;
import com.github.diegopacheco.pocs.seda.queue.Queues;
import com.github.diegopacheco.pocs.seda.synthetic.RequestGenerator;
import com.github.diegopacheco.pocs.seda.worker.CatWorker;
import com.github.diegopacheco.pocs.seda.worker.ConsoleWorker;
import com.github.diegopacheco.pocs.seda.worker.SanitizerWorker;
import com.github.diegopacheco.pocs.seda.worker.Worker;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class PipelineManager {

    private static final Integer TOTAL_THREADS_PER_WORKER = 3;

    private static ExecutorService poolSanitizer = Executors.newFixedThreadPool(TOTAL_THREADS_PER_WORKER);
    private static ExecutorService poolCat = Executors.newFixedThreadPool(TOTAL_THREADS_PER_WORKER);
    private static ExecutorService poolConsole = Executors.newFixedThreadPool(TOTAL_THREADS_PER_WORKER);

    private static QueueManager<String> queueSanitizer = new QueueManager<>("queue-sanitizer");
    private static QueueManager<String> queueCat = new QueueManager<>("queue-cat");
    private static QueueManager<String> queueConsole = new QueueManager<>("queue-console");

    private static ConcurrentLinkedDeque<Worker> sanitizerWorkers = new ConcurrentLinkedDeque<Worker>();
    private static ConcurrentLinkedDeque<Worker> catWorkers = new ConcurrentLinkedDeque<Worker>();
    private static ConcurrentLinkedDeque<Worker> consoleWorkers = new ConcurrentLinkedDeque<Worker>();

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
            Worker w = newSanitizerWorker();
            sanitizerWorkers.add(w);
            poolSanitizer.submit(w);

            w = newCatWorker();
            catWorkers.add(w);
            poolCat.submit(w);

            w = newConsoleWorker();
            consoleWorkers.add(w);
            poolConsole.submit(w);
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

    private Worker newSanitizerWorker(){
        return new SanitizerWorker(queueSanitizer,queueCat);
    }

    private Worker newCatWorker(){
        return new CatWorker(queueCat,queueConsole);
    }

    private Worker newConsoleWorker(){
        return new ConsoleWorker(queueConsole);
    }

    public void drain(Queues queues){
        System.out.println(" PipelineManager draining pool: " + queues);
        switch (queues){
            case SANITIZER_QUEUE -> sanitizerWorkers.forEach(Worker::drain);
            case CAT_QUEUE -> catWorkers.forEach(Worker::drain);
            case CONOSLE_QUEUE -> consoleWorkers.forEach(Worker::drain);
        }
    }

    public void resume(Queues queues){
        System.out.println(" PipelineManager resume pool: " + queues);
        switch (queues){
            case SANITIZER_QUEUE -> reSubmitWorkerToCarriers(sanitizerWorkers,poolSanitizer,newSanitizerWorker());
            case CAT_QUEUE ->  reSubmitWorkerToCarriers(catWorkers,poolCat,newCatWorker());
            case CONOSLE_QUEUE -> reSubmitWorkerToCarriers(consoleWorkers,poolConsole,newConsoleWorker());
        }
    }

    private void reSubmitWorkerToCarriers(ConcurrentLinkedDeque<Worker> workers,
                                          ExecutorService executor,
                                          Worker workerInstance){
        // recreate worker objects
        for(int i=1;i<=TOTAL_THREADS_PER_WORKER;i++) {
            workers.add(workerInstance);
        }

        // resume workers
        workers.forEach(Worker::resume);

        // submit to executor
        for(int i=1;i<=TOTAL_THREADS_PER_WORKER;i++) {
            executor.submit(workerInstance);
        }
    }

}
