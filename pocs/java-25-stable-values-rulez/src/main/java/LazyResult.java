import java.lang.StableValue;
import java.util.function.Supplier;

public class LazyResult<T> {
    private final Supplier<T> value;

    public LazyResult(Supplier<T> computation) {
        this.value = StableValue.supplier(computation);
    }

    public T get() {
        return value.get();
    }

    public static <T> LazyResult<T> of(Supplier<T> computation) {
        return new LazyResult<>(computation);
    }
}
