package com.github.diegopacheco.java.pocs.workflow.composite.tasks;

import com.github.diegopacheco.java.pocs.workflow.composite.Context;
import com.github.diegopacheco.java.pocs.workflow.composite.Task;

public class BrewCoffee implements Task {
    @Override
    public Boolean execute(Context context) {
        System.out.println("Pouring water on the coffee. Brewing baby! ");
        return true;
    }
}
