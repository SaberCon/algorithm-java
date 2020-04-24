package cn.sabercon.algorithm.q400.q330;

/**
 * Wiggle Sort II
 *
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 *
 * Example 1:
 *
 * Input: nums = [1, 5, 1, 1, 6, 4]
 * Output: One possible answer is [1, 4, 1, 5, 1, 6].
 * Example 2:
 *
 * Input: nums = [1, 3, 2, 2, 3, 1]
 * Output: One possible answer is [2, 3, 1, 3, 1, 2].
 * Note:
 * You may assume all input has valid answer.
 *
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 *
 * @author ywk
 * @date 2020-04-23
 */
public class Q324 {

    public static void wiggleSort(int[] nums) {
        int middle = nums.length / 2;
        findMiddle(nums, middle, 0, nums.length - 1);
        findMiddle(nums, middle / 2, 0, middle - 1);
        findMiddle(nums, middle + (nums.length - middle) / 2, middle + 1, nums.length - 1);
        int[] clone = nums.clone();
        for (int i = 0; i < (nums.length + 1) / 2; i++) {
            nums[nums.length - i * 2 - 2 + nums.length % 2] = clone[i];
        }
        for (int i = (nums.length + 1) / 2; i < nums.length; i++) {
            nums[nums.length - (i - (nums.length + 1) / 2) * 2 - 1 - nums.length % 2] = clone[i];
        }
    }

    private static void findMiddle(int[] nums, int middle, int start, int end) {
        if (start >= end) {
            return;
        }
        int current = nums[start];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] < current) {
                index++;
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
            }
        }
        int temp = nums[index];
        nums[index] = nums[start];
        nums[start] = temp;
        if (index == middle) {
            return;
        }
        if (index < middle) {
            findMiddle(nums, middle, index + 1, end);
        }
        findMiddle(nums, middle, start, index - 1);
    }

    public static void main(String[] args) {
        wiggleSort(new int[]{1,5,1,1,6,4});
    }
}
