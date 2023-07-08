package com.github.diegopacheco.hibernate.driver.parser;

import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.util.TablesNamesFinder;

import java.util.List;

public class SQLParser {

    public static List<String>  extractTable(String query){
        try{
            TablesNamesFinder tablesNamesFinder = new TablesNamesFinder();
            Statement statement = CCJSqlParserUtil.parse(query);
            List<String> tableList = tablesNamesFinder.getTableList(statement);
            return tableList;
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

}
