package cn.sabercon.algorithm.q100.q90;

/**
 * Search in Rotated Sorted Array II
 * <p>
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * You are given a target value to search. If found in the array return true, otherwise return false.
 * <p>
 * Example 1:
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * <p>
 * Example 2:
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * <p>
 * Follow up:
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 *
 * @author ywk
 * @date 2020-03-18
 */
public class Q81 {

    public boolean search(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        while (end >= begin) {
            int middle = begin + (end - begin) / 2;
            if (nums[middle] == target || nums[end] == target) {
                return true;
            }
            if (nums[middle] == nums[end]) {
                end--;
                continue;
            }
            if (nums[middle] < target) {
                if (nums[end] < target) {
                    if (nums[middle] < nums[end]) {
                        end = middle - 1;
                    } else {
                        begin = middle + 1;
                        end--;
                    }
                } else {
                    begin = middle + 1;
                    end--;
                }
            } else {
                if (nums[end] < target) {
                    end = middle - 1;
                } else {
                    if (nums[middle] < nums[end]) {
                        end = middle - 1;
                    } else {
                        begin = middle + 1;
                        end--;
                    }
                }
            }
        }
        return false;
    }
}
