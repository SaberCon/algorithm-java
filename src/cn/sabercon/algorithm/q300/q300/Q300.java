package cn.sabercon.algorithm.q300.q300;

/**
 * Longest Increasing Subsequence
 * <p>
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * <p>
 * Example:
 * <p>
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
 * Note:
 * <p>
 * There may be more than one LIS combination, it is only necessary for you to return the length.
 * Your algorithm should run in O(n^2) complexity.
 * Follow up: Could you improve it to O(n log n) time complexity?
 *
 * @author ywk
 * @date 2020-04-17
 */
public class Q300 {

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] d = new int[nums.length + 1];
        d[1] = nums[0];
        int length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > d[length]) {
                d[++length] = nums[i];
                continue;
            }
            int pos = findPos(d, 1, length, nums[i]);
            d[pos] = nums[i];
        }
        return length;
    }

    private int findPos(int[] d, int start, int end, int num) {
        if (start == end) {
            return start;
        }
        int middle = start + (end - start) / 2;
        if (d[middle] >= num) {
            return findPos(d, start, middle, num);
        } else {
            return findPos(d, middle + 1, end, num);
        }
    }
}
