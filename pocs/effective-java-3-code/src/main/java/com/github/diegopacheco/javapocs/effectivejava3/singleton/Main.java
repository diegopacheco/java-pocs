package com.github.diegopacheco.javapocs.effectivejava3.singleton;

public class Main {
    public static void main(String[] args) {
        Singleton s = Singleton.getInstance();
        System.out.println(s);
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance());
    }
}
