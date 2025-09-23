
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.parser.SqlParser;

public class Main{
  public static void main(String args[]) throws Exception {
    String sql = "SELECT name, age FROM users WHERE age > 21";
    SqlParser parser = SqlParser.create(sql);
    SqlNode sqlNode = parser.parseQuery();
    System.out.println("Parsed SQL: " + sqlNode);
  }
}
