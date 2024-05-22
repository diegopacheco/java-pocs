package com.github.diegopacheco.bookkeeping.bookkeeping;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.UUID;

public interface Bookkeeping {
    void log(UUID id,String event);
    void log(String event);
    Map<UUID, LinkedHashSet<Entry>> getAllEntries();
    LinkedHashSet<Entry> getEntriesByID(UUID id);
}
