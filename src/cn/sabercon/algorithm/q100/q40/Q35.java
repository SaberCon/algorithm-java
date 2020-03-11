package cn.sabercon.algorithm.q100.q40;

/**
 * Search Insert Position
 * <p>
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * <p>
 * Example 1:
 * Input: [1,3,5,6], 5
 * Output: 2
 * <p>
 * Example 2:
 * Input: [1,3,5,6], 2
 * Output: 1
 * <p>
 * Example 3:
 * Input: [1,3,5,6], 7
 * Output: 4
 * <p>
 * Example 4:
 * Input: [1,3,5,6], 0
 * Output: 0
 *
 * @author ywk
 * @date 2020-03-11
 */
public class Q35 {

    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int begin, int end) {
        if (begin > end) {
            return begin;
        }
        if (target <= nums[begin]) {
            return begin;
        }
        if (target == nums[end]) {
            return end;
        }
        if (target > nums[end]) {
            return end + 1;
        }
        int middle = (end - begin) / 2 + begin;
        if (target == nums[middle]) {
            return middle;
        }
        if (target < nums[middle]) {
            return binarySearch(nums, target, begin + 1, middle - 1);
        }
        return binarySearch(nums, target, middle + 1, end - 1);
    }
}
