package com.github.diegopacheco.hibernate.driver.parser;

import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.update.Update;
import net.sf.jsqlparser.util.TablesNamesFinder;

import java.util.List;

public class SQLParser {

    public static List<String>  extractTable(String query){
        try{
            TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
            Statement statement = CCJSqlParserUtil.parse(query);
            List<String> tableList = tablesNamesFinder.getTableList(statement);
            return tableList;
            /*if (statement instanceof Select){
                Select selectStatement = (Select) statement;

                return tableList;
            } else if (statement instanceof Insert){
                Insert insertStatement = (Insert) statement;
                List<String> tableList = tablesNamesFinder.getTableList(insertStatement);
                return tableList;
            } else if (statement instanceof Update){
                Update updateStatement = (Update) statement;
                List<String> tableList = tablesNamesFinder.getTableList(updateStatement);
                return tableList;
            }
            return null;
             */
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
