package com.github.diegopacheco.stockmatcherengine.generators;

import com.github.diegopacheco.stockmatcherengine.event.Event;
import com.github.diegopacheco.stockmatcherengine.event.StockDown;
import com.github.diegopacheco.stockmatcherengine.event.StockUp;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static com.github.diegopacheco.stockmatcherengine.generators.Randomizer.symbol;

public class NasdaqEventGenerator implements EventGenerator{

    @Override
    public List<Event> generate(int amount) {
        IntStream intStream = IntStream.range(0, amount);
        List<Event> events = intStream.mapToObj((i) -> {
            return create();
        }).toList();
        return events;
    }

    private Event create(){
        Random r = new Random();
        int result = r.nextInt(2-0) + 1;
        if (result==1){
            return new StockUp(symbol(),Randomizer.value());
        }else{
            return new StockDown(symbol(),Randomizer.value());
        }
    }

}
