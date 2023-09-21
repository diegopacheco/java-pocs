package com.github.diegopacheco.javapocs.features21.stringtemplate;

import static java.lang.StringTemplate.STR;

public class StringTemplateMain {
    public static void main(String[] args) {
        var n = "John Doe 21";
        String info = STR."My name is \{n}";
        System.out.println(info);

        int x = 10, y = 20;
        String s = STR."\{x} + \{y} = \{x + y}";
        System.out.println(s);

        String name    = "Joan Smith";
        String phone   = "555-123-4567";
        String address = "1 Maple Drive, Anytown";
        String json = STR."""
        {
            "name":    "\{name}",
            "phone":   "\{phone}",
            "address": "\{address}"
        }
        """;
        System.out.println(json);
    }
}
