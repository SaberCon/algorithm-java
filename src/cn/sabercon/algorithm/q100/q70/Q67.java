package cn.sabercon.algorithm.q100.q70;

/**
 * Add Binary
 * <p>
 * Given two binary strings, return their sum (also a binary string).
 * The input strings are both non-empty and contains only characters 1 or 0.
 * <p>
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 * <p>
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 * @author ywk
 * @date 2020-03-16
 */
public class Q67 {

    public String addBinary(String a, String b) {
        char[] greater;
        char[] less;
        if (a.length() > b.length()) {
            greater = a.toCharArray();
            less = b.toCharArray();
        } else {
            greater = b.toCharArray();
            less = a.toCharArray();
        }
        int carry = 0;
        for (int i = greater.length - 1; i >= 0; i--) {
            if (i + less.length - greater.length >= 0 && less[i + less.length - greater.length] == '1') {
                greater[i] += carry + 1;
            } else {
                greater[i] += carry;
            }
            if (greater[i] > '1') {
                greater[i] -= 2;
                carry = 1;
            } else {
                carry = 0;
            }
        }
        if (carry == 0) {
            return new String(greater);
        } else {
            return "1" + new String(greater);
        }
    }

    public static void main(String[] args) {
        Q67 q67 = new Q67();
        System.out.println(q67.addBinary("11", "1"));
    }
}
