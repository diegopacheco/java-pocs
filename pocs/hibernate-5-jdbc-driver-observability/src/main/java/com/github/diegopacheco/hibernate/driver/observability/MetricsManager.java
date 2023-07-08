package com.github.diegopacheco.hibernate.driver.observability;

import com.github.diegopacheco.hibernate.driver.parser.SQLParser;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MetricsManager {

    private static Queue<String> queue = new ConcurrentLinkedQueue<>();
    private static ScheduledExecutorService es = Executors.newSingleThreadScheduledExecutor();

    private static final LinkedHashSet<String> activeTables = new LinkedHashSet<>();
    private static final LinkedHashSet<String> activeTablesWrite = new LinkedHashSet<>();

    private static final Map<String,AtomicInteger> counters = new ConcurrentHashMap<>();

    static{
        es.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                while(!queue.isEmpty()){
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

    public static boolean observeSQL(String sql){
        queue.add(sql);
        return true;
    }

    private static boolean incTable(String tableName, String sql){
        String prefix = "table.";
        String sufix = ".read";
        activeTables.add(tableName);
        if (sql.contains("insert")){
            sufix = ".write";
            activeTablesWrite.add(tableName);
        }
        String key = prefix + tableName + sufix;

        AtomicInteger counter = counters.get(key);
        if (null==counter){
            counter = new AtomicInteger(1);
            counters.put(key,counter);
        }else {
            counter.incrementAndGet();
            counters.put(key,counter);
        }
        return true;
    }

    public static boolean incConnection(){
        String key = "connection.count";
        AtomicInteger counter = counters.get(key);
        if (null==counter){
            counter = new AtomicInteger(1);
            counters.put(key,counter);
        }else {
            counter.incrementAndGet();
            counters.put(key,counter);
        }
        return true;
    }

    public static boolean decConnection(){
        String key = "connection.count";
        AtomicInteger counter = counters.get(key);
        if (null==counter){
            counter = new AtomicInteger(0);
            counters.put(key,counter);
        }else {
            counter.decrementAndGet();
            counters.put(key,counter);
        }
        return true;
    }

    public static Map<String,String> stats(){
        Map<String,String> stats = new HashMap<>();
        stats.put("connection.count",counters.get("connection.count").get()+"");
        stats.put("tables",activeTables.toString());
        stats.put("tables.write",activeTablesWrite.toString());

        for(String key: counters.keySet()){
            stats.put(key,counters.get(key).get()+"");
        }
        return stats;
    }

}
