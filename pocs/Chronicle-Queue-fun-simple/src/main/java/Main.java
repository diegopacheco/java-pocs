import net.openhft.chronicle.queue.ChronicleQueue;
import net.openhft.chronicle.queue.ExcerptAppender;
import net.openhft.chronicle.wire.DocumentContext;

// --add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.lang.reflect=ALL-UNNAMED --add-exports=java.base/sun.nio.ch=ALL-UNNAMED --add-exports java.base/jdk.internal.ref=ALL-UNNAMED
public class Main {
    public static void main(String args[]) {
        long init = System.currentTimeMillis();

        final MarketData marketData = new MarketData();
        final ChronicleQueue q = ChronicleQueue.single("market-data");
        final ExcerptAppender appender = q.acquireAppender();

        for (long i = 0; i < 1000 /*1e9*/; i++) {
            try (final DocumentContext document = appender.acquireWritingDocument(false)) {
                document.wire()
                        .bytes()
                        .writeObject(MarketData.class,MarketData.recycle(marketData));
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("done - 1K items WOW in: " + (end - init) + " ms");
    }
}
