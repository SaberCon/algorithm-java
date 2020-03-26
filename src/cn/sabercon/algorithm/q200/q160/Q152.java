package cn.sabercon.algorithm.q200.q160;

/**
 * Maximum Product Subarray
 *
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 *
 * Example 1:
 *
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 *
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 *
 * @author ywk
 * @date 2020-03-26
 */
public class Q152 {

    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        int[][] dp = new int[nums.length][2];
        dp[0][0] = Math.max(nums[0], 0);
        dp[0][1] = Math.min(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                dp[i][0] = dp[i - 1][0] == 0 ? nums[i] : dp[i - 1][0] * nums[i];
                dp[i][1] = dp[i - 1][1] * nums[i];
            } else {
                dp[i][0] = dp[i - 1][1] * nums[i];
                dp[i][1] = dp[i - 1][0] == 0 ? nums[i] : dp[i - 1][0] * nums[i];
            }
            max = Math.max(max, dp[i][0]);
        }
        return max;
    }
}
