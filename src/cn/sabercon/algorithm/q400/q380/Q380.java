package cn.sabercon.algorithm.q400.q380;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Insert Delete GetRandom O(1)
 * <p>
 * Design a data structure that supports all following operations in average O(1) time.
 * <p>
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
 * Example:
 * <p>
 * // Init an empty set.
 * RandomizedSet randomSet = new RandomizedSet();
 * <p>
 * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomSet.insert(1);
 * <p>
 * // Returns false as 2 does not exist in the set.
 * randomSet.remove(2);
 * <p>
 * // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomSet.insert(2);
 * <p>
 * // getRandom should return either 1 or 2 randomly.
 * randomSet.getRandom();
 * <p>
 * // Removes 1 from the set, returns true. Set now contains [2].
 * randomSet.remove(1);
 * <p>
 * // 2 was already in the set, so return false.
 * randomSet.insert(2);
 * <p>
 * // Since 2 is the only number in the set, getRandom always return 2.
 * randomSet.getRandom();
 *
 * @author ywk
 * @date 2020-04-29
 */
public class Q380 {

    private HashMap<Integer, Integer> map;

    private ArrayList<Integer> list;

    /**
     * Initialize your data structure here.
     */
    public Q380() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        } else {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        Integer position = map.remove(val);
        if (position == null) {
            return false;
        } else {
            int lastIndex = list.size() - 1;
            if (position != lastIndex) {
                Collections.swap(list, position, lastIndex);
                map.put(list.get(position), position);
            }
            list.remove(lastIndex);
            return true;
        }
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(ThreadLocalRandom.current().nextInt(list.size()));
    }
}
