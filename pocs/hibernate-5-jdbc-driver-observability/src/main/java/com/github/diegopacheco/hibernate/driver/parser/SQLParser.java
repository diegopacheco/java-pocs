package com.github.diegopacheco.hibernate.driver.parser;

import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.util.TablesNamesFinder;

import java.util.List;

public class SQLParser {

    public static List<String>  extractTable(String query){
        try{
            Statement statement = CCJSqlParserUtil.parse(query);
            if (statement instanceof Select){
                Select selectStatement = (Select) statement;
                TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
                List<String> tableList = tablesNamesFinder.getTableList(selectStatement);
                return tableList;
            } else if (statement instanceof Insert){
                Insert insertStatement = (Insert) statement;
                TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
                List<String> tableList = tablesNamesFinder.getTableList(insertStatement);
                return tableList;
            }
            return null;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
