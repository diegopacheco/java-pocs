import java.sql.*;

public class Main {
    static int query(String url, String user, String password, String table) throws SQLException {
        String sql = "select * from " + table + " limit 10";
        System.out.println(sql);
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            int count = 0;
            while (rs.next()) {
                count++;
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
            }
            return count;
        }
    }

    public static void main(String[] args) {
        String url = "jdbc:proton://localhost:8123";
        String user = System.getProperty("user", "default");
        String password = System.getProperty("password", "");
        String table = "devices";

        try {
            query(url, user, password, table);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
