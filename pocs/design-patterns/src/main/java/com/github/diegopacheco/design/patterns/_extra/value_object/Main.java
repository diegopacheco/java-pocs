package com.github.diegopacheco.design.patterns._extra.value_object;

public class Main {
    public static void main(String[] args) {
        Money money1k  = Money.valueOf(1000D);
        Money money1k2 = Money.valueOf(1000D);
        System.out.println(money1k);
        System.out.println(money1k2);
        System.out.println(money1k.equals(money1k2));
    }
}
