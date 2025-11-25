package com.github.diegopacheco.sandboxspring.config;

import org.rocksdb.Options;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksDBException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PreDestroy;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class RocksDBConfig {

    @Value("${rocksdb.data.path:./rocksdb-data}")
    private String dataPath;

    private final Map<String, RocksDB> databases = new HashMap<>();

    @Bean
    public RocksDB dedupDatabase() throws RocksDBException {
        return getOrCreateDatabase("dedup");
    }

    @Bean
    public RocksDB totalDebtDatabase() throws RocksDBException {
        return getOrCreateDatabase("total-debt");
    }

    @Bean
    public RocksDB historyDatabase() throws RocksDBException {
        return getOrCreateDatabase("history");
    }

    private synchronized RocksDB getOrCreateDatabase(String name) throws RocksDBException {
        if (databases.containsKey(name)) {
            return databases.get(name);
        }

        RocksDB.loadLibrary();
        Options options = new Options();
        options.setCreateIfMissing(true);

        String dbPath = dataPath + File.separator + name;
        new File(dbPath).mkdirs();

        RocksDB db = RocksDB.open(options, dbPath);
        databases.put(name, db);
        return db;
    }

    @PreDestroy
    public void cleanup() {
        databases.values().forEach(db -> {
            if (db != null) {
                db.close();
            }
        });
    }
}
