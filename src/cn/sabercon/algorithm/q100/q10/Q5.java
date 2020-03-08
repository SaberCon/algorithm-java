package cn.sabercon.algorithm.q100.q10;

/**
 * Longest Palindromic Substring
 * <p>
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * <p>
 * Example 2:
 * Input: "cbbd"
 * Output: "bb"
 *
 * @author ywk
 * @date 2020-03-08
 */
public class Q5 {

    public String longestPalindrome(String s) {
        String result = "";
        for (int start = 0; start < s.length(); start++) {
            int end = s.length() - 1;
            while (end >= start) {
                if (isPalindrome(s, start, end)) {
                    if (result.length() < s.substring(start, end + 1).length()) {
                        result = s.substring(start, end + 1);
                    }
                    break;
                }
                end--;
            }

        }
        return result;
    }

    public boolean isPalindrome(String s, int start, int end) {
        for (int i = 0; i <= (end - start) / 2; i++) {
            if (s.charAt(start + i) != s.charAt(end - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "babad";
        Q5 q5 = new Q5();
        System.out.println(q5.longestPalindrome(s));
    }
}
