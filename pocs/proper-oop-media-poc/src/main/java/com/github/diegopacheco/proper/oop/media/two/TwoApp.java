package com.github.diegopacheco.proper.oop.media.two;

public class TwoApp {
    public static void main(String[] args) {
        Profile john = new Profile(
                "John", "Doe", "555-1111-111",
                "123 main st, Main City MS",
                "@johndoe", "johndoe");

        Media json = new JsonMedia(john.toMedia());
        System.out.println(json);
    }
}
