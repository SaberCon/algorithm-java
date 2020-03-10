package cn.sabercon.algorithm.q100.q40;

/**
 * Next Permutation
 * <p>
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place and use only constant extra memory.
 * <p>
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * @author ywk
 * @date 2020-03-10
 */
public class Q31 {

    public void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        int reversePoint = getReversePoint(nums);
        for (int i = 0; i < (nums.length - reversePoint) / 2; i++) {
            int temp = nums[reversePoint + i];
            nums[reversePoint + i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
    }

    private int getReversePoint(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (j == nums.length - 1 || nums[j + 1] <= nums[i]) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        return i + 1;
                    }
                }
            }
        }
        return 0;
    }
}
