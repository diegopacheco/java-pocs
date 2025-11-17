import java.lang.StableValue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

public class StableCounters {
    private static final Supplier<StableCounters> INSTANCE =
        StableValue.supplier(StableCounters::new);

    private final Supplier<AtomicLong> successCounter;
    private final Supplier<AtomicLong> errorCounter;

    private StableCounters() {
        this.successCounter = StableValue.supplier(AtomicLong::new);
        this.errorCounter = StableValue.supplier(AtomicLong::new);
    }

    public static StableCounters getInstance() {
        return INSTANCE.get();
    }

    public void incrementSuccess() {
        successCounter.get().incrementAndGet();
    }

    public void incrementError() {
        errorCounter.get().incrementAndGet();
    }

    public long getSuccessCount() {
        return successCounter.get().get();
    }

    public long getErrorCount() {
        return errorCounter.get().get();
    }

    public String getStats() {
        return "Success: " + getSuccessCount() + ", Errors: " + getErrorCount();
    }
}
