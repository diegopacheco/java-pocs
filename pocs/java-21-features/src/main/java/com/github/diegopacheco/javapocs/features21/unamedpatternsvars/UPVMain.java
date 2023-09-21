package com.github.diegopacheco.javapocs.features21.unamedpatternsvars;

import java.util.LinkedList;
import java.util.Queue;

//
// Error: LinkageError occurred while loading main class com.github.diegopacheco.javapocs.features21.unamedpatternsvars.UPVMain
//	java.lang.ClassFormatError: Illegal field name "" in class com/github/diegopacheco/javapocs/features21/unamedpatternsvars/UPVMain
//
public class UPVMain {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        while (q.size() >= 3) {
            var x = q.remove();
            var y = q.remove();
            var _ = q.remove();
            System.out.println(x);
            System.out.println(y);
        }
    }
}
