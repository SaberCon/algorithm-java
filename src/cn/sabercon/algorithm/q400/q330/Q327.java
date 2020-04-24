package cn.sabercon.algorithm.q400.q330;

import java.util.Collection;
import java.util.TreeMap;

/**
 * Count of Range Sum
 * <p>
 * Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
 * Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.
 * <p>
 * Note:
 * A naive algorithm of O(n^2) is trivial. You MUST do better than that.
 * <p>
 * Example:
 * <p>
 * Input: nums = [-2,5,-1], lower = -2, upper = 2,
 * Output: 3
 * Explanation: The three ranges are : [0,0], [2,2], [0,2] and their respective sums are: -2, -1, 2.
 *
 * @author ywk
 * @date 2020-04-24
 */
public class Q327 {

    public int countRangeSum(int[] nums, int lower, int upper) {
        int length = nums.length;
        long[] sums = new long[length + 1];
        for (int i = 0; i < length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        TreeMap<Long, Integer> map = new TreeMap<>();
        int ans = 0;
        for (long sum : sums) {
            long min = sum - upper;
            long max = sum - lower;
            Long minKey = map.ceilingKey(min);
            Long maxKey = map.floorKey(max);
            if (minKey != null && maxKey != null && minKey <= maxKey) {
                for (Integer value : map.subMap(minKey, true, maxKey, true).values()) {
                    ans += value;
                }
            }
            map.merge(sum, 1, Integer::sum);
        }
        return ans;
    }
}
