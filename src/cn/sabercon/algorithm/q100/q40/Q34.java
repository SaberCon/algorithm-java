package cn.sabercon.algorithm.q100.q40;

/**
 * Find First and Last Position of Element in Sorted Array
 * <p>
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * <p>
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * <p>
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * @author ywk
 * @date 2020-03-11
 */
public class Q34 {

    public int[] searchRange(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int[] binarySearch(int[] nums, int target, int begin, int end) {
        if (begin > end) {
            return new int[]{-1, -1};
        }
        int middle = (end - begin) / 2 + begin;
        if (target == nums[begin]) {
            if (target == nums[end]) {
                return new int[]{begin, end};
            }
            if (target == nums[middle]) {
                return new int[]{begin, searchEnd(nums, target, middle, end - 1)};
            }
            return new int[]{begin, searchEnd(nums, target, begin, middle - 1)};
        }
        if (target == nums[end]) {
            if (target == nums[middle]) {
                return new int[]{searchBegin(nums, target, begin + 1, middle), end};
            }
            return new int[]{searchBegin(nums, target, middle + 1, end), end};
        }
        if (target == nums[middle]) {
            return new int[]{searchBegin(nums, target, begin + 1, middle), searchEnd(nums, target, middle, end - 1)};
        }
        if (target < nums[middle]) {
            return binarySearch(nums, target, begin + 1, middle - 1);
        }
        return binarySearch(nums, target, middle + 1, end - 1);
    }

    private int searchEnd(int[] nums, int target, int begin, int end) {
        if (begin >= end) {
            return begin;
        }
        if (target == nums[end]) {
            return end;
        }
        int middle = (end - begin) / 2 + begin;
        if (target == nums[middle]) {
            return searchEnd(nums, target, middle, end - 1);
        }
        return searchEnd(nums, target, begin, middle - 1);
    }

    private int searchBegin(int[] nums, int target, int begin, int end) {
        if (end <= begin) {
            return end;
        }
        if (target == nums[begin]) {
            return begin;
        }
        int middle = (end - begin) / 2 + begin;
        if (target == nums[middle]) {
            return searchBegin(nums, target, begin + 1, middle);
        }
        return searchBegin(nums, target, middle + 1, end);
    }
}
