package com.github.diegopacheco.java.pocs.workflow.templatemethod;

import java.util.concurrent.atomic.AtomicInteger;

// Responsible for know the execution order.
// This style plays well with dependency injection, that's why all the dependencies are get from
// the Constructor. That's where you tell the order. Want to change the order? change the parameter order :-)
// *DISCLAIMER*: is is not 100% fully template method, because it has only one method on the template which
// is "execute" on the Task interface, usually TM has multiple methods in a form of algorithm.
// But this class here has stepFirst, stepSecond and stepLast. I could make them all abstract and be
// 100% template method but the issue will be forcing one class implement all tasks,
// this way we can distribute the implementation in multiple classes. That's why I'm bending the Pattern a bit.
public class WorkflowEngine {

    private Task stepFirst;
    private Task stepSecond;
    private Task stepLast;

    public WorkflowEngine(Task stepFirst, Task stepSecond, Task stepLast) {
        this.stepFirst = stepFirst;
        this.stepSecond = stepSecond;
        this.stepLast = stepLast;
    }

    public Boolean run(Context ec){
       return run(ec,0);
    }

    // Could do many other things and improvements like:
    // measure how long each task takes to run in ms
    // measure success/error hate, have exceptions per type and Task(Error Observability).
    // Store result of each task on the DB
    // Have common, retry logic 3x with jitter, exponential backoff
    // Cache tasks to make reflection faster.
    // See that Reputability is all here, move it to all in one place.
    // since now is just calling methods.
    public Boolean run(Context ec,int stopAt){
        System.out.println("*** Workflow Engine: START ");
        AtomicInteger executionOrder = new AtomicInteger(1);

        try{
            switch (stopAt){
                case 3:
                    stepLast(ec);
                    break;
                case 2:
                    before(executionOrder,"Second");
                    stepSecond(ec);
                    before(executionOrder,"Last");
                    stepLast(ec);
                    break;
                case 0:
                case 1:
                default:
                    before(executionOrder,"First");
                    stepFirst(ec);
                    before(executionOrder,"Second");
                    stepSecond(ec);
                    before(executionOrder,"Last");
                    stepLast(ec);
            }

        }catch(Exception e){
            throw new RuntimeException(e);
        }
        System.out.println("*** Workflow Engine: END ");
        return true;
    }

    private void before(AtomicInteger executionOrder, String step) {
        System.out.println("*** Workflow Engine: Running [" + step +
                "] - Step: [" + executionOrder.getAndIncrement() + "]");
    }

    private Boolean stepFirst(Context context){
        return stepFirst.execute(context);
    }
    private Boolean stepSecond(Context context){
        return stepSecond.execute(context);
    }
    private Boolean stepLast(Context context){
        return stepLast.execute(context);
    }

}