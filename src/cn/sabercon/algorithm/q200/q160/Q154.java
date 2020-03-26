package cn.sabercon.algorithm.q200.q160;

/**
 * Find Minimum in Rotated Sorted Array II
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * The array may contain duplicates.
 *
 * Example 1:
 *
 * Input: [1,3,5]
 * Output: 1
 * Example 2:
 *
 * Input: [2,2,2,0,1]
 * Output: 0
 *
 * Note:
 *
 * This is a follow up problem to Find Minimum in Rotated Sorted Array.
 * Would allow duplicates affect the run-time complexity? How and why?
 *
 * @author ywk
 * @date 2020-03-26
 */
public class Q154 {

    public int findMin(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }

    private int find(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int middle = start + (end - start) / 2;
        if (nums[middle] > nums[end]) {
            return find(nums, middle + 1, end);
        } else {
            return find(nums, start, middle);
        }
    }
}
