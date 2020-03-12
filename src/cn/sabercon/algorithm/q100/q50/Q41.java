package cn.sabercon.algorithm.q100.q50;

/**
 * First Missing Positive
 * <p>
 * Given an unsorted integer array, find the smallest missing positive integer.
 * <p>
 * Example 1:
 * Input: [1,2,0]
 * Output: 3
 * <p>
 * Example 2:
 * Input: [3,4,-1,1]
 * Output: 2
 * <p>
 * Example 3:
 * Input: [7,8,9,11,12]
 * Output: 1
 * <p>
 * Note:
 * Your algorithm should run in O(n) time and uses constant extra space.
 *
 * @author ywk
 * @date 2020-03-12
 */
public class Q41 {

    public int firstMissingPositive(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = nums.length + 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) <= nums.length) {
                nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
