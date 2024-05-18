package com.github.diegopacheco.jeps;

public class StringTemplates {
    public static void run(){
        System.out.println("459: String Templates (Second Preview)");

        String name = "McLovin";
        String info = STR."My name is \{name}";
        assert info.equals("My name is McLovin");   // true
        System.out.println(info);
    }
}
