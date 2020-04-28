package cn.sabercon.algorithm.q400.q380;

/**
 * Wiggle Subsequence
 * <p>
 * A sequence of numbers is called a wiggle sequence if the differences between successive numbers strictly alternate between positive and negative.
 * The first difference (if one exists) may be either positive or negative. A sequence with fewer than two elements is trivially a wiggle sequence.
 * <p>
 * For example, [1,7,4,9,2,5] is a wiggle sequence because the differences (6,-3,5,-7,3) are alternately positive and negative.
 * In contrast, [1,4,7,2,5] and [1,7,4,5,5] are not wiggle sequences, the first because its first two differences are positive and the second because its last difference is zero.
 * <p>
 * Given a sequence of integers, return the length of the longest subsequence that is a wiggle sequence.
 * A subsequence is obtained by deleting some number of elements (eventually, also zero) from the original sequence, leaving the remaining elements in their original order.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,7,4,9,2,5]
 * Output: 6
 * Explanation: The entire sequence is a wiggle sequence.
 * Example 2:
 * <p>
 * Input: [1,17,5,10,13,15,10,5,16,8]
 * Output: 7
 * Explanation: There are several subsequences that achieve this length. One is [1,17,10,13,10,16,8].
 * Example 3:
 * <p>
 * Input: [1,2,3,4,5,6,7,8,9]
 * Output: 2
 * Follow up:
 * Can you do it in O(n) time?
 *
 * @author ywk
 * @date 2020-04-28
 */
public class Q376 {

    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        if (length < 2) {
            return length;
        }
        int ans = 1;
        int current = nums[0];
        // 1 代表上升 2 代表下降
        int up = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i] == current) {
                continue;
            }
            if (up == 1) {
                if (nums[i] > current) {
                    up = 2;
                    ans++;
                }
            } else if (up == 2) {
                if (nums[i] < current) {
                    up = 1;
                    ans++;
                }
            } else {
                up = nums[i] > current ? 2 : 1;
                ans++;
            }
            current = nums[i];
        }
        return ans;
    }
}
