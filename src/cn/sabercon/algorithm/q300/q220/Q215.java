package cn.sabercon.algorithm.q300.q220;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Kth Largest Element in an Array
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Example 1:
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * Example 2:
 *
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 * @author ywk
 * @date 2020-04-05
 */
public class Q215 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            heap.add(num);
        }
        for (int i = 1; i < k; i++) {
            heap.poll();
        }
        return heap.poll();
    }
}
