package cn.sabercon.algorithm.q400.q310;

/**
 * Additive Number
 * <p>
 * Additive number is a string whose digits can form additive sequence.
 * <p>
 * A valid additive sequence should contain at least three numbers. Except for the first two numbers,
 * each subsequent number in the sequence must be the sum of the preceding two.
 * <p>
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 * <p>
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * <p>
 * Example 1:
 * <p>
 * Input: "112358"
 * Output: true
 * Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 *              1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * Example 2:
 * <p>
 * Input: "199100199"
 * Output: true
 * Explanation: The additive sequence is: 1, 99, 100, 199. 
 *              1 + 99 = 100, 99 + 100 = 199
 * <p>
 * Constraints:
 * <p>
 * num consists only of digits '0'-'9'.
 * 1 <= num.length <= 35
 * Follow up:
 * How would you handle overflow for very large input integers?
 *
 * @author ywk
 * @date 2020-04-20
 */
public class Q306 {

    public boolean isAdditiveNumber(String num) {
        int twoNumMaxLength = num.length() * 2 / 3;
        for (int i = 1; i < twoNumMaxLength; i++) {
            for (int j = 1; j <= i; j++) {
                if (isAdditive(num, 0, j, i + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAdditive(String num, int firstStart, int firstEnd, int secondEnd) {
        if (secondEnd == num.length()) {
            return true;
        }
        if ((num.charAt(firstStart) == '0' && firstEnd - firstStart != 1) || (num.charAt(firstEnd) == '0' && secondEnd - firstEnd != 1)) {
            return false;
        }
        String sum;
        try {
            sum = String.valueOf(Long.parseLong(num.substring(firstStart, firstEnd)) + Long.parseLong(num.substring(firstEnd, secondEnd)));
        } catch (NumberFormatException e) {
            return false;
        }
        if (!num.startsWith(sum, secondEnd)) {
            return false;
        }
        return isAdditive(num, firstEnd, secondEnd, secondEnd + sum.length());
    }

    public static void main(String[] args) {
        Q306 q306 = new Q306();
        System.out.println(q306.isAdditiveNumber("121474836472147483648"));
    }
}
