package cn.sabercon.algorithm.q200.q130;

import java.util.HashSet;

/**
 * Longest Consecutive Sequence
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 *
 * Your algorithm should run in O(n) complexity.
 *
 * Example:
 *
 * Input: [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 *
 * @author ywk
 * @date 2020-03-22
 */
public class Q128 {

    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int current = 1;
                while (set.contains(++num)) {
                    current++;
                }
                max = Math.max(max, current);
            }
        }
        return max;
    }
}
