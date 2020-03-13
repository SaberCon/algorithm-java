package cn.sabercon.algorithm.q100.q50;

/**
 * Jump Game II
 * <p>
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * <p>
 * Example:
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 * Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * <p>
 * Note:
 * You can assume that you can always reach the last index.
 *
 * @author ywk
 * @date 2020-03-13
 */
public class Q45 {

    public int jump(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int num = 0;
        int goal = nums.length - 1;
        while (goal != 0) {
            for (int i = 0; i < goal; i++) {
                if (nums[i] >= goal - i) {
                    goal = i;
                    break;
                }
            }
            num++;
        }
        return num;
    }

    public static void main(String[] args) {
        Q45 q45 = new Q45();
        System.out.println(q45.jump(new int[]{2, 3, 1, 1, 4}));
    }
}
