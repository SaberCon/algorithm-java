package cn.sabercon.algorithm.q400.q320;

import java.util.Arrays;

/**
 * Burst Balloons
 * <p>
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums.
 * You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins.
 * Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
 * <p>
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * <p>
 * Note:
 * <p>
 * You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
 * Example:
 * <p>
 * Input: [3,1,5,8]
 * Output: 167
 * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *              coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 *
 * @author ywk
 * @date 2020-04-21
 */
public class Q312 {

    private int[][] cache;

    public int maxCoins(int[] nums) {
        int length = nums.length + 2;
        cache = new int[length][length];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        int[] numsWithBorder = new int[length];
        System.arraycopy(nums, 0, numsWithBorder, 1, nums.length);
        numsWithBorder[0] = 1;
        numsWithBorder[length - 1] = 1;
        return max(numsWithBorder, 0, length - 1);
    }

    private int max(int[] nums, int left, int right) {
        if (left + 1 == right) {
            return 0;
        }
        if (cache[left][right] != -1) {
            return cache[left][right];
        }
        int ans = 0;
        for (int i = left + 1; i < right; i++) {
            ans = Math.max(ans, nums[i] * nums[left] * nums[right] + max(nums, left, i) + max(nums, i, right));
        }
        cache[left][right] = ans;
        return ans;
    }
}
