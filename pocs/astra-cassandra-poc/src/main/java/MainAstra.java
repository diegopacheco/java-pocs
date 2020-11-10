import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import java.nio.file.Paths;

public class MainAstra {
  public static void main(String args[]){

    String username = System.getProperties().getProperty("ASTRA_USER");
    String pass = System.getProperties().getProperty("ASTRA_PASS");
    String bundle = System.getProperties().getProperty("ASTRA_BUNDLE");
    System.out.println("Using user: " + username + " pass: " + pass + " bundle: " + bundle);

    try (CqlSession session = CqlSession.builder()
            .withCloudSecureConnectBundle(Paths.get(bundle))
            .withAuthCredentials(username,pass)
            .build()) {
      ResultSet rs = session.execute("select release_version from system.local");
      Row row = rs.one();
      if (row != null) {
        System.out.println(row.getString("release_version"));
      } else {
        System.out.println("An error occurred.");
      }
    }
    System.out.println("FIN.");
  }
}
