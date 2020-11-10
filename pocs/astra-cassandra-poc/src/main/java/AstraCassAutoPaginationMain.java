import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;

import java.nio.file.Paths;
import java.util.Iterator;

public class AstraCassAutoPaginationMain {
    public static void main(String[] args) {

        String username = System.getProperties().getProperty("ASTRA_USER");
        String pass = System.getProperties().getProperty("ASTRA_PASS");
        String bundle = System.getProperties().getProperty("ASTRA_BUNDLE");
        System.out.println("Using user: " + username + " pass: " + pass + " bundle: " + bundle);

        long init = System.currentTimeMillis();

        try (CqlSession session = CqlSession.builder()
                .withCloudSecureConnectBundle(Paths.get(bundle))
                .withAuthCredentials(username,pass)
                .build()) {
            session.execute("USE TEST");

            ResultSet rs = session.execute(QueryBuilder.selectFrom("Test").all().build());
            Iterator<Row> iter = rs.iterator();
            while (iter.hasNext()) {
                Row row = iter.next();
                System.out.println(row.get("key",String.class));
            }
        }
        System.out.println("Executed in " + (System.currentTimeMillis()-init) + " ms");
        System.out.println("FIN.");
    }
}
