package com.github.diegopacheco.java.pocs.workflow.chain.tasks;

import com.github.diegopacheco.java.pocs.workflow.chain.Context;
import com.github.diegopacheco.java.pocs.workflow.chain.Task;

public class BrewCoffee implements Task {
    @Override
    public Class<Task> next() {
        return null; // the End;
    }

    @Override
    public Boolean execute(Context context) {
        System.out.println("Pouring water on the coffee. Brewing baby! ");
        return true;
    }
}
