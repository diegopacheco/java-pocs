package com.github.diegopacheco.loopspocs.whilestyle;

public class DoWhileStyle {
    public static void main(String[] args) {
        int i=0;
        int count=0;
        do {
            count++;
            i++;
        } while(i<100);
        System.out.println("total is " + count);
    }
}
