package com.github.diegopacheco.sandbox.java.cache.v3;

import java.util.HashMap;
import java.util.Optional;

/**
 * SimpleLRUCache Better LRU cache impl.
 * <p>
 * Hash a Map for Storing objects and a Double-Linked-List(start and end) to track LRU with o(1) insert and remove operations :D
 *
 * @param <T> any type really.
 * @author Diego Pacheco
 */
public class SimpleLRUCache<T> implements LRUCache<T> {

    private HashMap<String, ReferenceEntry> hashmap = hashmap = new HashMap<String, ReferenceEntry>();
    private ReferenceEntry start, end;      // Double-LinkedList for tracking LRU
    private static final int THRESHOLD = 2;

    @Override
    public Optional<T> get(String key) {
        if (hashmap.containsKey(key)) {
            ReferenceEntry<T> ref = hashmap.get(key);
            removeNode(ref);
            addAtTop(ref);
            return Optional.of(ref.value);
        }
        return Optional.empty();
    }

    @Override
    public void set(String key, T value) {
        if (hashmap.containsKey(key)) {
            ReferenceEntry<T> ref = hashmap.get(key);
            ref.value = value;
            removeNode(ref);
            addAtTop(ref);
            return;
        }
        ReferenceEntry<T> ref = new ReferenceEntry<>();
        ref.left = null;
        ref.right = null;
        ref.value = value;
        ref.key = key;
        if (hashmap.size() >= THRESHOLD) {
            hashmap.remove(end.key);
            removeNode(end);
            addAtTop(ref);
        } else {
            addAtTop(ref);
        }
        hashmap.put(key, ref);
    }

    @Override
    public Integer size() {
        return hashmap.size();
    }

    private void addAtTop(ReferenceEntry ref) {
        ref.right = start;
        ref.left = null;
        if (start != null)
            start.left = ref;
        start = ref;
        if (end == null)
            end = start;
    }

    private void removeNode(ReferenceEntry ref) {
        if (ref.left != null) {
            ref.left.right = ref.right;
        } else {
            start = ref.right;
        }
        if (ref.right != null) {
            ref.right.left = ref.left;
        } else {
            end = ref.left;
        }
    }
}