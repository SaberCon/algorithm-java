package cn.sabercon.algorithm.q400.q310;

/**
 * Range Sum Query - Immutable
 *
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 *
 * @author ywk
 * @date 2020-04-20
 */
public class Q302 {

    private int[] dp;

    public Q302(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return;
        }
        dp = new int[length + 1];
        dp[0] = 0;
        for (int i = 0; i < length; i++) {
            dp[i + 1] = dp[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return dp[j + 1] - dp[i];
    }
}
