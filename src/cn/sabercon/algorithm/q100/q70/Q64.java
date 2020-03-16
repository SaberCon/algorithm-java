package cn.sabercon.algorithm.q100.q70;

import java.util.HashMap;
import java.util.Map;

/**
 * Minimum Path Sum
 * <p>
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * <p>
 * Note: You can only move either down or right at any point in time.
 * <p>
 * Example:
 * Input:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 * @author ywk
 * @date 2020-03-16
 */
public class Q64 {

    public int minPathSum(int[][] grid) {
        return dynamicProgramming(0, 0, new HashMap<>(), grid);
    }

    private int dynamicProgramming(int m, int n, Map<Integer, Integer> map, int[][] grid) {
        if (m == grid.length - 1 && n == grid[0].length - 1) {
            return grid[m][n];
        }
        int key = m * 10000 + n;
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            int sum = grid[m][n];
            if (m == grid.length - 1) {
                sum += dynamicProgramming(m, n + 1, map, grid);
            } else if (n == grid[0].length - 1) {
                sum += dynamicProgramming(m + 1, n, map, grid);
            } else {
                sum += Math.min(dynamicProgramming(m, n + 1, map, grid), dynamicProgramming(m + 1, n, map, grid));
            }
            map.put(key, sum);
            return sum;
        }
    }
}
