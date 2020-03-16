package cn.sabercon.algorithm.q100.q70;

import java.util.HashMap;
import java.util.Map;

/**
 * Unique Paths
 * <p>
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * <p>
 * Example 1:
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 * <p>
 * Example 2:
 * Input: m = 7, n = 3
 * Output: 28
 *
 * Constraints:
 * 1 <= m, n <= 100
 * It's guaranteed that the answer will be less than or equal to 2 * 10 ^ 9
 *
 * @author ywk
 * @date 2020-03-16
 */
public class Q62 {

    public int uniquePaths(int m, int n) {
        return dynamicProgramming(m, n, 1, 1, new HashMap<Integer,Integer>());
    }

    private int dynamicProgramming(int m, int n, int mIndex, int nIndex, Map<Integer, Integer> map) {
        if (m == mIndex || n == nIndex) {
            return 1;
        }
        int key = mIndex * 1000 + nIndex;
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            int sum = dynamicProgramming(m, n, mIndex + 1, nIndex, map) + dynamicProgramming(m, n, mIndex, nIndex + 1, map);
            map.put(key, sum);
            return sum;
        }
    }
}
