package cn.sabercon.algorithm.q200.q170;

/**
 * Excel Sheet Column Title
 *
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * Example 1:
 *
 * Input: 1
 * Output: "A"
 * Example 2:
 *
 * Input: 28
 * Output: "AB"
 * Example 3:
 *
 * Input: 701
 * Output: "ZY"
 *
 * @author ywk
 * @date 2020-03-27
 */
public class Q168 {

    public String convertToTitle(int n) {
        StringBuilder builder = new StringBuilder();
        while (n != 0) {
            int remainder = n % 26;
            if (remainder == 0) {
                builder.append('Z');
                n = n / 26 - 1;
            } else {
                builder.append((char) ('A' + remainder - 1));
                n = n / 26;
            }
        }
        return builder.reverse().toString();
    }
}
