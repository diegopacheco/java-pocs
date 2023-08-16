import com.github.diegopacheco.stockmatcherengine.engine.InMemoryMatcher;
import com.github.diegopacheco.stockmatcherengine.engine.MaterializedMatch;
import com.github.diegopacheco.stockmatcherengine.event.Event;
import com.github.diegopacheco.stockmatcherengine.generators.EventGenerator;
import com.github.diegopacheco.stockmatcherengine.generators.NasdaqEventGenerator;
import com.github.diegopacheco.stockmatcherengine.generators.UserPredicatesGenerator;
import com.github.diegopacheco.stockmatcherengine.predicates.Predicate;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

public class Main {
    public static void main(String args[]) {

        System.out.println(">> Benchmarks: CAP 100 rules ");
        benchmarkCap(10,100);
        benchmarkCap(100,100);
        benchmarkCap(1_000,100);
        benchmarkCap(10_000,100);
        benchmarkCap(100_000,100);
        benchmarkCap(1_000_000,100);
        benchmarkCap(10_000_000,100);

        System.out.println(">> Benchmarks: NO CAP (rules x events) ");
        benchmark(10);
        benchmark(100);
        benchmark(1_000);
        benchmark(10_000);
        benchmark(100_000);
    }

    private static void benchmark(int amount) {
       benchmarkCap(amount,amount);
    }

    private static void benchmarkCap(int amountEvents,int amountRules) {
        UserPredicatesGenerator predicatesGenerator = new UserPredicatesGenerator();
        List<Predicate> predicates = predicatesGenerator.generate(amountRules);

        EventGenerator eventGenerator = new NasdaqEventGenerator();
        List<Event> events = eventGenerator.generate(amountEvents);

        InMemoryMatcher matcher = new InMemoryMatcher(predicates);

        Instant start = Instant.now();
        List<MaterializedMatch> matches = matcher.run(events);
        Instant end = Instant.now();
        System.out.println("Matching " + amountEvents + " events / " + amountRules + " predicates resulted in: [" + matches.size() +
                "] match in " + (Duration.between(start,end).toMillis()) + " ms");
    }

}
