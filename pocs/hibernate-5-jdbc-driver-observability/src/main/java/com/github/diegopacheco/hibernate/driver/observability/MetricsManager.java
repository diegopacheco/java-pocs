package com.github.diegopacheco.hibernate.driver.observability;

import com.github.diegopacheco.hibernate.driver.parser.SQLParser;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MetricsManager {

    private static Queue<String> queue = new ConcurrentLinkedQueue<>();
    private static ScheduledExecutorService es = Executors.newSingleThreadScheduledExecutor();

    private static final AtomicInteger activeTableCounter = new AtomicInteger(0);
    private static final AtomicInteger activeTableWriteCounter = new AtomicInteger(0);

    private static final LinkedHashSet<String> activeTables = new LinkedHashSet<>();
    private static final LinkedHashSet<String> activeTablesWrite = new LinkedHashSet<>();

    static{
        es.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                if (!queue.isEmpty()){
                    String sql = queue.poll();
                    List<String> tables = SQLParser.extractTable(sql);
                    if (null!=tables){
                        for(String table : tables){
                            MetricsManager.incTable(table,sql);
                        }
                    }
                }
            }
        }, 0, 3, TimeUnit.SECONDS);
    }

    public static int observeSQL(String sql){
        queue.add(sql);
        return activeTableCounter.get();
    }

    private static int incTable(String tableName, String sql){
        int tables = activeTableCounter.incrementAndGet();
        activeTables.add(tableName);
        if (sql.contains("insert")){
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
