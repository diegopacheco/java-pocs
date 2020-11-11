import java.sql.Connection;
import java.sql.Statement;
import java.util.function.Consumer;

public class Main {
    public static void main(String args[]) {
        // 1M records
        benchIt( (Void) -> insertBatch(1000000) );
        System.out.println("FIN.");
    }

    public static void insertBatch(int total) {
        final int BATCH_SIZE=10000;
        try {
            try(Connection cnn = HikariDS.getConnection();){
                for(int i=1; i<=total;i+=BATCH_SIZE){
                    Statement stmt = cnn.createStatement();
                    cnn.setAutoCommit(false);
                    for(int j=1;j<=BATCH_SIZE;j++){
                        stmt.addBatch("REPLACE into Test values ('k" + i+j + "','v" + i+j +"')");
                    }
                    int[] result = stmt.executeBatch();
                    System.out.println("The number of rows inserted: "+ result.length);
                    cnn.commit();
                }
            }
        } catch (Exception e) {
            System.out.println("Could not insert this batch. Exception: " + e);
        }
    }

    private static void benchIt(Consumer<Void> func){
        long init = System.currentTimeMillis();
        func.accept(null);
        long end = System.currentTimeMillis();
        System.out.println("Executed in: " + (end-init) + " ms.");
    }

}
