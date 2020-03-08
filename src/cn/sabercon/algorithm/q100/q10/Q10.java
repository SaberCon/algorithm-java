package cn.sabercon.algorithm.q100.q10;

/**
 * Regular Expression Matching
 * <p>
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * <p>
 * Note:
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 * <p>
 * Example 1:
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * <p>
 * Example 2:
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * <p>
 * Example 3:
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * <p>
 * Example 4:
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 * <p>
 * Example 5:
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 *
 * @author ywk
 * @date 2020-03-08
 */
public class Q10 {

    public boolean isMatch(String s, String p) {
        if (s.equals(p)) {
            return true;
        }
        if (p.length() > 1 && p.charAt(1) == '*') {
            boolean result = false;
            // dynamic programming
            if (isMatch(s, p.substring(2))) {
                result = true;
            }
            for (int i = 0; i < s.length(); i++) {
                if (p.charAt(0) != '.' && s.charAt(i) != p.charAt(0)) {
                    break;
                }
                if (isMatch(s.substring(i + 1), p.substring(2))) {
                    result = true;
                    break;
                }
            }
            return result;
        } else if (p.length() > 0 && s.length() > 0 && (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0))) {
            return isMatch(s.substring(1), p.substring(1));
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Q10 q10 = new Q10();
        System.out.println(q10.isMatch("mississippi", "mis*is*p*."));
    }
}
