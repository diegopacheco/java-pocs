package com.github.diegopacheco.javapocs.features21.sequecendcollections;

import java.util.*;

public class SCMain {
    public static void main(String[] args) {
        SequencedMap<String,String> sm = new LinkedHashMap<>();
        sm.put("A","A");
        sm.put("B","B");
        sm.put("C","C");
        System.out.println(sm.firstEntry());
        System.out.println(sm.lastEntry());

        sm.putFirst("Z","Z");
        System.out.println(sm.firstEntry());
        System.out.println(sm.lastEntry());

        SequencedCollection<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println(list.getFirst());
        System.out.println(list.getLast());
    }
}
