package com.github.diegopacheco.j22.jeps;

import java.util.Arrays;

public class UnnamedVariablePatterns {

    static int count(Iterable<String> orders) {
        int total = 0;
        for (String _ : orders)    // Unnamed variable
            total++;
        return total;
    }

    public static void run() {
        System.out.println("456: Unnamed Variables & Patterns");

        Iterable<String> orders = Arrays.asList("A", "B", "C");
        int result = count(orders);
        System.out.println(result);
    }

}
