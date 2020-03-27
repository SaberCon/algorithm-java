package cn.sabercon.algorithm.q200.q180;

/**
 * Excel Sheet Column Number
 *
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * Example 1:
 *
 * Input: "A"
 * Output: 1
 * Example 2:
 *
 * Input: "AB"
 * Output: 28
 * Example 3:
 *
 * Input: "ZY"
 * Output: 701
 *
 * @author ywk
 * @date 2020-03-27
 */
public class Q171 {

    public int titleToNumber(String s) {
        int result = 0;
        int multiple = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            result += (s.charAt(i) - 'A' + 1) * multiple;
            multiple *= 26;
        }
        return result;
    }
}
