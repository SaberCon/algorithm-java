package cn.sabercon.algorithm.q400.q310;

/**
 * Range Sum Query - Mutable
 *
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * The update(i, val) function modifies nums by updating the element at index i to val.
 *
 * Example:
 *
 * Given nums = [1, 3, 5]
 *
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * Note:
 *
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 *
 * @author ywk
 * @date 2020-04-20
 */
public class Q307 {

    int[] dp;

    public Q307(int[] nums) {
        dp = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            dp[i + 1] = dp[i] + nums[i];
        }
    }

    public void update(int i, int val) {
        int oldVal = dp[i + 1] - dp[i];
        for (int j = i + 1; j < dp.length; j++) {
            dp[j] += val - oldVal;
        }
    }

    public int sumRange(int i, int j) {
        return dp[j + 1] - dp[i];
    }
}
