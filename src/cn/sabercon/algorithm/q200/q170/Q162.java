package cn.sabercon.algorithm.q200.q170;

/**
 * Find Peak Element
 *
 * A peak element is an element that is greater than its neighbors.
 *
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 *
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 *
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 *              or index number 5 where the peak element is 6.
 * Note:
 *
 * Your solution should be in logarithmic complexity.
 *
 * @author ywk
 * @date 2020-03-26
 */
public class Q162 {

    public int findPeakElement(int[] nums) {
        return findPeak(nums, 0, nums.length - 1);
    }

    private int findPeak(int[] nums, int start, int end) {
        if (start == end) {
            return start;
        }
        int middle = start + (end - start) / 2;
        if (middle == start) {
            if (nums[start] > nums[end]) {
                return start;
            } else {
                return end;
            }
        }
        if (nums[middle] > nums[middle - 1] && nums[middle] > nums[middle + 1]) {
            return middle;
        }
        if (nums[middle] > nums[middle - 1] && nums[middle] < nums[middle + 1]) {
            return findPeak(nums, middle + 1, end);
        }
        if (nums[middle] < nums[middle - 1] && nums[middle] > nums[middle + 1]) {
            return findPeak(nums, start, middle - 1);
        }
        return findPeak(nums, start, middle - 1);
    }
}
