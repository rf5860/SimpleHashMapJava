package com.rjf89;


import java.util.*;

public class MyOwnHashMap<K, V> implements Map<K, V> {
    private int capacity = 65536;
    @SuppressWarnings("unchecked")
    private Entry<K, V>[] entries = new Entry[capacity];

    @Override
    public int size() {
        return entrySet().size();
    }

    @Override
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @Override
    public boolean containsKey(Object k) {
        return k != null && entries[k.hashCode() % capacity] != null;
    }

    @Override
    public boolean containsValue(Object value) {
        return values().contains(value);
    }

    @Override
    public V get(Object key) {
        if (key == null) {
            return null;
        }
        int hash = key.hashCode() % capacity;
        return entries[hash] == null ? null : entries[hash].getValue();
    }

    @Override
    public V put(K key, V value) {
        if (key == null) return null;
        entries[key.hashCode() % capacity] = new AbstractMap.SimpleEntry<>(key, value);

        return value;
    }

    @Override
    public V remove(Object key) {
        if (key != null) {
            int hash = key.hashCode() % capacity;
            Entry<K, V> entry = entries[hash];
            entries[hash] = null;
            return entry == null ? null : entry.getValue();
        }
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        if (m == null) {
            return;
        }
        for (Entry<? extends K, ? extends V> e : m.entrySet()) {
            entries[e.hashCode() % capacity] = new AbstractMap.SimpleEntry<>(e.getKey(), e.getValue());
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < capacity; i++) entries[i] = null;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (int i = 0; i < capacity; i++) {
            if (entries[i] != null) {
                keys.add(entries[i].getKey());
            }
        }
        return keys;
    }

    @Override
    public Collection<V> values() {
        Collection<V> vals = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            if (entries[i] != null) {
                vals.add(entries[i].getValue());
            }
        }
        return vals;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> entrySet = new HashSet<>();
        for (int i = 0; i < capacity; i++) {
            if (entries[i] != null) {
                entrySet.add(entries[i]);
            }
        }
        return entrySet;
    }
}
