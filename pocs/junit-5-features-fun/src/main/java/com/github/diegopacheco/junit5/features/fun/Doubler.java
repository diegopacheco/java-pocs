package com.github.diegopacheco.junit5.features.fun;

public class Doubler {
    public static int doubleIt(int i){
        return  i * 2;
    }
    public static void throwMeExceptionPls(){
        throw new RuntimeException("Oopise something went wrong.");
    }
}