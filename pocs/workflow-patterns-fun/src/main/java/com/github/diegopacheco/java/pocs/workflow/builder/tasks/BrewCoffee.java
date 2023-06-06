package com.github.diegopacheco.java.pocs.workflow.builder.tasks;

import com.github.diegopacheco.java.pocs.workflow.builder.Context;
import com.github.diegopacheco.java.pocs.workflow.builder.Task;

public class BrewCoffee implements Task {
    @Override
    public  Boolean execute(Context context) {
        System.out.println("Pouring water on the coffee. Brewing baby! ");
        return true;
    }
}
