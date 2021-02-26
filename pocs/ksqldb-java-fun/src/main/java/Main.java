import io.confluent.ksql.api.client.Client;
import io.confluent.ksql.api.client.ClientOptions;
import io.confluent.ksql.api.client.Row;
import io.confluent.ksql.api.client.StreamedQueryResult;

public class Main {
    public static String KSQLDB_SERVER_HOST = "localhost";
    public static int KSQLDB_SERVER_HOST_PORT = 8088;

    public static void main(String[] args) throws Exception{
        ClientOptions options = ClientOptions.create()
                .setHost(KSQLDB_SERVER_HOST)
                .setPort(KSQLDB_SERVER_HOST_PORT);
        Client client = Client.create(options);

        String pushQuery = "SELECT * FROM MY_STREAM EMIT CHANGES;";
        StreamedQueryResult streamedQueryResult = client.streamQuery(pushQuery).get();
        for (int i = 0; i < 5; i++) {
            // Block until a new row is available
            Row row = streamedQueryResult.poll();
            if (row != null) {
                System.out.println("Received a row!");
                System.out.println("Row: " + row.values());
            } else {
                System.out.println("Query has ended.");
            }
        }

        // Terminate any open connections and close the client
        client.close();
    }
}
