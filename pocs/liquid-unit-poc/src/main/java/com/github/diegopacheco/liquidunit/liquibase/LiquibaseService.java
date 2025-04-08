package com.github.diegopacheco.liquidunit.liquibase;

import com.github.diegopacheco.liquidunit.dao.DatabaseMigrationDAO;
import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.DirectoryResourceAccessor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;

public class LiquibaseService {

    public boolean runMigration(Path migrationDir) {
        try {
            Path migrationFile = migrationDir.resolve("migration.sql");
            Path testFile = migrationDir.resolve("test.sql");
            Path rollbackFile = migrationDir.resolve("rollback.sql");

            if (!Files.exists(migrationFile) || !Files.exists(testFile) || !Files.exists(rollbackFile)) {
                throw new RuntimeException("Missing one of the required SQL files in " + migrationDir);
            }

            Connection connection = DatabaseMigrationDAO.getConnection();
            Database database = DatabaseFactory.getInstance()
                    .findCorrectDatabaseImplementation(new JdbcConnection(connection));

            DirectoryResourceAccessor resourceAccessor = new DirectoryResourceAccessor(
                    migrationDir.getParent().getParent().getParent().getParent());

            String relativePath = "main/resources/migrations/" + migrationDir.getFileName() + "/migration.sql";
            Liquibase liquibase = new Liquibase(relativePath, resourceAccessor, database);
            liquibase.update(new Contexts(), new LabelExpression());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return true;
    }

}