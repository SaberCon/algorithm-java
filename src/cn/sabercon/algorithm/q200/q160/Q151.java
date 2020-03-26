package cn.sabercon.algorithm.q200.q160;

import java.util.LinkedList;

/**
 * Reverse Words in a String
 *
 * Given an input string, reverse the string word by word.
 *
 * Example 1:
 *
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 * Note:
 *
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 * Follow up:
 *
 * For C programmers, try to solve it in-place in O(1) extra space.
 *
 * @author ywk
 * @date 2020-03-26
 */
public class Q151 {

    public String reverseWords(String s) {
        LinkedList<String> list = new LinkedList<>();
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (start + 1 != i) {
                    list.addFirst(s.substring(start + 1, i));
                }
                start = i;
            }
        }
        if (start != s.length() - 1) {
            list.addFirst(s.substring(start + 1));
        }
        return String.join(" ", list);
    }
}
