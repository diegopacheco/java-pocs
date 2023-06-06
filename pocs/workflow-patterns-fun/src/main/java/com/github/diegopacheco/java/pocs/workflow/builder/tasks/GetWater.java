package com.github.diegopacheco.java.pocs.workflow.builder.tasks;

import com.github.diegopacheco.java.pocs.workflow.builder.Context;
import com.github.diegopacheco.java.pocs.workflow.builder.Task;

public class GetWater implements Task {
    public Boolean execute(Context context) {
        System.out.println("Getting water. Boiling water. ");
        return true;
    }
}
