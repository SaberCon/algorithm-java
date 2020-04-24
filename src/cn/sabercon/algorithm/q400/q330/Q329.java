package cn.sabercon.algorithm.q400.q330;

/**
 * Longest Increasing Path in a Matrix
 * <p>
 * Given an integer matrix, find the length of the longest increasing path.
 * <p>
 * From each cell, you can either move to four directions: left, right, up or down.
 * You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 * <p>
 * Example 1:
 * <p>
 * Input: nums =
 * [
 * [9,9,4],
 * [6,6,8],
 * [2,1,1]
 * ]
 * Output: 4
 * Explanation: The longest increasing path is [1, 2, 6, 9].
 * Example 2:
 * <p>
 * Input: nums =
 * [
 * [3,4,5],
 * [3,2,6],
 * [2,2,1]
 * ]
 * Output: 4
 * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
 *
 * @author ywk
 * @date 2020-04-24
 */
public class Q329 {

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int ans = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                ans = Math.max(ans, dfs(matrix, cache, i, j));
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int[][] cache, int i, int j) {
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        int length = 1;
        int current = matrix[i][j];
        if (i > 0 && matrix[i - 1][j] > current) {
            length = Math.max(length, 1 + dfs(matrix, cache, i - 1, j));
        }
        if (i < matrix.length - 1 && matrix[i + 1][j] > current) {
            length = Math.max(length, 1 + dfs(matrix, cache, i + 1, j));
        }
        if (j > 0 && matrix[i][j - 1] > current) {
            length = Math.max(length, 1 + dfs(matrix, cache, i, j - 1));
        }
        if (j < matrix[0].length - 1 && matrix[i][j + 1] > current) {
            length = Math.max(length, 1 + dfs(matrix, cache, i, j + 1));
        }
        cache[i][j] = length;
        return length;
    }
}
