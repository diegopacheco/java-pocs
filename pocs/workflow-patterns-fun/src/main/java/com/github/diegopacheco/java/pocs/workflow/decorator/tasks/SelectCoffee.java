package com.github.diegopacheco.java.pocs.workflow.decorator.tasks;

import com.github.diegopacheco.java.pocs.workflow.decorator.Context;
import com.github.diegopacheco.java.pocs.workflow.decorator.Task;

public class SelectCoffee extends BaseTask {

    public SelectCoffee(){
        super(null);
    }

    public SelectCoffee(Task next) {
        super(next);
    }

    public Boolean execute(Context context) {
        before(context,this.getClass().getSimpleName());
        System.out.println("Selecting coffee: " + context.get("COFFEE_TYPE") );
        executeNext(context);
        return true;
    }
}
