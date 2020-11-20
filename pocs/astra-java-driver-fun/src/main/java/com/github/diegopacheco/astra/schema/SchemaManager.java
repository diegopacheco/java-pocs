package com.github.diegopacheco.astra.schema;

import com.datastax.oss.driver.api.core.CqlSession;
import com.github.diegopacheco.astra.session.SessionManager;

public class SchemaManager {

    private static String table = "CREATE TABLE IF NOT EXISTS product " +
     " (id uuid PRIMARY KEY, description text)";

    public static void create(){
        CqlSession session = SessionManager.getSession();
        try{
            session.execute("USE test");
            session.execute(table);
            System.out.println("Table created/updated with success. ");
        }catch(Exception e){
            System.out.println("Error creating table: ");
            System.out.println(e);
        }
    }

}
