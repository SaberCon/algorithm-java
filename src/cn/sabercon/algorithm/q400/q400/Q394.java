package cn.sabercon.algorithm.q400.q400;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 394. Decode String
 *
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
 * Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
 * For example, there won't be input like 3a or 2[4].
 *
 * Examples:
 *
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 *
 * @author SaberCon
 * @date 2020-05-27
 */
public class Q394 {

    public String decodeString(String s) {
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<StringBuilder> strStack = new ArrayDeque<>();
        strStack.push(new StringBuilder());
        int num = 0;
        for (char c : s.toCharArray()) {
            if (c == '[') {
                strStack.push(new StringBuilder());
                numStack.push(num);
                num = 0;
            } else if (c == ']') {
                Integer count = numStack.pop();
                StringBuilder str = strStack.pop();
                for (int i = 0; i < count; i++) {
                    strStack.peek().append(str);
                }
            } else if (c >= '0' && c <= '9') {
                num = 10 * num + c - '0';
            } else {
                strStack.peek().append(c);
            }
        }
        return strStack.pop().toString();
    }
}
