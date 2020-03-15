package cn.sabercon.algorithm.q100.q60;

/**
 * Jump Game
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * <p>
 * Example 1:
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * Example 2:
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 *
 * @author ywk
 * @date 2020-03-15
 */
public class Q55 {

    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        return canReach(nums, 0, 0);
    }

    private boolean canReach(int[] nums, int begin, int end) {
        int max = end;
        for (int i = begin; i <= end; i++) {
            max = Math.max(max, i + nums[i]);
        }
        if (max == end) {
            return false;
        }
        if (max >= nums.length - 1) {
            return true;
        }
        return canReach(nums, end + 1, max);
    }
}
