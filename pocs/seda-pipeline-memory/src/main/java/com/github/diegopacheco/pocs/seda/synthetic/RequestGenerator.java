package com.github.diegopacheco.pocs.seda.synthetic;

import com.github.diegopacheco.pocs.seda.queue.QueueManager;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RequesterGenerator {

    public <T> void generate(int amount, QueueManager<T> queue){
        IntStream intStream = IntStream.range(0, amount);
        List<String> events = intStream.mapToObj((i)->name()).toList();
        for (String event: events){
            queue.publish((T)event);
        }
    }

    private String name(){
        String[] names = new String[]{"Leonardo_","Donatello_","Raphaello_","michelangelo_","Splinter_","CONAN_","THE_CAT_","BabyShark_","Ryu_"};
        Random r = new Random();
        int result = r.nextInt(9-1) + 1;
        return names[result];
    }

}
