package com.github.diegopacheco.bookkeeping.bookkeeping;

import com.github.diegopacheco.bookkeeping.events.Event;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.UUID;

public interface Bookkeeping {
    void log(UUID id,Event event);
    void log(Event event);
    Map<UUID, LinkedHashSet<Entry>> getAllEntries();
    LinkedHashSet<Entry> getEntriesByID(UUID id);
}
