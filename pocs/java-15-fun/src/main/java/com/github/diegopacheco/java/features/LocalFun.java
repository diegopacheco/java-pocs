package com.github.diegopacheco.java.features;

public class LocalFun {
    public static void main(String[] args) {
        interface LocalInterface {
            void callMeMaybe();
        }
        class X implements LocalInterface{
            @Override
            public void callMeMaybe() {
                System.out.println("ok baby");
            }
        }
        new X().callMeMaybe();

        enum Color {RED, YELLOW, BLUE}
        System.out.println(Color.BLUE);
    }
}
