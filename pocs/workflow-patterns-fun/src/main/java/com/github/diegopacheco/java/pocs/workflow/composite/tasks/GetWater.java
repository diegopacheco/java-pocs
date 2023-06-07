package com.github.diegopacheco.java.pocs.workflow.composite.tasks;


import com.github.diegopacheco.java.pocs.workflow.composite.Context;
import com.github.diegopacheco.java.pocs.workflow.composite.Task;

public class GetWater  implements Task {
    @Override
    public Boolean execute(Context context) {
        System.out.println("Getting water. Boiling water. ");
        return true;
    }
}
