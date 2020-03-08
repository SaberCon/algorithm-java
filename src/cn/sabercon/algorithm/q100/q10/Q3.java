package cn.sabercon.algorithm.q100.q10;

/**
 * Longest Substring Without Repeating Characters
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * <p>
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * <p>
 * Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * @author ywk
 * @date 2020-03-08
 */
public class Q3 {

    public int lengthOfLongestSubstring(String s) {
        String sub = "";
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            int index = sub.indexOf(s.charAt(i));
            if (index >= 0) {
                sub = sub.substring(index + 1);
            }
            sub += s.charAt(i);
            length = Math.max(length, sub.length());
        }
        return length;
    }

    public static void main(String[] args) {
        Q3 q3 = new Q3();
        System.out.println(q3.lengthOfLongestSubstring("abcabcbb"));
    }
}
