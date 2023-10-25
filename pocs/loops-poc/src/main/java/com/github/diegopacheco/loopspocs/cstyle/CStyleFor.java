package com.github.diegopacheco.loopspocs.cstyle;

public class CStyleFor {
    public static void main(String[] args) {
        doubleVar();
        infiniteLoop();
    }

    private static void doubleVar() {
        int count=0;
        int x=0;
        for(int i=0;i<100;i++,x++){
            count++;
        }
        System.out.println("total is " + count);
    }

    private static void infiniteLoop() {
        int count=0;
        for(;;){
            count++;
            if (count==100) break;
        }
        System.out.println("total is " + count);
    }
}
