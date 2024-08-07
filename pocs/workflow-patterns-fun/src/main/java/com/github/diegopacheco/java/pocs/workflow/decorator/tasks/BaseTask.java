package com.github.diegopacheco.java.pocs.workflow.decorator.tasks;

import com.github.diegopacheco.java.pocs.workflow.decorator.Context;
import com.github.diegopacheco.java.pocs.workflow.decorator.Task;

// The Engine is here now, here is the common code between all tasks
// This class does not control the whole execution, just execute whatever next class got from contractor.
public abstract class BaseTask implements Task {
    protected Task next;

    public BaseTask(Task next) {
        this.next = next;
    }

    public  Boolean before(Context context,String executor) {
        int step = Integer.parseInt(context.get("STEP","0"));
        System.out.println("*** Workflow Engine: Running [" + executor + "] - Step: [" + step + "]");
        context.set("STEP",++step+"");
        return true;
    }

    protected Boolean after(Context context){
        if (next!=null)
            return next.execute(context);
        return null;
    }

}
