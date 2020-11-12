import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.*;
import com.datastax.oss.driver.api.querybuilder.insert.Insert;
import com.datastax.oss.driver.api.querybuilder.select.Select;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.*;

public class Main {

    public static void main(String args[]) {
        cleanup();

        // Insert 1.5M records took 53168 ms (53 seconds)
        bench((Void) -> {
            insertData("Test",1000000);
            insertData("Test2",500000);
        },"Data Insert");

        // Diff 1.5M records took 282554 ms (4.7 minutes)
        bench((Void) -> {
            count();
        },"Diff IDS");
    }

    private static void insertData(String table,int records) {
        SamplePrinter printer = new SamplePrinter();
        try (CqlSession session = CqlSession.builder().build()) {
            session.execute("USE CLUSTER_TEST;");

            final int batchSize = 1000;
            for(int j=1;j<=records;j+=batchSize){

                BatchStatementBuilder batch = BatchStatement.builder(BatchType.UNLOGGED);
                for(int i=1;i<=batchSize;i++){
                    Insert insert = insertInto(table)
                            .value("key", literal("k"+(i+j)))
                            .value("value", literal("V"+(i+j)));
                    batch.addStatement(insert.build());
                }
                ResultSet rs = session.execute(batch.build());
                printer.print(batchSize + " records created? " + rs.wasApplied() + " " + new Date());
            }
        }
    }

    private static void count() {
        try (CqlSession session = CqlSession.builder().build()) {
            session.execute("USE CLUSTER_TEST");

            Select baseIDsQuery = selectFrom("CLUSTER_TEST", "Test").
                    column("key");
            ResultSet rsIDs = session.execute(baseIDsQuery.build());
            List<String> ids = rsIDs.
                    all().
                    stream().
                    map(r -> r.get("key",String.class) ).
                    collect(Collectors.toList());

            Select diffQuery = selectFrom("CLUSTER_TEST", "Test2").
                    column("key").
                    whereColumn("key").in(bindMarker());
            PreparedStatement preparedIdsDiff =  session.prepare(diffQuery.build());
            ResultSet rsDiff =  session.execute(preparedIdsDiff.bind(ids).setExecutionProfileName("aggregatedprofile"));
            System.out.println("Total IDS: " + rsDiff.all().size());
        }
    }

    private static void cleanup() {
        try (CqlSession session = CqlSession.builder().build()) {
            session.execute("USE CLUSTER_TEST; TRUNCATE table Test; TRUNCATE table Test2;");
        }
    }

    private static void bench(Consumer<Void> func,String msg) {
        long init = System.currentTimeMillis();
        func.accept(null);
        long end = System.currentTimeMillis();
        System.out.println(msg + " .Executed in > " + (end - init) + " ms.");
    }

    private static  class SamplePrinter {
        private Instant watermark = Instant.now();
        public void print(String msg){
            Instant now = Instant.now();
            Duration delta = Duration.between(watermark, now);
            if (delta.getSeconds()>=30){
                System.out.println(msg);
                watermark = Instant.now();
            }
        }
    }
}
