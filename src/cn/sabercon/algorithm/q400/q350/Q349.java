package cn.sabercon.algorithm.q400.q350;

import java.util.*;

/**
 * Intersection of Two Arrays
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 *
 * Each element in the result must be unique.
 * The result can be in any order.
 *
 * @author ywk
 * @date 2020-04-27
 */
public class Q349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> ans = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                ans.add(i);
            }
        }
        int[] ansArray = new int[ans.size()];
        int i = 0;
        for (Integer n : ans) {
            ansArray[i++] = n;
        }
        return ansArray;
    }
}
