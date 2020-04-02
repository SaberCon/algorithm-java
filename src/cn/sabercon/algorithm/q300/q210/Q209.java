package cn.sabercon.algorithm.q300.q210;

/**
 * Minimum Size Subarray Sum
 * <p>
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * <p>
 * Example: 
 * <p>
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
 *
 * @author ywk
 * @date 2020-04-02
 */
public class Q209 {

    public int minSubArrayLen(int s, int[] nums) {
        int length = nums.length;
        int start = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= s) {
                length = Math.min(length, i - start);
                sum -= nums[start];
                start++;
            }
        }
        return length == nums.length ? 0 : length + 1;
    }
}
