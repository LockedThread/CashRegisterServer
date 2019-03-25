package dev.warrensnipes.cashregisterserver.utils;

import java.util.HashMap;

public class MapBuilder<K, V> {

    private HashMap<K, V> hashMap;

    public MapBuilder() {
        this.hashMap = new HashMap<>();
    }

    public MapBuilder<K, V> put(K k, V v) {
        hashMap.put(k, v);
        return this;
    }

    public V get(K k) {
        return hashMap.get(k);
    }

    public HashMap<K, V> build() {
        return hashMap;
    }
}
