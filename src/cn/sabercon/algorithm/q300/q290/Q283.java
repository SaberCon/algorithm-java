package cn.sabercon.algorithm.q300.q290;

/**
 * Move Zeros
 * <p>
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * <p>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 * @author ywk
 * @date 2020-04-15
 */
public class Q283 {

    public void moveZeroes(int[] nums) {
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (current != i) {
                    nums[current] = nums[i];
                }
                current++;
            }
        }
        for (int i = current; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
