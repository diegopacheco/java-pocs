import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.BatchStatement;
import com.datastax.oss.driver.api.core.cql.BatchType;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.querybuilder.insert.Insert;
import com.datastax.oss.driver.api.querybuilder.select.Select;
import java.util.Date;
import java.util.function.Consumer;

import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.*;

public class Main {

    public static void main(String args[]) {
        bench((Void) -> {
            insertData("Test",1000000);
            insertData("Test2",500000);
        },"Data Insert");
        bench((Void) -> {
            count();
        },"Diff IDS");
    }

    private static void insertData(String table,int records) {
        try (CqlSession session = CqlSession.builder().build()) {
            session.execute("USE CLUSTER_TEST");

            final int batchSize = 1000;
            for(int j=1;j<=records;j+=batchSize){
                for(int i=1;i<=batchSize;i++){
                    Insert insert = insertInto(table)
                            .value("key", literal("k"+(i+j)))
                            .value("value", literal("V"+(i+j))).ifNotExists();

                    BatchStatement batch =
                            BatchStatement.builder(BatchType.LOGGED)
                                    .addStatement(insert.build())
                                    .build();

                    ResultSet rs = session.execute(batch);
                    System.out.println(batchSize + " records created? " + rs.wasApplied() + " " + new Date());
                }
            }
        }
    }

    private static void count() {
        try (CqlSession session = CqlSession.builder().build()) {
            session.execute("USE CLUSTER_TEST");

            Select query = selectFrom("CLUSTER_TEST", "Test2").
                    column("key");
            ResultSet rs = session.execute(query.build());
            System.out.println("Total IDS: " + rs.all().size());
        }
    }

    private static void bench(Consumer<Void> func,String msg) {
        long init = System.currentTimeMillis();
        func.accept(null);
        long end = System.currentTimeMillis();
        System.out.println(msg + " .Executed in > " + (end - init) + " ms.");
    }

}
