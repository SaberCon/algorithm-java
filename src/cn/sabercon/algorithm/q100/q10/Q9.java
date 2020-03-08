package cn.sabercon.algorithm.q100.q10;

/**
 * Palindrome Number
 * <p>
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Example 1:
 * Input: 121
 * Output: true
 * <p>
 * Example 2:
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * <p>
 * Example 3:
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * <p>
 * Follow up:
 * Could you solve it without converting the integer to a string?
 *
 * @author ywk
 * @date 2020-03-08
 */
public class Q9 {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        return x == getReverseInteger(x);
    }

    private int getReverseInteger(int x) {
        int reverse = 0;
        while (x != 0) {
            reverse = 10 * reverse + x % 10;
            x /= 10;
        }
        return reverse;
    }
}
