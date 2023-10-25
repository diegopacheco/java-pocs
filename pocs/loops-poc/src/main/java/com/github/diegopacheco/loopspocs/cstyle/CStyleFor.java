package com.github.diegopacheco.loopspocs.cstyle;

import java.util.Arrays;

public class CStyleFor {
    public static void main(String[] args) {
        doubleVar();
        infiniteLoop();
        comprehension();
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

    private static void comprehension() {
        int c=0;
        for(
                int count = Arrays.asList(0,1,2,3,4,5,6,7,8,9).size() * 10,
                x = 2,
                z = 3
                ;
                count >=0
                ;
                count--,
                x += add10(),
                z = make4()
        ){
            c++;
            System.out.println("x " + x + " z " + z + " c " + c);
        }
        System.out.println("total is " + c);
    }

    private static int add10() {
        return 10;
    }

    private static int make4() {
        return 4;
    }

}
