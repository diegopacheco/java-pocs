import java.sql.*;
import java.util.Properties;

public class Main{
  public static void main(String args[]) throws Exception{
    Class.forName("org.duckdb.DuckDBDriver");
    Connection conn = DriverManager.getConnection("jdbc:duckdb:");
    Properties ro_prop = new Properties();
    ro_prop.setProperty("duckdb.read_only", "false");
    Connection conn_ro = DriverManager.getConnection("jdbc:duckdb:/tmp/my_database", ro_prop);

    // create a table
    Statement stmt = conn.createStatement();
    stmt.execute("CREATE TABLE items (item VARCHAR, value DECIMAL(10,2), count INTEGER)");
    // insert two items into the table
    stmt.execute("INSERT INTO items VALUES ('jeans', 20.0, 1), ('hammer', 42.2, 2)");

    PreparedStatement p_stmt = conn.prepareStatement("INSERT INTO items VALUES (?, ?, ?);");
    p_stmt.setString(1, "chainsaw");
    p_stmt.setDouble(2, 500.0);
    p_stmt.setInt(3, 42);
    p_stmt.execute();
    // more calls to execute() possible
    p_stmt.close();

    ResultSet rs = stmt.executeQuery("SELECT * FROM items");
    while (rs.next()) {
      System.out.println(rs.getString(1));
      System.out.println(rs.getInt(3));
    }
    rs.close();
    // jeans
    // 1
    // hammer
    // 2

  }
}
