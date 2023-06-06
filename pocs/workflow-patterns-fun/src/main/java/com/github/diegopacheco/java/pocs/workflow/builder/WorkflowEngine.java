package com.github.diegopacheco.java.pocs.workflow.builder;

import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

// Responsible for know the execution order.
public class WorkflowEngine {

    private Deque<Task> tasks;

    // don't want anyone calling this - use the builder instead.
    private WorkflowEngine(Deque<Task> tasks) {
        this.tasks = tasks;
    }

    // Could do many other things and improvements like:
    // measure how long each task takes to run in ms
    // measure success/error hate, have exceptions per type and Task(Error Observability).
    // Store result of each task on the DB
    // Have common, retry logic 3x with jitter, exponential backoff
    // Cache tasks to make reflection faster.
    public Boolean execute(Context ec){
        System.out.println("*** Workflow Engine: START ");

        int executionOrder = 1;
        try{
            Task currentTask = tasks.pop();
            while(true){
                System.out.println("*** Workflow Engine: Running [" +currentTask.getClass().getSimpleName()+"] - Step: ["+executionOrder+"]");
                executionOrder++;
                currentTask.execute(ec);
                if (tasks.isEmpty()) break;
                currentTask = tasks.pop();
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        System.out.println("*** Workflow Engine: END ");
        return true;
    }

    public static class Builder{

        private Deque<Task> tasks = new ConcurrentLinkedDeque<>();

        public Builder withInitialTask(Task initialTask){
            tasks.add(initialTask);
            return this;
        }

        public Builder addTask(Task task){
            tasks.add(task);
            return this;
        }

        public WorkflowEngine build(){
            return new WorkflowEngine(tasks);
        }
    }

}
