package com.ericaShy.java8.equalshashcode;

import java.util.Map;
import java.util.Objects;

public class MapEntry<K, V> implements Map.Entry<K, V> {
    private K key;
    private V value;

    public MapEntry(K key, V val) {
        this.key = key;
        this.value = val;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
       V result = value;
       this.value = value;
       return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean equals(Object rval) {
        return rval instanceof MapEntry &&
                Objects.equals(key, ((MapEntry<K, V>) rval).getKey()) &&
                Objects.equals(key, ((MapEntry<K, V>) rval).getValue());
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }
}
