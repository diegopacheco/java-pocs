package com.github.diegopacheco.java.pocs.workflow.templatemethod.tasks;

import com.github.diegopacheco.java.pocs.workflow.templatemethod.Context;
import com.github.diegopacheco.java.pocs.workflow.templatemethod.Task;

public class BrewCoffee implements Task {
    @Override
    public Boolean execute(Context context) {
        System.out.println("Pouring water on the coffee. Brewing baby! ");
        return true;
    }
}
