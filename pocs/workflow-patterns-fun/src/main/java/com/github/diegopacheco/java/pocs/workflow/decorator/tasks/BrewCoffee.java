package com.github.diegopacheco.java.pocs.workflow.decorator.tasks;

import com.github.diegopacheco.java.pocs.workflow.decorator.Context;
import com.github.diegopacheco.java.pocs.workflow.decorator.Task;
public class BrewCoffee extends BaseTask {

    public BrewCoffee(){
        super(null);
    }

    public BrewCoffee(Task next) {
        super(next);
    }

    @Override
    public  Boolean execute(Context context) {
        before(context,this.getClass().getSimpleName());

        System.out.println("Pouring water on the coffee. Brewing baby! ");
        after(context);

        return true;
    }
}
