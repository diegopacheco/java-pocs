import java.io.File;
import java.sql.*;

public class Main {
    public static void main(String args[]) throws Exception {

        Class.forName("org.duckdb.DuckDBDriver");
        Connection conn = DriverManager.getConnection("jdbc:duckdb:");

        Statement stmt = conn.createStatement();
        stmt.execute("CREATE TABLE items (item VARCHAR, value DECIMAL(10, 2), count INTEGER)");
        stmt.execute("INSERT INTO items VALUES ('jeans', 20.0, 1), ('hammer', 42.2, 2)");
        queryAll(stmt);

        try (PreparedStatement p_stmt = conn.prepareStatement("INSERT INTO items VALUES (?, ?, ?);")) {
            p_stmt.setString(1, "chainsaw");
            p_stmt.setDouble(2, 500.0);
            p_stmt.setInt(3, 42);
            p_stmt.execute();
        }
        queryAll(stmt);

        String path = new File(".").getCanonicalPath() + "/src/main/resources/";
        stmt.execute("CREATE TABLE new_tbl AS SELECT * FROM read_json_auto('" + path + "state-city.json');");
        queryAllJson(stmt);
    }

    private static void queryAll(Statement stmt) throws Exception{
        System.out.println("----");
        try (ResultSet rs = stmt.executeQuery("SELECT * FROM items")) {
            while (rs.next()) {
                System.out.println(rs.getString(1) + " - " + rs.getInt(3));
            }
        }
    }

    private static void queryAllJson(Statement stmt) throws Exception{
        System.out.println("----");
        try (ResultSet rs = stmt.executeQuery("SELECT * FROM new_tbl")) {
            while (rs.next()) {
                for(int i=1;i<rs.getMetaData().getColumnCount();i++){
                    System.out.println("State: " + rs.getMetaData().getColumnName(i));
                    System.out.println("Cities: ");
                    System.out.println(rs.getString(rs.getMetaData().getColumnName(i)));
                }
            }
        }
    }

}

