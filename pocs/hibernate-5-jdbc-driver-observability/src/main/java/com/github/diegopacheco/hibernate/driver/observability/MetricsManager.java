package com.github.diegopacheco.hibernate.driver.observability;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MetricsManager {

    private static final AtomicInteger activeTableCounter = new AtomicInteger(0);
    private static final AtomicInteger activeTableWriteCounter = new AtomicInteger(0);

    private static final LinkedHashSet<String> activeTables = new LinkedHashSet<>();
    private static final LinkedHashSet<String> activeTablesWrite = new LinkedHashSet<>();

    public static int incTable(String tableName,String query){
        int tables = activeTableCounter.incrementAndGet();
        activeTables.add(tableName);
        if (query.contains("insert")){
            activeTableWriteCounter.incrementAndGet();
            activeTablesWrite.add(tableName);
        }
        return tables;
    }

    public static Map<String,String> stats(){
        Map<String,String> stats = new HashMap<>();
        stats.put("table.count",activeTableCounter.get()+"");
        stats.put("table.write.count",activeTableWriteCounter.get()+"");
        stats.put("tables",activeTables.toString());
        stats.put("tables.write",activeTablesWrite.toString());
        return stats;
    }

}
