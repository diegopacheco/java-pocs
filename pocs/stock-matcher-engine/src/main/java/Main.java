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
        benchmark(10);
        benchmark(100);
        benchmark(1_000);
        benchmark(10_000);
        benchmark(100_000);
    }

    private static void benchmark(int amount) {
        UserPredicatesGenerator predicatesGenerator = new UserPredicatesGenerator();
        List<Predicate> predicates = predicatesGenerator.generate(amount);

        EventGenerator eventGenerator = new NasdaqEventGenerator();
        List<Event> events = eventGenerator.generate(amount);

        InMemoryMatcher matcher = new InMemoryMatcher(predicates);

        Instant start = Instant.now();
        List<MaterializedMatch> matches = matcher.run(events);
        Instant end = Instant.now();
        System.out.println("Matching " + amount + " events/predicates resulted in: [" + matches.size() +
                "] match in " + (Duration.between(start,end).toMillis()) + " ms");
    }

}
