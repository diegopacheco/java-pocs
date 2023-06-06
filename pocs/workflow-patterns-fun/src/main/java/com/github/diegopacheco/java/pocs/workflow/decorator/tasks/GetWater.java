package com.github.diegopacheco.java.pocs.workflow.decorator.tasks;

import com.github.diegopacheco.java.pocs.workflow.decorator.Context;
import com.github.diegopacheco.java.pocs.workflow.decorator.Task;

public class GetWater extends BaseTask {

    public GetWater() {
        super(null);
    }

    public GetWater(Task next) {
        super(next);
    }

    public Boolean execute(Context context) {
        before(context,this.getClass().getSimpleName());
        System.out.println("Getting water. Boiling water. ");
        executeNext(context);
        return true;
    }
}
