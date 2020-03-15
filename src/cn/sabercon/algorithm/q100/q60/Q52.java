package cn.sabercon.algorithm.q100.q60;

import java.util.HashSet;
import java.util.Set;

/**
 * N-Queens II
 * <p>
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 * <p>
 * Example:
 * Input: 4
 * Output: 2
 * Explanation: There are two distinct solutions to the 4-queens puzzle as shown below.
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 *
 * @author ywk
 * @date 2020-03-15
 */
public class Q52 {

    public int totalNQueens(int n) {
        return solve(new int[n], new HashSet<>(), n, 0);
    }

    private int solve(int[] nums, Set<Integer> numSet, int n, int index) {
        if (index == n) {
            return 1;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (!numSet.contains(i) && noAttack(nums, i, index)) {
                nums[index] = i;
                numSet.add(i);
                result += solve(nums, numSet, n, index + 1);
                numSet.remove(i);
            }
        }
        return result;
    }

    private boolean noAttack(int[] nums, int num, int index) {
        for (int i = 0; i < index; i++) {
            if (index - i == Math.abs(nums[i] - num)) {
                return false;
            }
        }
        return true;
    }
}
