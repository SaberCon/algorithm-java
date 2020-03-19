package cn.sabercon.algorithm.q100.q100;

import java.util.HashMap;
import java.util.Map;

/**
 * Unique Binary Search Trees
 * <p>
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 * <p>
 * Example:
 * Input: 3
 * Output: 5
 * Explanation:
 * Given n = 3, there are a total of 5 unique BST's:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 *
 * @author ywk
 * @date 2020-03-19
 */
public class Q96 {

    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        return num(n, new HashMap<>());
    }

    private int num(int n, Map<Integer, Integer> map) {
        if (n < 2) {
            return 1;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        int num = 0;
        for (int i = 1; i <= n; i++) {
            num += num(i - 1, map) * num(n - i, map);
        }
        map.put(n, num);
        return num;
    }
}
