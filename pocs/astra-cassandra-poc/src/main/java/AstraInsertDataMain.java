import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;

import java.nio.file.Paths;
import java.util.Iterator;

public class AstraInsertDataMain {
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

            for(long i=1;i<=100;i++){
                String value = "k" + i;
                PreparedStatement stmt = session.prepare(
                        QueryBuilder.insertInto("Test").
                                value("key",QueryBuilder.bindMarker()).
                                value("value",QueryBuilder.bindMarker()).
                                ifNotExists().build());
                ResultSet rs = session.execute(stmt.bind(value,value));
                if (!rs.wasApplied()) {
                    System.out.println("ERROR. Record already exists! " + value);
                }
            }
        }
        System.out.println("Executed in " + (System.currentTimeMillis()-init) + " ms");
        System.out.println("FIN.");
    }
}
