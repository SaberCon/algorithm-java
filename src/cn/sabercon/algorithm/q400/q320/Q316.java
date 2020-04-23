package cn.sabercon.algorithm.q400.q320;

/**
 * Remove Duplicate Letters
 *
 * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appears once and only once.
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 *
 * Example 1:
 *
 * Input: "bcabc"
 * Output: "abc"
 * Example 2:
 *
 * Input: "cbacdcbc"
 * Output: "acdb"
 * Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 *
 * @author ywk
 * @date 2020-04-22
 */
public class Q316 {

    public String removeDuplicateLetters(String s) {
        int[] counts = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            counts[c - 'a']++;
        }
        StringBuilder builder = new StringBuilder();
        boolean[] seens = new boolean[26];
        for (char c : chars) {
            counts[c - 'a']--;
            if (seens[c - 'a']) {
                continue;
            }
            int length = builder.length();
            for (int i = length - 1; i >= 0; i--) {
                char ch = builder.charAt(i);
                if (ch > c && counts[ch - 'a'] > 0) {
                    builder.deleteCharAt(i);
                    seens[ch - 'a'] = false;
                } else {
                    break;
                }
            }
            builder.append(c);
            seens[c - 'a'] = true;
        }
        return builder.toString();
    }
}
