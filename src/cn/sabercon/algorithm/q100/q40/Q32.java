package cn.sabercon.algorithm.q100.q40;

import java.util.Stack;

/**
 * Longest Valid Parentheses
 * <p>
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
 * <p>
 * Example 1:
 * Input: "(()"
 * Output: 2
 * Explanation: The longest valid parentheses substring is "()"
 * <p>
 * Example 2:
 * Input: ")()())"
 * Output: 4
 * Explanation: The longest valid parentheses substring is "()()"
 *
 * @author ywk
 * @date 2020-03-10
 */
public class Q32 {

    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int longest = 0;
        int currentHalfMatch = 0;
        int currentFullMatch = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    longest = Math.max(longest, currentFullMatch);
                    currentHalfMatch = 0;
                    currentFullMatch = 0;
                } else {
                    stack.pop();
                    currentHalfMatch += 2;
                    if (stack.isEmpty()) {
                        currentFullMatch = currentHalfMatch;
                    }
                }
            }
        }
        longest = Math.max(longest, currentFullMatch);
        stack.clear();
        currentHalfMatch = 0;
        currentFullMatch = 0;
        for (int i = charArray.length - 1; i >= 0; i--) {
            char c = charArray[i];
            if (c == ')') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    longest = Math.max(longest, currentFullMatch);
                    currentHalfMatch = 0;
                    currentFullMatch = 0;
                } else {
                    stack.pop();
                    currentHalfMatch += 2;
                    if (stack.isEmpty()) {
                        currentFullMatch = currentHalfMatch;
                    }
                }
            }
        }
        longest = Math.max(longest, currentFullMatch);
        return longest;
    }

    public static void main(String[] args) {
        Q32 q32 = new Q32();
        System.out.println(q32.longestValidParentheses("(()"));
    }
}
