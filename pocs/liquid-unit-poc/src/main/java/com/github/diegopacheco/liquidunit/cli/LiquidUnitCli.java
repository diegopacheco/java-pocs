package com.github.diegopacheco.liquidunit.cli;

import java.nio.file.Path;
import java.util.List;
import com.github.diegopacheco.liquidunit.core.DatabaseConnector;
import com.github.diegopacheco.liquidunit.core.LiquidUnitConfig;
import com.github.diegopacheco.liquidunit.migrations.MigrationExecutor;
import com.github.diegopacheco.liquidunit.migrations.MigrationScanner;

public class LiquidUnitCli {
    private static LiquidUnitConfig config;
    private static DatabaseConnector dbConnector;
    private static MigrationScanner scanner;
    private static MigrationExecutor executor;

    public static void main(String[] args) {
        displayBanner();

        try {
            initialize();

            if (args.length == 0) {
                runCompleteSuite();
            } else if (args[0].equals("--mt")) {
                runMigrationTests();
            } else if (args[0].equals("--ro")) {
                runRollbackTests();
            } else if (args[0].equals("--?") || args[0].equals("--h")) {
                displayHelp();
            } else {
                System.out.println("Unknown option: " + args[0]);
                displayHelp();
                System.exit(1);
            }

            System.out.println("✓ LiquidUnitCli completed successfully!");
        } catch (Exception e) {
            System.err.println("Error executing LiquidUnit: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        } finally {
            if (dbConnector != null) {
                dbConnector.closeConnection();
            }
        }
    }

    private static void initialize() throws Exception {
        config = new LiquidUnitConfig();
        dbConnector = new DatabaseConnector(config);
        scanner = new MigrationScanner("src/main/resources/migrations");
        executor = new MigrationExecutor(dbConnector, config);
        dbConnector.setupDatabase();
    }

    private static void runCompleteSuite() throws Exception {
        runMigrationTests();
        runRollbackTests();
        runMigrationTests(); // Run migrations again to restore state
    }

    private static void runMigrationTests() throws Exception {
        System.out.println("\nRunning migration tests...");
        int success = 0;
        int failed = 0;

        List<Path> migrationDirs = scanner.scanMigrationDirectories();
        for (Path migrationDir : migrationDirs) {
            try {
                executor.runMigration(migrationDir);
                success++;
            } catch (Exception e) {
                System.err.println("Migration failed: " + migrationDir.getFileName());
                e.printStackTrace();
                failed++;
            }
        }

        System.out.println("Tests run: " + (success + failed));
        System.out.println("Tests succeeded: " + success);
        System.out.println("Tests failed: " + failed);
    }

    private static void runRollbackTests() throws Exception {
        System.out.println("\nRunning rollback tests...");
        int success = 0;
        int failed = 0;

        List<Path> migrationDirs = scanner.scanMigrationDirectories();
        // Reverse order for rollbacks
        for (int i = migrationDirs.size() - 1; i >= 0; i--) {
            Path migrationDir = migrationDirs.get(i);
            try {
                executor.runRollback(migrationDir);
                success++;
            } catch (Exception e) {
                System.err.println("Rollback failed: " + migrationDir.getFileName());
                e.printStackTrace();
                failed++;
            }
        }

        System.out.println("Rollbacks run: " + (success + failed));
        System.out.println("Rollbacks succeeded: " + success);
        System.out.println("Rollbacks failed: " + failed);
    }

    private static void displayBanner() {
        System.out.println("\n" +
                "  _     _             _     _ _   _       _ _     \n" +
                " | |   (_)           (_)   | | | | |     (_) |    \n" +
                " | |    _  __ _ _   _ _  __| | | | |_ __  _| |_   \n" +
                " | |   | |/ _` | | | | |/ _` | | | | '_ \\| | __|  \n" +
                " | |___| | (_| | |_| | | (_| | |_| | | | | | |_   \n" +
                " |_____|_|\\__, |\\__,_|_|\\__,_|\\___/|_| |_|_|\\__|  \n" +
                "             | |                                  \n" +
                "             |_|                                  \n");
    }

    private static void displayHelp() {
        System.out.println("LiquidUnit Usage:");
        System.out.println("  No args     - Run complete test suite: migrations, rollbacks, migrations");
        System.out.println("  --mt        - Run only migration tests");
        System.out.println("  --ro        - Run only rollback tests");
        System.out.println("  --? or --h  - Display this help message");
    }
}