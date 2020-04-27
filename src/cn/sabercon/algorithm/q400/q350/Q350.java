package cn.sabercon.algorithm.q400.q350;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Intersection of Two Array II
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 *
 * @author ywk
 * @date 2020-04-27
 */
public class Q350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(nums1.length);
        for (int num : nums1) {
            queue.add(num);
        }
        List<Integer> ans = new ArrayList<>();
        for (int num : nums2) {
            if (queue.remove(num)) {
                ans.add(num);
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
