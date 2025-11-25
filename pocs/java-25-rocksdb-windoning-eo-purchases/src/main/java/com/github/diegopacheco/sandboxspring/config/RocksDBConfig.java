package com.github.diegopacheco.sandboxspring.config;

import org.rocksdb.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PreDestroy;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class RocksDBConfig {

    @Value("${rocksdb.data.path:./rocksdb-data}")
    private String dataPath;

    private TransactionDB transactionDB;
    private final Map<String, ColumnFamilyHandle> columnFamilies = new HashMap<>();
    private final List<ColumnFamilyHandle> cfHandles = new ArrayList<>();

    @Bean
    public TransactionDB transactionDB() throws RocksDBException {
        if (transactionDB != null) {
            return transactionDB;
        }

        RocksDB.loadLibrary();

        String dbPath = dataPath + File.separator + "transactional";
        new File(dbPath).mkdirs();

        List<ColumnFamilyDescriptor> cfDescriptors = new ArrayList<>();
        cfDescriptors.add(new ColumnFamilyDescriptor(RocksDB.DEFAULT_COLUMN_FAMILY));
        cfDescriptors.add(new ColumnFamilyDescriptor("dedup".getBytes()));
        cfDescriptors.add(new ColumnFamilyDescriptor("total-debt".getBytes()));
        cfDescriptors.add(new ColumnFamilyDescriptor("history".getBytes()));

        DBOptions dbOptions = new DBOptions();
        dbOptions.setCreateIfMissing(true);
        dbOptions.setCreateMissingColumnFamilies(true);

        TransactionDBOptions txnDbOptions = new TransactionDBOptions();

        transactionDB = TransactionDB.open(dbOptions, txnDbOptions, dbPath, cfDescriptors, cfHandles);

        columnFamilies.put("default", cfHandles.get(0));
        columnFamilies.put("dedup", cfHandles.get(1));
        columnFamilies.put("total-debt", cfHandles.get(2));
        columnFamilies.put("history", cfHandles.get(3));

        return transactionDB;
    }

    @Bean
    public ColumnFamilyHandle dedupColumnFamily() throws RocksDBException {
        transactionDB();
        return columnFamilies.get("dedup");
    }

    @Bean
    public ColumnFamilyHandle totalDebtColumnFamily() throws RocksDBException {
        transactionDB();
        return columnFamilies.get("total-debt");
    }

    @Bean
    public ColumnFamilyHandle historyColumnFamily() throws RocksDBException {
        transactionDB();
        return columnFamilies.get("history");
    }

    @PreDestroy
    public void cleanup() {
        cfHandles.forEach(ColumnFamilyHandle::close);
        if (transactionDB != null) {
            transactionDB.close();
        }
    }
}
