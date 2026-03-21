/**
 * JEP 525: Structured Concurrency (Sixth Preview)
 * Enforces hierarchical task-subtask relationships with automatic cancellation and error propagation.
 * @see <a href="https://openjdk.org/jeps/525">JEP 525</a>
 */
import java.util.concurrent.StructuredTaskScope;
import java.util.function.Supplier;

public class StructuredConcurrencyFeature {
    public static void run() throws Exception {
        try (var scope = StructuredTaskScope.open()) {
            Supplier<String> task1 = scope.fork(() -> {
                Thread.sleep(100);
                return "Task-1 done";
            });
            Supplier<String> task2 = scope.fork(() -> {
                Thread.sleep(200);
                return "Task-2 done";
            });
            Supplier<String> task3 = scope.fork(() -> {
                Thread.sleep(150);
                return "Task-3 done";
            });

            scope.join();

            System.out.println("Structured Concurrency Results:");
            System.out.println("  " + task1.get());
            System.out.println("  " + task2.get());
            System.out.println("  " + task3.get());
        }
    }
}
