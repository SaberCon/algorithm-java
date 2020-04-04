package cn.sabercon.algorithm.q300.q220;

/**
 * Shortest Palindrome
 *
 * Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it.
 * Find and return the shortest palindrome you can find by performing this transformation.
 *
 * Example 1:
 *
 * Input: "aacecaaa"
 * Output: "aaacecaaa"
 * Example 2:
 *
 * Input: "abcd"
 * Output: "dcbabcd"
 *
 * @author ywk
 * @date 2020-04-04
 */
public class Q214 {

    public String shortestPalindrome(String s) {
        int pLength = findStartPalindromeLength(s, s.length());
        return new StringBuilder(s.substring(pLength)).reverse().append(s).toString();
    }

    private int findStartPalindromeLength(String s, int length) {
        int i = 0;
        for (int j = length - 1; j >= 0; j--) {
            if (s.charAt(j) == s.charAt(i)) {
                i++;
            }
        }
        if (i == length) {
            return length;
        }
        return findStartPalindromeLength(s, i);
    }
}
