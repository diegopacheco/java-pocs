import xtdb.api.*;
import xtdb.api.tx.Transaction;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import static xtdb.api.tx.Transaction.buildTx;

public class Main {

    public static void main(String[] args) throws Exception {
        try (IXtdb node = IXtdb.startNode()) {
            System.out.println("XTDB started with in-memory storage");

            System.out.println("Writing initial data...");
            writeInitialData(node);
            Thread.sleep(2000);

            System.out.println("Updating data...");
            updateData(node);
            Thread.sleep(2000);

            System.out.println("Querying current state...");
            queryCurrentState(node);

            System.out.println("Time travel queries...");
            queryHistoricalData(node);
        }
    }

    private static void writeInitialData(IXtdb node) throws Exception {
        Transaction tx = buildTx(txOps -> {
            txOps.put(XtdbDocument.create("user-1", Map.of(
                "name", "Alice",
                "age", 30,
                "city", "New York"
            )));
            txOps.put(XtdbDocument.create("user-2", Map.of(
                "name", "Bob",
                "age", 25,
                "city", "San Francisco"
            )));
        });

        TransactionInstant txResult = node.submitTx(tx);
        node.awaitTx(txResult, Duration.ofSeconds(10));
        System.out.println("Initial data written at: " + txResult);
    }

    private static void updateData(IXtdb node) throws Exception {
        Transaction tx = buildTx(txOps -> {
            txOps.put(XtdbDocument.create("user-1", Map.of(
                "name", "Alice",
                "age", 31,
                "city", "Boston"
            )));
        });

        TransactionInstant txResult = node.submitTx(tx);
        node.awaitTx(txResult, Duration.ofSeconds(10));
        System.out.println("Data updated at: " + txResult);
    }

    private static void queryCurrentState(IXtdb node) {
        IXtdbDatasource db = node.db();
        var results = new ArrayList<>(db.query(
                "[:find ?name ?age ?city :where " +
                        "[?e :name ?name]" +
                        " [?e :age ?age]" +
                        " [?e :city ?city]]"));

        System.out.println("Current state:");
        results.forEach(row -> System.out.println("  " + row));
    }

    private static void queryHistoricalData(IXtdb node) {
        Date threeSecondsAgo = Date.from(Instant.now().minusSeconds(3));
        IXtdbDatasource historicalDb = node.db(threeSecondsAgo);

        var results = new ArrayList<>(
                historicalDb.query("[:find ?name ?age ?city" +
                        " :where [?e :name ?name]" +
                        " [?e :age ?age] [?e :city ?city]]"));

        System.out.println("Historical state (3 seconds ago):");
        results.forEach(row -> System.out.println("  " + row));

        Object aliceEntity = node.db().entity("user-1");
        System.out.println("Current Alice: " + aliceEntity);

        Object aliceHistorical = historicalDb.entity("user-1");
        System.out.println("Historical Alice: " + aliceHistorical);
    }
}
