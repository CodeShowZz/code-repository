package com.algorithm.leetcode;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author junlin_huang
 * @create 2020-09-19 下午9:14
 **/

public class LRUCache_146 {

    @Test
    public void testLRUCache() {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

        cache.put(2, 1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);
        cache.get(1);
        cache.get(2);


    }

}

class LRUCache {

    private final int capacity;
    private LinkedHashMap<Integer, Integer> linkedHashMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        linkedHashMap = new LinkedHashMap();
    }

    public int get(int key) {
        if (linkedHashMap.containsKey(key)) {
            Integer value = linkedHashMap.get(key);
            linkedHashMap.remove(key);
            linkedHashMap.put(key, value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (linkedHashMap.containsKey(key)) {
            linkedHashMap.put(key, value);
            linkedHashMap.remove(key);
            linkedHashMap.put(key, value);
        } else {
            if (linkedHashMap.size() == capacity) {
                removeFirst();
            }
            linkedHashMap.put(key, value);
        }
    }

    public void removeFirst() {
        Iterator<Map.Entry<Integer, Integer>> entry = linkedHashMap.entrySet().iterator();
        linkedHashMap.remove(entry.next().getKey());
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */