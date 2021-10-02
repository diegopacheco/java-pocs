package com.github.diegopacheco.functional.inter;

import java.util.Random;

public final class Generators {

    public static final Generator<String> dummyStringGenerator(){
        return (int size) -> {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<size;i++){
                Random random = new Random();
                sb.append((char)(random.nextInt(122 - 97) + 97));
            }
            return sb.toString();
        };
    }

    public static final Generator<Boolean> booleanGenerator(){
        return (int size) -> {
            int result = new Random().nextInt();
            return (result%2==0) ? true : false;
        };
    }

}
