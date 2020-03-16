package cn.sabercon.algorithm.q100.q70;

import java.util.HashMap;
import java.util.Map;

/**
 * Climbing Stairs
 * <p>
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * <p>
 * Note: Given n will be a positive integer.
 * <p>
 * Example 1:
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * <p>
 * Example 2:
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 * @author ywk
 * @date 2020-03-17
 */
public class Q70 {

    public int climbStairs(int n) {
        return climb(n, new HashMap<>(n));
    }

    private int climb(int n, Map<Integer, Integer> map) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int num = climb(n - 1, map) + climb(n - 2, map);
            map.put(n, num);
            return num;
        }
    }
}
