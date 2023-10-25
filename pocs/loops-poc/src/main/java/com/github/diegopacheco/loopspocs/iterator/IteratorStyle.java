package com.github.diegopacheco.loopspocs.iterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorStyle {
    public static void main(String[] args) {
        List<Integer> items = Arrays.asList(0,1,2,3,4,5,6,7,8,9,10);
        Iterator<Integer> it = items.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
