package com.github.diegopacheco.javapocs.effectivejava3.builder;

public class Main {
    public static void main(String[] args) {
        DBConfiguration config =
                new DBConfiguration.Builder(3306,"localhost").
                        withAZ("us-west-1").
                        withEngine("Postgres").
                        build();

        System.out.println(config);
    }
}
