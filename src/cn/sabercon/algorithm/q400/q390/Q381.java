package cn.sabercon.algorithm.q400.q390;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Insert Delete GetRandom O(1) - Duplicates allowed
 * <p>
 * Design a data structure that supports all following operations in average O(1) time.
 * <p>
 * Note: Duplicate elements are allowed.
 * insert(val): Inserts an item val to the collection.
 * remove(val): Removes an item val from the collection if present.
 * getRandom: Returns a random element from current collection of elements.
 * The probability of each element being returned is linearly related to the number of same value the collection contains.
 * Example:
 * <p>
 * // Init an empty collection.
 * RandomizedCollection collection = new RandomizedCollection();
 * <p>
 * // Inserts 1 to the collection. Returns true as the collection did not contain 1.
 * collection.insert(1);
 * <p>
 * // Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
 * collection.insert(1);
 * <p>
 * // Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
 * collection.insert(2);
 * <p>
 * // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
 * collection.getRandom();
 * <p>
 * // Removes 1 from the collection, returns true. Collection now contains [1,2].
 * collection.remove(1);
 * <p>
 * // getRandom should return 1 and 2 both equally likely.
 * collection.getRandom();
 *
 * @author ywk
 * @date 2020-04-29
 */
public class Q381 {

    private HashMap<Integer, TreeSet<Integer>> map;

    private ArrayList<Integer> list;

    /**
     * Initialize your data structure here.
     */
    public Q381() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            map.get(val).add(list.size());
            list.add(val);
            return false;
        } else {
            TreeSet<Integer> set = new TreeSet<>();
            set.add(list.size());
            map.put(val, set);
            list.add(val);
            return true;
        }
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        TreeSet<Integer> set = map.get(val);
        Integer position = set.pollFirst();
        if (set.isEmpty()) {
            map.remove(val);
        }
        int lastIndex = list.size() - 1;
        if (position != lastIndex) {
            Collections.swap(list, position, lastIndex);
            map.get(list.get(position)).add(position);
            map.get(list.get(position)).remove(lastIndex);
        }
        list.remove(lastIndex);
        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return list.get(ThreadLocalRandom.current().nextInt(list.size()));
    }
}
