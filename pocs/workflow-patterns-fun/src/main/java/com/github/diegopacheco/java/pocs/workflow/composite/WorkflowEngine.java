package com.github.diegopacheco.java.pocs.workflow.composite;

import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

// Responsible for know the execution order.
public class WorkflowEngine implements Task {

    private ConcurrentLinkedDeque<Task> tasks = new ConcurrentLinkedDeque<>();

    public Boolean execute(Context ec) {
        return execute(ec, 1);
    }

    public boolean addChild(Task task){
        tasks.add(task);
        return true;
    }

    // don't really need to use, but is here to follow the Pattern.
    public boolean removeChild(Task task){
        tasks.remove(task);
        return true;
    }

    // Could do many other things and improvements like:
    // measure how long each task takes to run in ms
    // measure success/error hate, have exceptions per type and Task(Error Observability).
    // Store result of each task on the DB
    // Have common, retry logic 3x with jitter, exponential backoff
    // Cache tasks to make reflection faster.
    // See that Reputability is all here, move it to all in one place.
    // since now is just calling methods.
    public Boolean execute(Context ec, int stopAt) {
        System.out.println("*** Workflow Engine: START ");
        AtomicInteger executionOrder = new AtomicInteger(1);

        // Here is the new ResumeFactory, very simple!
        List<Task> tasksToRun;
        if (0==stopAt||1==stopAt){
            tasksToRun = tasks.stream().toList();
        }else{
            tasksToRun = tasks.stream().skip(stopAt - 1).collect(Collectors.toList());
        }

        try {
            for(Task currentTask : tasksToRun){
                before(executionOrder,currentTask.getClass().getSimpleName());
                currentTask.execute(ec);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("*** Workflow Engine: END ");
        return true;
    }

    private void before(AtomicInteger executionOrder, String step) {
        System.out.println("*** Workflow Engine: Running [" + step +
                "] - Step: [" + executionOrder.getAndIncrement() + "]");
    }

}