package cn.sabercon.algorithm.q100.q70;

import java.util.HashMap;
import java.util.Map;

/**
 * Unique Path II
 * <p>
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * <p>
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * <p>
 * Note: m and n will be at most 100.
 * <p>
 * Example 1:
 * Input:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 *
 * @author ywk
 * @date 2020-03-16
 */
public class Q63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        return dynamicProgramming(0, 0, new HashMap<>(), obstacleGrid);
    }

    private int dynamicProgramming(int m, int n, Map<Integer, Integer> map, int[][] obstacleGrid) {
        if (m == obstacleGrid.length - 1 && n == obstacleGrid[0].length - 1) {
            return 1;
        }
        int key = m * 1000 + n;
        if (map.containsKey(key)) {
            return map.get(key);
        } else {
            int sum = 0;
            if (m != obstacleGrid.length - 1 && obstacleGrid[m + 1][n] != 1) {
                sum += dynamicProgramming(m + 1, n, map, obstacleGrid);
            }
            if (n != obstacleGrid[0].length - 1 && obstacleGrid[m][n + 1] != 1) {
                sum += dynamicProgramming(m, n + 1, map, obstacleGrid);
            }
            map.put(key, sum);
            return sum;
        }
    }
}
