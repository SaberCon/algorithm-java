package cn.sabercon.algorithm.q100.q50;

/**
 * Multiply Strings
 * <p>
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 * <p>
 * Example 1:
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * <p>
 * Example 2:
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * <p>
 * Note:
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 *
 * @author ywk
 * @date 2020-03-12
 */
public class Q43 {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        char[] chars1 = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] chars2 = new StringBuilder(num2).reverse().toString().toCharArray();
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < num1.length() + num2.length() - 1; i++) {
            for (int j = Math.max(0, i - chars2.length + 1); j < chars1.length && i >= j; j++) {
                carry += (chars1[j] - '0') * (chars2[i - j] - '0');
            }
            builder.append(carry % 10);
            carry /= 10;
        }
        if (carry != 0) {
            builder.append(carry);
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        Q43 q43 = new Q43();
        System.out.println(q43.multiply("9133", "0"));
    }
}
