package com.github.diegopacheco.java.pocs.workflow.decorator.tasks;

import com.github.diegopacheco.java.pocs.workflow.decorator.Context;
import com.github.diegopacheco.java.pocs.workflow.decorator.Task;

public abstract class BaseTask implements Task {
    protected Task next;

    public BaseTask(Task next) {
        this.next = next;
    }

    public Boolean run(Context context){
        before(context,this.getClass().getSimpleName());
        execute(context);
        executeNext(context);
        return true;
    }

    public  Boolean before(Context context,String executor) {
        int step = Integer.parseInt(context.get("STEP","0"));
        System.out.println("*** Workflow Engine: Running [" + executor + "] - Step: [" + step + "]");
        context.set("STEP",++step+"");
        return true;
    }

    protected Boolean executeNext(Context context){
        if (next!=null)
            return next.execute(context);
        return null;
    }

}
