package com.github.diegopacheco.loopspocs.foreach;

import java.util.Arrays;
import java.util.List;

public class ForEachStyle {
    public static void main(String[] args) {
        List<Integer> total = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10);
        for(int i : total){
            System.out.println(i);
        }
    }
}
