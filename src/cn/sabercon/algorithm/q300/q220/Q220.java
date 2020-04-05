package cn.sabercon.algorithm.q300.q220;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * Contains Duplicate III
 * <p>
 * Given an array of integers, find out whether there are two distinct indices i and j in the array
 * such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * Example 3:
 * <p>
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 *
 * @author ywk
 * @date 2020-04-05
 */
public class Q220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            Long ceiling = set.ceiling(num);
            if (ceiling != null && ceiling <= num + t) {
                return true;
            }
            Long floor = set.floor(num);
            if (floor != null && floor >= num - t) {
                return true;
            }
            set.add(num);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
