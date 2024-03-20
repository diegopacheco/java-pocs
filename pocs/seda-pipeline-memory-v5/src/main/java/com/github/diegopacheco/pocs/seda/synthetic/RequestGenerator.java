package com.github.diegopacheco.pocs.seda.synthetic;

import com.github.diegopacheco.pocs.seda.seda.SEDAManager;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RequestGenerator {

    public <T> List<String> generate(int amount){
        IntStream intStream = IntStream.range(0, amount);
        List<String> events = intStream.mapToObj((i)->name()).toList();
        return events;
    }

    private String name(){
        String[] names = new String[]{"Leonardo_","Donatello_","Raphaello_","michelangelo_","Splinter_","CONAN_","THE_CAT_","BabyShark_","Ryu_"};
        Random r = new Random();
        int result = r.nextInt(9-1) + 1;
        return names[result] + (r.nextInt(5000) + 1);
    }

}
