import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.function.Consumer;

public class Main {
    public static void main(String args[]) {
        // 1.5M records, took 3 minutes to insert them.
        /*
        benchIt((Void) -> {
            insertBatch(1000000, "Test");
            insertBatch(500000, "Test2");
        });
        */
        benchIt((Void) -> {
                    diff();
                });
        System.out.println("FIN.");
    }

    private static int diff() {
        try {
            try (Connection cnn = HikariDS.getConnection();) {
                Statement stmt = cnn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT Test.k\n" +
                        "FROM Test\n" +
                        "    LEFT JOIN Test2 ON (Test.k = Test2.k)\n" +
                        "WHERE Test2.k IS NULL");
                int i = 0;
                while(rs.next()) {
                    i++;
                }
                System.out.println("Diff size: " + i);
                return i;
            }
        } catch (Exception e) {
            System.out.println("Could not get the diff. Exception: " + e);
            return -1;
        }
    }

    public static void insertBatch(int total, String table) {
        final int BATCH_SIZE = 10000;
        try {
            try (Connection cnn = HikariDS.getConnection();) {
                for (int i = 1; i <= total; i += BATCH_SIZE) {
                    Statement stmt = cnn.createStatement();
                    cnn.setAutoCommit(false);
                    for (int j = 1; j <= BATCH_SIZE; j++) {
                        stmt.addBatch("REPLACE into " + table + " values ('k" + i + j + "','v" + i + j + "')");
                    }
                    int[] result = stmt.executeBatch();
                    System.out.println("The number of rows inserted: " + result.length);
                    cnn.commit();
                }
            }
        } catch (Exception e) {
            System.out.println("Could not insert this batch. Exception: " + e);
        }
    }

    private static void benchIt(Consumer<Void> func) {
        long init = System.currentTimeMillis();
        func.accept(null);
        long end = System.currentTimeMillis();
        System.out.println("Executed in: " + (end - init) + " ms.");
    }

}
