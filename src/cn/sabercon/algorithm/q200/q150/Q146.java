package cn.sabercon.algorithm.q200.q150;

import java.util.LinkedHashMap;

/**
 * LRU Cache
 * <p>
 * Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.
 * <p>
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 * it should invalidate the least recently used item before inserting a new item.
 * <p>
 * The cache is initialized with a positive capacity.
 * <p>
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 * <p>
 * Example:
 * <p>
 * LRUCache cache = new LRUCache( 2 );
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // returns 1
 * cache.put(3,3);    // evicts key 2
 * cache.get(2);       // returns -1 (not found)
 * cache.put(4,4);    // evicts key 1
 * cache.get(1);       // returns -1 (not found)
 * cache.get(3);       // returns 3
 * cache.get(4);       // returns 4
 * <p>
 *
 * @author ywk
 * @date 2020-03-25
 */
public class Q146 {

    private LinkedHashMap<Integer, Integer> map;

    private int capacity;

    public Q146(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity);
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Integer value = map.get(key);
            map.remove(key);
            map.put(key, value);
            return value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        } else {
            if (capacity == 0) {
                map.keySet().stream().findFirst().ifPresent(k -> map.remove(k));
            } else {
                capacity--;
            }
        }
        map.put(key, value);
    }
}
