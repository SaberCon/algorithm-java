package cn.sabercon.algorithm.q100.q10;

/**
 * Zigzag Conversion
 * <p>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string s, int numRows);
 * <p>
 * Example 1:
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * <p>
 * Example 2:
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * @author ywk
 * @date 2020-03-08
 */
public class Q6 {

    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        int patternNum = 2 * numRows - 2;
        StringBuilder builder = new StringBuilder();
        char[][] chars = new char[s.length() / patternNum + 1][patternNum];
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                if (count >= s.length()) {
                    break;
                }
                chars[i][j] = s.charAt(count++);
            }
        }
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < chars.length; j++) {
                if (chars[j][i] != '\u0000') {
                    builder.append(chars[j][i]);
                }
                if (i != 0 && i != numRows - 1 && chars[j][patternNum - i] != '\u0000') {
                    builder.append(chars[j][patternNum - i]);
                }
            }
        }
        return builder.toString();
    }
}
