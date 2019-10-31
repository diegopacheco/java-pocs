import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;

public class LiquibaseJavaRunner {
    public static void main(String[] args) throws Exception {
        
        java.sql.Connection connection = openConnection();

        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection));

        Liquibase liquibase = new liquibase.Liquibase("changelog.xml", new ClassLoaderResourceAccessor(), database);

        liquibase.update(new Contexts(), new LabelExpression());
        System.out.println("Used changeset: " + liquibase.getDatabaseChangeLog().getChangeSets());

    }

    public static Connection openConnection() throws Exception {
        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", "postgres");
        connectionProps.put("password", "root");
        conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/poc",
                    connectionProps);
        return conn;
    }
}