package com.github.diegopacheco.bookkeeping;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class UserLog implements Bookkeeping {

    private static Map<UUID, LinkedHashSet<Entry>> entries = new ConcurrentHashMap<>();

    public void log(String event){
        LinkedHashSet<Entry> entry = new LinkedHashSet<>();
        entry.add(new Entry(event));
        entries.put(UUID.randomUUID(),entry);
    }

    public void log(UUID id,String event){
        LinkedHashSet<Entry> entry = new LinkedHashSet<>();
        if (entries.containsKey(id)){
            entry = entries.get(id);
        }
        entry.add(new Entry(event));
        entries.put(id,entry);
    }

    public Map<UUID,LinkedHashSet<Entry>> getAllEntries() {
        return entries.entrySet().stream().collect(
                ConcurrentHashMap::new,
                (m,e) -> m.put(e.getKey(),e.getValue()),
                Map::putAll
        );
    }

    public LinkedHashSet<Entry> getEntriesByID(UUID id){
        if (!entries.containsKey(id)) new LinkedHashSet<>();

        LinkedHashSet<Entry> entry = new LinkedHashSet<>();
        entry.addAll(entries.get(id));
        return entry;
    }

}
