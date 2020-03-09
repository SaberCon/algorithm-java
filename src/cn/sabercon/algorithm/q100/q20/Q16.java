package cn.sabercon.algorithm.q100.q20;

import java.util.Arrays;

/**
 * 3Sum Closest
 * <p>
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * @author ywk
 * @date 2020-03-09
 */
public class Q16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestNum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int begin = i + 1;
            int end = nums.length - 1;
            while (begin < end) {
                int sum = nums[begin] + nums[end] + nums[i];
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    begin++;
                } else {
                    return target;
                }
                closestNum = Math.abs(sum - target) < Math.abs(closestNum - target) ? sum : closestNum;
            }
        }
        return closestNum;
    }
}
