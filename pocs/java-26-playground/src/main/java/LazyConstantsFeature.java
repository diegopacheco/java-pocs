/**
 * JEP 526: Lazy Constants (Second Preview)
 * Provides LazyConstant for deferred immutable initialization computed at most once.
 * @see <a href="https://openjdk.org/jeps/526">JEP 526</a>
 */
import java.lang.LazyConstant;

public class LazyConstantsFeature {
    private static final LazyConstant<String> LAZY_VALUE = LazyConstant.of(() -> {
        System.out.println("  Computing lazy value...");
        return "Hello from LazyConstant!";
    });

    private static final LazyConstant<Integer> LAZY_NUMBER = LazyConstant.of(() -> {
        System.out.println("  Computing lazy number...");
        return 42;
    });

    public static void run() {
        System.out.println("Lazy Constants Feature:");
        System.out.println("  Before first access - value not yet computed");
        System.out.println("  First access: " + LAZY_VALUE.get());
        System.out.println("  Second access (no recomputation): " + LAZY_VALUE.get());
        System.out.println("  Lazy number: " + LAZY_NUMBER.get());
    }
}
