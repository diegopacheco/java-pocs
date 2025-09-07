package com.github.diegopacheco.fp;

public class Immutability {

    record User(String id, String name) { }

    public int result() {
        User user = new User("1", "Diego");
         //user.id = "2"; // This line would cause a compilation error because records are immutable
        return user.id().length();
    }


}
