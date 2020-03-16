package cn.sabercon.algorithm.q100.q70;

import java.util.Arrays;

/**
 * Plus One
 * <p>
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 * <p>
 * Example 1:
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * <p>
 * Example 2:
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 *
 * @author ywk
 * @date 2020-03-16
 */
public class Q66 {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                break;
            }
        }
        if (digits[0] == 0) {
            int[] ints = new int[digits.length + 1];
            System.arraycopy(digits, 0, ints, 1, digits.length);
            ints[0] = 1;
            return ints;
        } else {
            return digits;
        }
    }
}
