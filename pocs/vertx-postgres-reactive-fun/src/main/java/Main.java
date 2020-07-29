import io.vertx.pgclient.PgConnectOptions;
import io.vertx.pgclient.PgPool;
import io.vertx.sqlclient.PoolOptions;
import io.vertx.sqlclient.Row;
import io.vertx.sqlclient.RowSet;

public class Main {
    public static void main(String args[]) throws Exception {
        PgConnectOptions connectOptions = new PgConnectOptions()
                .setPort(5432)
                .setHost("127.0.0.1")
                .setDatabase("db")
                .setUser("root")
                .setPassword("root");

        PoolOptions poolOptions = new PoolOptions().setMaxSize(5);
        PgPool client = PgPool.pool(connectOptions, poolOptions);

        client
                .query("SELECT * FROM users WHERE id=1")
                .execute(ar -> {
                    if (ar.succeeded()) {
                        RowSet<Row> result = ar.result();
                        System.out.println("Got " + result.size() + " rows ");
                        for(Row row : result){
                            System.out.println("ID: " + row.getInteger("id"));
                            System.out.println("NAME: " + row.getString("name"));
                        }
                    } else {
                        System.out.println("Failure: " + ar.cause().getMessage());
                    }
                    client.close();
                });

        Thread.sleep(3000L);
        System.out.println("DONE");
    }
}
