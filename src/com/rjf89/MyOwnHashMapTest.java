package com.rjf89;


import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

public class MyOwnHashMapTest {

    @org.junit.Test
    public void testSize() throws Exception {
        MyOwnHashMap<String, Integer> hashMap = new MyOwnHashMap<>();
        hashMap.put("A", 1);
        assertThat(hashMap.size(), is(1));
        hashMap.put("B", 2);
        assertThat(hashMap.size(), is(2));
    }

    @org.junit.Test
    public void testIsEmpty() throws Exception {
        MyOwnHashMap<String, Integer> hashMap = new MyOwnHashMap<>();
        assertThat(hashMap.isEmpty(), is(true));
        hashMap.put("A", 1);
        assertThat(hashMap.isEmpty(), is(false));
    }

    @org.junit.Test
    public void testContainsKey() throws Exception {
        MyOwnHashMap<String, Integer> hashMap = new MyOwnHashMap<>();
        hashMap.put("A", 1);
        assertThat(hashMap.containsKey("A"), is(true));
        assertThat(hashMap.containsKey("B"), is(false));
    }

    @org.junit.Test
    public void testContainsValue() throws Exception {
        MyOwnHashMap<String, Integer> hashMap = new MyOwnHashMap<>();
        hashMap.put("A", 1);
        assertThat(hashMap.containsValue(1), is(true));
        assertThat(hashMap.containsValue(2), is(false));

    }

    @org.junit.Test
    public void testGet() throws Exception {
        MyOwnHashMap<String, Integer> hashMap = new MyOwnHashMap<>();
        hashMap.put("A", 1);
        hashMap.put("B", 2);
        assertThat(hashMap.get("A"), is(1));
        assertThat(hashMap.get("B"), is(2));
    }

    @org.junit.Test
    public void testPut() throws Exception {
        MyOwnHashMap<String, Integer> hashMap = new MyOwnHashMap<>();
        assertThat(hashMap.put("A", 1), is(1));
        assertThat(hashMap.put("B", 2), is(2));
    }

    @org.junit.Test
    public void testRemove() throws Exception {
        MyOwnHashMap<String, Integer> hashMap = new MyOwnHashMap<>();
        hashMap.put("A", 1);
        hashMap.put("B", 2);
        hashMap.remove("A");
        assertThat(hashMap.size(), is(1));
    }

    @org.junit.Test
    public void testPutAll() throws Exception {

    }

    @org.junit.Test
    public void testClear() throws Exception {
        MyOwnHashMap<String, Integer> hashMap = new MyOwnHashMap<>();
        hashMap.put("A", 1);
        hashMap.put("B", 2);
        hashMap.clear();
        assertThat(hashMap.isEmpty(), is(true));
    }

    @org.junit.Test
    public void testKeySet() throws Exception {
        MyOwnHashMap<String, Integer> hashMap = new MyOwnHashMap<>();
        hashMap.put("A", 1);
        hashMap.put("B", 2);
        Set<String> keySet = hashMap.keySet();
        assertThat(keySet, contains("A", "B"));
    }

    @org.junit.Test
    public void testValues() throws Exception {
        MyOwnHashMap<String, Integer> hashMap = new MyOwnHashMap<>();
        hashMap.put("A", 1);
        hashMap.put("B", 2);
        Collection<Integer> keySet = hashMap.values();
        assertThat(keySet, contains(1, 2));
    }

    @org.junit.Test
    public void testEntrySet() throws Exception {
        MyOwnHashMap<String, Integer> hashMap = new MyOwnHashMap<>();
        hashMap.put("A", 1);
        hashMap.put("B", 2);
        Set<Map.Entry<String, Integer>> keySet = hashMap.entrySet();
        Map.Entry[] entries = {new AbstractMap.SimpleEntry<>("A", 1), new AbstractMap.SimpleEntry<>("B", 2)};
        assertThat(keySet, contains(entries));
    }
}