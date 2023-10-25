package com.github.diegopacheco.loopspocs.recursion;

public class RecursionStyle {
    public static void main(String[] args) {
        doLoop();
    }

    private static void doLoop() {
        doLoopRecur(0);
    }

    private static void doLoopRecur(int i) {
        if (i<100){
            doLoopRecur(++i);
        }else{
            System.out.println("total is " + i);
        }
    }

}
