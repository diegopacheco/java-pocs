package com.github.diegopacheco.liquidunit.migrations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MigrationScanner {
    private final Path basePath;

    public MigrationScanner(String basePath) {
        this.basePath = Paths.get(basePath);
        if (!Files.exists(this.basePath)) {
            throw new IllegalArgumentException("Migrations folder not found: " + this.basePath.toAbsolutePath());
        }
    }

    public List<Path> scanMigrationDirectories() throws IOException {
        List<Path> migrationDirs = new ArrayList<>();

        try (Stream<Path> paths = Files.walk(basePath, 1)) {
            paths.filter(Files::isDirectory)
                    .filter(path -> !path.equals(basePath)) // exclude the base folder
                    .sorted() // sort for a consistent order
                    .forEach(migrationDirs::add);
        }

        return migrationDirs;
    }

    public Path getBasePath() {
        return basePath;
    }
}