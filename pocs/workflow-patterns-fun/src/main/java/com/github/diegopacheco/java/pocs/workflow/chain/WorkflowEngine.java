package com.github.diegopacheco.java.pocs.workflow.chain;

import com.github.diegopacheco.java.pocs.workflow.chain.tasks.GetWater;

public class WorkflowEngine {

    private Task initialTask;

    public WorkflowEngine() {
        this.initialTask = new GetWater();
    }

    public WorkflowEngine(Task initialTask) {
        this.initialTask = initialTask;
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
        System.out.println("*** Workflow Engine: Running [" +initialTask.getClass().getSimpleName()+"] - Step: ["+executionOrder+"]");
        executionOrder++;
        initialTask.execute(ec);

        try{
            Class<? extends Task> next = initialTask.next();
            while(null!=next){
                Task task = (Task)next.getDeclaredConstructors()[0].newInstance();
                System.out.println("*** Workflow Engine: Running [" +task.getClass().getSimpleName()+"] - Step: ["+executionOrder+"]");
                executionOrder++;
                task.execute(ec);
                next = task.next();
            }
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        System.out.println("*** Workflow Engine: END ");
        return true;
    }

}
