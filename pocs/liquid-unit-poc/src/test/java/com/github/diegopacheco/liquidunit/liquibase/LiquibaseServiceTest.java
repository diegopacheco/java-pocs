package com.github.diegopacheco.liquidunit.liquibase;

import com.github.diegopacheco.liquidunit.dao.DatabaseMigrationDAO;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LiquibaseServiceTest {

    private LiquibaseService liquibaseService;

    @Mock
    private Path mockMigrationDir;

    @Mock
    private Path mockMigrationFile;

    @Mock
    private Path mockTestFile;

    @Mock
    private Path mockRollbackFile;

    @Mock
    private Path mockParentDir1;

    @Mock
    private Path mockParentDir2;

    @Mock
    private Path mockParentDir3;

    @Mock
    private Connection mockConnection;

    @Mock
    private Database mockDatabase;

    @Mock
    private DatabaseFactory mockDatabaseFactory;

    @Mock
    private Liquibase mockLiquibase;

    @BeforeEach
    void setUp() {
        liquibaseService = new LiquibaseService();
    }

    @Test
    void runMigration_shouldThrowException_whenMigrationFileIsMissing() throws Exception {
        when(mockMigrationDir.resolve("migration.sql")).thenReturn(mockMigrationFile);
        when(mockMigrationDir.resolve("test.sql")).thenReturn(mockTestFile);
        when(mockMigrationDir.resolve("rollback.sql")).thenReturn(mockRollbackFile);

        try (MockedStatic<Files> mockedFiles = Mockito.mockStatic(Files.class)) {
            mockedFiles.when(() -> Files.exists(mockMigrationFile)).thenReturn(false);
            mockedFiles.when(() -> Files.exists(mockTestFile)).thenReturn(true);
            mockedFiles.when(() -> Files.exists(mockRollbackFile)).thenReturn(true);

            RuntimeException exception = assertThrows(RuntimeException.class, () ->
                liquibaseService.runMigration(mockMigrationDir));

            assertTrue(exception.getMessage().contains("Missing one of the required SQL files"));
        }
    }

    @Test
    void runMigration_shouldThrowException_whenTestFileIsMissing() throws Exception {
        when(mockMigrationDir.resolve("migration.sql")).thenReturn(mockMigrationFile);
        when(mockMigrationDir.resolve("test.sql")).thenReturn(mockTestFile);
        when(mockMigrationDir.resolve("rollback.sql")).thenReturn(mockRollbackFile);

        try (MockedStatic<Files> mockedFiles = Mockito.mockStatic(Files.class)) {
            mockedFiles.when(() -> Files.exists(mockMigrationFile)).thenReturn(true);
            mockedFiles.when(() -> Files.exists(mockTestFile)).thenReturn(false);
            mockedFiles.when(() -> Files.exists(mockRollbackFile)).thenReturn(true);

            RuntimeException exception = assertThrows(RuntimeException.class, () ->
                liquibaseService.runMigration(mockMigrationDir));

            assertTrue(exception.getMessage().contains("Missing one of the required SQL files"));
        }
    }

    @Test
    void runMigration_shouldThrowException_whenRollbackFileIsMissing() throws Exception {
        when(mockMigrationDir.resolve("migration.sql")).thenReturn(mockMigrationFile);
        when(mockMigrationDir.resolve("test.sql")).thenReturn(mockTestFile);
        when(mockMigrationDir.resolve("rollback.sql")).thenReturn(mockRollbackFile);

        try (MockedStatic<Files> mockedFiles = Mockito.mockStatic(Files.class)) {
            mockedFiles.when(() -> Files.exists(mockMigrationFile)).thenReturn(true);
            mockedFiles.when(() -> Files.exists(mockTestFile)).thenReturn(true);
            mockedFiles.when(() -> Files.exists(mockRollbackFile)).thenReturn(false);
            RuntimeException exception = assertThrows(RuntimeException.class, () ->
                liquibaseService.runMigration(mockMigrationDir));

            assertTrue(exception.getMessage().contains("Missing one of the required SQL files"));
        }
    }

    @Test
    void runMigration_shouldPropagateExceptions_whenDatabaseOperationsFail() throws Exception {
        when(mockMigrationDir.resolve("migration.sql")).thenReturn(mockMigrationFile);
        when(mockMigrationDir.resolve("test.sql")).thenReturn(mockTestFile);
        when(mockMigrationDir.resolve("rollback.sql")).thenReturn(mockRollbackFile);

        try (MockedStatic<Files> mockedFiles = Mockito.mockStatic(Files.class);
             MockedStatic<DatabaseMigrationDAO> mockedDAO = Mockito.mockStatic(DatabaseMigrationDAO.class)) {

            mockedFiles.when(() -> Files.exists(mockMigrationFile)).thenReturn(true);
            mockedFiles.when(() -> Files.exists(mockTestFile)).thenReturn(true);
            mockedFiles.when(() -> Files.exists(mockRollbackFile)).thenReturn(true);

            mockedDAO.when(DatabaseMigrationDAO::getConnection)
                .thenThrow(new RuntimeException("Database connection failed"));

            RuntimeException exception = assertThrows(RuntimeException.class, () ->
                liquibaseService.runMigration(mockMigrationDir));

            assertTrue(exception.getCause().getMessage().contains("Database connection failed"));
        }
    }
}