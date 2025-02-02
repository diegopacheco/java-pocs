package com.github.diegopacheco.pocs.seda.seda;

import com.github.diegopacheco.pocs.seda.event.Event;
import com.github.diegopacheco.pocs.seda.synthetic.RequestGenerator;
import com.github.diegopacheco.pocs.seda.worker.CatWorker;
import com.github.diegopacheco.pocs.seda.worker.ConsoleWorker;
import com.github.diegopacheco.pocs.seda.worker.SanitizerWorker;
import com.github.diegopacheco.pocs.seda.worker.Worker;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

@Component
public class SEDAManager {

    private static final Integer TOTAL_THREADS_PER_WORKER = 3;

    private static ExecutorService poolSanitizer = Executors.newFixedThreadPool(TOTAL_THREADS_PER_WORKER, Thread.ofVirtual().factory());;
    private static ExecutorService poolCat = Executors.newFixedThreadPool(TOTAL_THREADS_PER_WORKER, Thread.ofVirtual().factory());;
    private static ExecutorService poolConsole = Executors.newFixedThreadPool(TOTAL_THREADS_PER_WORKER, Thread.ofVirtual().factory());;

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

    public boolean publish(Queues queue,Event<String> event){
        if (null!=event){
            switch (queue){
                case SANITIZER_QUEUE -> poolSanitizer.submit(newSanitizerWorker(event));
                case CAT_QUEUE -> poolCat.submit(newCatWorker(event));
                case CONOSLE_QUEUE -> poolConsole.submit(newConsoleWorker(event));
            }
            return true;
        }
        return false;
    }

    private Worker newSanitizerWorker(Event<String> event){
        return new SanitizerWorker(this,Queues.CAT_QUEUE, event);
    }

    private Worker newCatWorker(Event<String> event){
        return new CatWorker(this,Queues.CONOSLE_QUEUE, event);
    }

    private Worker newConsoleWorker(Event<String> event){
        return new ConsoleWorker(event);
    }

    public void generate(int amount){
        RequestGenerator generator = new RequestGenerator();
        generator.generate(amount).forEach(event -> publish(Queues.SANITIZER_QUEUE,event));
        System.out.println("* >>> " + amount + " events generated! ");
    }

}