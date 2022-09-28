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

    extractTable("SELECT   a.file_id,\n" +
            "         a.sale_start,\n" +
            "         a.activity_start,\n" +
            "         a.activity_end,\n" +
            "         a.item_code_cust,\n" +
            "         a.division,\n" +
            "         (SELECT MAX (DISTINCT (NVL (b.advertised, 'No')))\n" +
            "            FROM arch b\n" +
            "           WHERE b.file_id = a.file_id\n" +
            "             AND NVL (b.sale_start, 'NULL') = NVL (a.sale_start, 'NULL')\n" +
            "             AND NVL (b.activity_start, 'NULL') = NVL (a.activity_start, 'NULL')\n" +
            "             AND NVL (b.activity_end, 'NULL') = NVL (a.activity_end, 'NULL')\n" +
            "             AND b.item_code_cust = a.item_code_cust\n" +
            "             AND b.division = a.division) advertised,\n" +
            "         (SELECT activity_id\n" +
            "            FROM (SELECT c.activity_id,\n" +
            "                         ROW_NUMBER () OVER (ORDER BY (c.activity_retail / c.activity_mult)) rnk\n" +
            "                    FROM arch c\n" +
            "                       WHERE NVL (c.sale_start, 'NULL') = NVL (a.sale_start, 'NULL')\n" +
            "                       AND NVL (c.activity_start, 'NULL') = NVL (a.activity_start, 'NULL')\n" +
            "                       AND NVL (c.activity_end, 'NULL') = NVL (a.activity_end, 'NULL')\n" +
            "                       AND c.item_code_cust = a.item_code_cust\n" +
            "                       AND c.division = a.division\n" +
            "                       AND UPPER (NVL (c.advertised, 'N')) = a.advertised\n" +
            "                       AND c.file_id = 217)\n" +
            "           WHERE rnk = 1) primary_id,\n" +
            "         COUNT (*)\n" +
            "    FROM arch a\n" +
            "   WHERE a.file_id = 217\n" +
            "GROUP BY a.file_id, a.sale_start, a.activity_start, a.activity_end, a.item_code_cust, a.division\n" +
            "  HAVING COUNT (*) > 1;");

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
