package com.github.diegopacheco.hibernate.seq.comparator.diff;

import static org.junit.Assert.assertEquals;

public class Diff {

    private String left;
    private String right;

    private String leftGenerator;
    private String leftOptimizer;

    private String rightGenerator;
    private String rightOptimizer;

    public Diff(String left, String right,
                String leftGenerator,
                String leftOptimizer,
                String rightGenerator,
                String rightOptimizer) {
        this.left = left;
        this.right = right;
        this.leftGenerator = leftGenerator;
        this.leftOptimizer = leftOptimizer;
        this.rightGenerator = rightGenerator;
        this.rightOptimizer = rightOptimizer;
    }

    public void run(){
        System.out.println("***** DIFF ***** ");
        System.out.println(">>> LEFT: generator[" + leftGenerator +"] optimizer["+leftOptimizer+"]");
        System.out.println(left);
        System.out.println("<<< RIGHT: generator[" + rightGenerator +"] optimizer["+rightOptimizer+"]");
        System.out.println(right);
        System.out.println("***** DIFF ***** ");

        assertEquals(left,right);
    }

}
