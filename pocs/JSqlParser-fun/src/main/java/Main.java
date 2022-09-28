import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.*;
import net.sf.jsqlparser.util.TablesNamesFinder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main{
  public static void main(String args[]) throws Exception{

    Select stmt = (Select) CCJSqlParserUtil.parse("SELECT col1 AS a, " +
            "col2 AS b, col3 AS c " +
            "FROM table WHERE col1 = 10 AND col2 = 20 AND col3 = 30");
    Map<String, Expression> map = new HashMap<>();
    for (SelectItem selectItem : ((PlainSelect)stmt.getSelectBody()).getSelectItems()) {
      selectItem.accept(new SelectItemVisitorAdapter() {
        @Override
        public void visit(SelectExpressionItem item) {
          map.put(item.getAlias().getName(), item.getExpression());
        }
      });
    }
    System.out.println("columns being queried: " + map);

    extractTable("SELECT * FROM MY_TABLE1");

    extractTable("SELECT\n" +
            "  Teachers.id as teacher_id,\n" +
            "  Students.student_id\n" +
            "FROM Teachers\n" +
            "LEFT OUTER JOIN Students\n" +
            "ON Teachers.id = Students.teacher_id;");

    extractTable("SELECT\n" +
            "  Teachers.id as teacher_id,\n" +
            "  Students.id as student_id\n" +
            "FROM Teachers\n" +
            "FULL OUTER JOIN Students\n" +
            "ON Teachers.id = Students.teacher_id;\n");

    extractTable("\n" +
            "SELECT m.material_id,\n" +
            "       (SELECT file_location \n" +
            "          FROM (SELECT TOP 1 file_location\n" +
            "                  FROM mat\n" +
            "                 WHERE mat.content_id = m.content_id\n" +
            "              ORDER BY resolution DESC) special_mats_for_this_content            \n" +
            "               ) special_mat_file_location                                     \n" +
            "  FROM mat m\n" +
            " WHERE m.material_id IN (select material_id \n" +
            "                           from mat\n" +
            "                     inner join con on con.content_id = mat.content_id\n" +
            "                     inner join con_groups on con_groups.content_id = con.content_id\n" +
            "                          where con_groups.content_group_id = 10);\n");

  }

  private static void extractTable(String query){
    try{
      Statement statement = CCJSqlParserUtil.parse(query);
      Select selectStatement = (Select) statement;
      TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
      List<String> tableList = tablesNamesFinder.getTableList(selectStatement);
      System.out.println("List of tables: " + tableList);
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }

}
