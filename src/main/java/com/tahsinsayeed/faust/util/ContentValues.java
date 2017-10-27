package com.tahsinsayeed.faust.util;

import java.util.*;
import java.util.function.*;

/**
 * Created by sayeed on 10/25/17.
 */
public class ContentValues {
    Map<String, String> values;

    public ContentValues() {
        values = new HashMap<>(8);
    }

    /**
     * The number of strings should be even.
     * Strings in the even position is the value of the key which is the
     * string in the previous odd position.
     * eg.  "key1", "value1", "key2", "value2" and so on
     * @throws IllegalArgumentException if number of strings is odd
     * @param keyValuePair
     */

    public ContentValues(String... keyValuePair){

        if (keyValuePair.length % 2 != 0) throw new IllegalArgumentException();

        for (int i = 0; i < keyValuePair.length - 1; i+=2) {
            values.put(keyValuePair[i], keyValuePair[i + 1]);
        }

    }

    public int size() {
        return values.size();
    }

    public boolean isEmpty() {
        return values.isEmpty();
    }

    public boolean containsKey(Object key) {
        return values.containsKey(key);
    }

    public boolean containsValue(Object value) {
        return values.containsValue(value);
    }

    public String get(Object key) {
        return values.get(key);
    }

    public String put(String key, String value) {
        return values.put(key, value);
    }

    public String remove(Object key) {
        return values.remove(key);
    }

    public void putAll(Map<? extends String, ? extends String> m) {
        values.putAll(m);
    }

    public void clear() {
        values.clear();
    }

    public Set<String> keySet() {
        return values.keySet();
    }

    public Collection<String> values() {
        return values.values();
    }


    public boolean equals(Object o) {
        return values.equals(o);
    }

    public int hashCode() {
        return values.hashCode();
    }



    public void forEach(BiConsumer<? super String, ? super String> action) {
        values.forEach(action);
    }

    public void replaceAll(BiFunction<? super String, ? super String, ? extends String> function) {
        values.replaceAll(function);
    }

    public String putIfAbsent(String key, String value) {
        return values.putIfAbsent(key, value);
    }

    public boolean remove(Object key, Object value) {
        return values.remove(key, value);
    }

    public boolean replace(String key, String oldValue, String newValue) {
        return values.replace(key, oldValue, newValue);
    }

    public String replace(String key, String value) {
        return values.replace(key, value);
    }

}
