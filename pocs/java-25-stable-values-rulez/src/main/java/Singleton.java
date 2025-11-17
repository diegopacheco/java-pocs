import java.lang.StableValue;
import java.util.function.Supplier;

public class Singleton {
    private static final Supplier<Singleton> INSTANCE =
        StableValue.supplier(() -> new Singleton());

    private final String id;

    private Singleton() {
        this.id = "Singleton-" + System.nanoTime();
    }

    public static Singleton getInstance() {
        return INSTANCE.get();
    }

    public String getId() {
        return id;
    }
}
