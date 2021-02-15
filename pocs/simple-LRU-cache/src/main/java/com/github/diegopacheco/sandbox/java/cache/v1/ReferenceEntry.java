package com.github.diegopacheco.sandbox.java.cache.v1;

import java.util.Comparator;
import java.util.Objects;

/*
*  ReferenceEntry is a container to keep track of data between hashmap and the heap.
*
*  @author Diego Pacheco
* */
public class ReferenceEntry<T> {

    public static class ReferenceEntryMinComparator implements Comparator<ReferenceEntry> {
        @Override
        public int compare (ReferenceEntry x, ReferenceEntry y) {
            return Long.compare(x.lastTimestampAccess,y.lastTimestampAccess);
        }
    }

    private String key;
    private T value;
    private long lastTimestampAccess;

    public ReferenceEntry(String key,long lastTimestampAccess) {
        this.key = key;
        this.lastTimestampAccess = lastTimestampAccess;
    }
    public ReferenceEntry(String key,T value, long lastTimestampAccess) {
        this.key = key;
        this.value = value;
        this.lastTimestampAccess = lastTimestampAccess;
    }

    public String getKey() {
        return key;
    }

    public long getLastTimestampAccess() {
        return lastTimestampAccess;
    }
    public void setLastTimestampAccess(long lastTimestampAccess) {
        this.lastTimestampAccess = lastTimestampAccess;
    }

    public static<R> ReferenceEntry<R> from(String key,R value){
        return new ReferenceEntry<R>(key,value,System.currentTimeMillis());
    }

    public T getValue() {
        this.lastTimestampAccess=System.currentTimeMillis();
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReferenceEntry<?> that = (ReferenceEntry<?>) o;
        return Objects.equals(key, that.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }

    @Override
    public String toString() {
        return "ReferenceEntry{" +
                "key='" + key + '\'' +
                "value='" + value + '\'' +
                ", lastTimestampAccess=" + lastTimestampAccess +
                '}';
    }
}
