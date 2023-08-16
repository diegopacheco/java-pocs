package com.github.diegopacheco.stockmatcherengine.generators;

import com.github.diegopacheco.stockmatcherengine.predicates.Equal;
import com.github.diegopacheco.stockmatcherengine.predicates.GreaterThan;
import com.github.diegopacheco.stockmatcherengine.predicates.LessThan;
import com.github.diegopacheco.stockmatcherengine.predicates.Predicate;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static com.github.diegopacheco.stockmatcherengine.generators.Randomizer.symbol;
import static com.github.diegopacheco.stockmatcherengine.generators.Randomizer.value;

public class UserPredicatesGenerator implements PredicateGenerator{

    @Override
    public List<Predicate> generate(int amount) {
        IntStream intStream = IntStream.range(0, amount);
        List<Predicate> predicates = intStream.mapToObj((i) -> {
            return create();
        }).toList();
        return predicates;
    }

    private Predicate create(){
        Random r = new Random();
        int result = r.nextInt(3-1) + 1;
        Predicate predicate = null;
        switch (result){
            case 1:
                predicate = new Equal(symbol(),value());
                break;
            case 2:
                predicate = new LessThan(symbol(),value());
                break;
            default:
                predicate = new GreaterThan(symbol(),value());
        }
        return predicate;
    }

}
