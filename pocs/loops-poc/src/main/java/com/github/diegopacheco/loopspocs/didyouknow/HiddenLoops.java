package com.github.diegopacheco.loopspocs.didyouknow;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class HiddenLoops {
    public static void main(String[] args) {
        hidden1();
        hidden2();
    }

    private static void hidden1() {
        List<Integer> list = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10);
        System.out.println(new HashSet<>(list));
    }

    private static void hidden2() {
        List<Integer> list = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10);
        System.out.println(list.toString());
    }


}
