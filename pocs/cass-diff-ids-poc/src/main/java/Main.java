import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.querybuilder.insert.Insert;
import com.datastax.oss.driver.api.querybuilder.select.Select;

import java.util.function.Consumer;

import static com.datastax.oss.driver.api.querybuilder.QueryBuilder.*;

public class Main {

    public static void main(String args[]) {
        bench((Void) -> {
            insertData("Test");
            insertData("Test2");
        },"Data Insert");
        bench((Void) -> {
            count();
        },"Diff IDS");
    }

    private static void insertData(String table) {
        try (CqlSession session = CqlSession.builder().build()) {
            session.execute("USE CLUSTER_TEST");

            Insert insert = insertInto(table)
                    .value("key", literal("k"))
                    .value("value", literal("V")).ifNotExists();
            ResultSet rs = session.execute(insert.build());
            System.out.println(rs.wasApplied());
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
