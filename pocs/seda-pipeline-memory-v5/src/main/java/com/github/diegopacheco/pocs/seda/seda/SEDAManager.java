package com.github.diegopacheco.pocs.seda.seda;

import com.github.diegopacheco.pocs.seda.synthetic.RequestGenerator;
import com.github.diegopacheco.pocs.seda.worker.CatWorker;
import com.github.diegopacheco.pocs.seda.worker.ConsoleWorker;
import com.github.diegopacheco.pocs.seda.worker.SanitizerWorker;
import com.github.diegopacheco.pocs.seda.worker.Worker;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

public class SEDAManager<T> {

    private static final Integer TOTAL_THREADS_PER_WORKER = 3;

    private static ExecutorService poolSanitizer = Executors.newFixedThreadPool(TOTAL_THREADS_PER_WORKER);
    private static ExecutorService poolCat = Executors.newFixedThreadPool(TOTAL_THREADS_PER_WORKER);
    private static ExecutorService poolConsole = Executors.newFixedThreadPool(TOTAL_THREADS_PER_WORKER);

    private static ConcurrentLinkedDeque<Worker> sanitizerWorkers = new ConcurrentLinkedDeque<Worker>();
    private static ConcurrentLinkedDeque<Worker> catWorkers = new ConcurrentLinkedDeque<Worker>();
    private static ConcurrentLinkedDeque<Worker> consoleWorkers = new ConcurrentLinkedDeque<Worker>();

    private LinkedBlockingDeque<T> queue = new LinkedBlockingDeque<>();
    private String name;

    public SEDAManager(String name){
        this.name = name;
    }

    public SEDAManager(Queue<T> queue, String name) {
        this.queue =(LinkedBlockingDeque)queue;
        this.name = name;
    }

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

        generate(1);
        System.out.println("* SEDA Manager done provisioned  " + TOTAL_THREADS_PER_WORKER +
                            "  thread pools per worker ");
    }

    public boolean publish(Queues queue,T event){
        if (null!=event){
            switch (queue){
                case SANITIZER_QUEUE -> poolSanitizer.submit(newSanitizerWorker(event));
                case CAT_QUEUE -> poolCat.submit(newCatWorker(event));
                case CONOSLE_QUEUE -> poolConsole.submit(new ConsoleWorker((String) event));
            }
            return true;
        }
        return false;
    }

    private Worker newSanitizerWorker(T event){
        return new SanitizerWorker((SEDAManager<String>)this,Queues.CAT_QUEUE, (String) event);
    }

    private Worker newCatWorker(T event){
        return new CatWorker((SEDAManager<String>)this,Queues.CONOSLE_QUEUE, (String) event);
    }

    private Worker newConsoleWorker(T event){
        return new ConsoleWorker((String) event);
    }

    public String getName() {
        return name;
    }

    public void generate(int amount){
        RequestGenerator generator = new RequestGenerator();
        generator.generate(amount).forEach(System.out::println);
        System.out.println("* >>> " + amount + " events generated! ");
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
