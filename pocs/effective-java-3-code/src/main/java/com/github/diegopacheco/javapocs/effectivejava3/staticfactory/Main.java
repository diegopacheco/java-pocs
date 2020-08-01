package com.github.diegopacheco.javapocs.effectivejava3.staticfactory;

public class Main {
    public static void main(String[] args) {
        Money ten = Money.valueOf(10D);
        System.out.println(ten);

        Status s = Status.from("off");
        System.out.println(s);
    }
}
