package cn.sabercon.algorithm.q100.q40;

/**
 * Search in Rotated Sorted Array
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * <p>
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * <p>
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 * @author ywk
 * @date 2020-03-11
 */
public class Q33 {

    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int begin, int end) {
        if (begin > end) {
            return -1;
        }
        int middle = (end - begin) / 2 + begin;
        if (target == nums[middle]) {
            return middle;
        }
        if (target > nums[middle]) {
            if (target == nums[end]) {
                return end;
            }
            if (target < nums[end] || nums[middle] > nums[end]) {
                return binarySearch(nums, target, middle + 1, end - 1);
            }
            return binarySearch(nums, target, begin, middle - 1);
        }
        if (target == nums[begin]) {
            return begin;
        }
        if (target > nums[begin] || nums[middle] < nums[begin]) {
            return binarySearch(nums, target, begin + 1, middle - 1);
        }
        return binarySearch(nums, target, middle + 1, end);
    }
}
