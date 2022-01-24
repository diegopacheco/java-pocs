import net.openhft.chronicle.queue.ChronicleQueue;
import net.openhft.chronicle.queue.ExcerptTailer;
import net.openhft.chronicle.wire.DocumentContext;

// --add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.lang.reflect=ALL-UNNAMED --add-exports=java.base/sun.nio.ch=ALL-UNNAMED --add-exports java.base/jdk.internal.ref=ALL-UNNAMED
public class ReadeRMain {
    public static void main(String[] args) {
        final ChronicleQueue q = ChronicleQueue.single("market-data");
        final ExcerptTailer tailer = q.createTailer();
        for (long i = 0; i < 2; i++) {
            try (final DocumentContext document = tailer.readingDocument()) {
                MarketData m = document
                        .wire()
                        .bytes()
                        .readObject(MarketData.class);
                System.out.println(m);
            }
        }
    }
}
