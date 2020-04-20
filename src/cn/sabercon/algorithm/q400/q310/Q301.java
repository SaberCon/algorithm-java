package cn.sabercon.algorithm.q400.q310;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Remove Invalid Parentheses
 * <p>
 * Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * <p>
 * Note: The input string may contain letters other than the parentheses ( and ).
 * <p>
 * Example 1:
 * <p>
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 * Example 2:
 * <p>
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 * Example 3:
 * <p>
 * Input: ")("
 * Output: [""]
 *
 * @author ywk
 * @date 2020-04-20
 */
public class Q301 {

    private Set<String> validExpressions = new HashSet<>();

    public List<String> removeInvalidParentheses(String s) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else if (s.charAt(i) == ')') {
                if (left == 0) {
                    right++;
                } else {
                    left--;
                }
            }
        }
        this.recurse(s, 0, 0, 0, left, right, new StringBuilder());
        return new ArrayList<>(this.validExpressions);
    }

    private void recurse(String s, int index, int leftCount, int rightCount, int leftRem, int rightRem, StringBuilder expression) {
        if (rightCount > leftCount || leftRem < 0 || rightRem < 0) {
            return;
        }
        if (index == s.length()) {
            if (leftRem == 0 && rightRem == 0) {
                this.validExpressions.add(expression.toString());
            }
            return;
        }
        char character = s.charAt(index);
        if (character == '(') {
            recurse(s, index + 1, leftCount, rightCount, leftRem - 1, rightRem, expression);
            expression.append(character);
            recurse(s, index + 1, leftCount + 1, rightCount, leftRem, rightRem, expression);
            expression.deleteCharAt(expression.length() - 1);
        } else if (character == ')') {
            recurse(s, index + 1, leftCount, rightCount, leftRem, rightRem - 1, expression);
            expression.append(character);
            recurse(s, index + 1, leftCount, rightCount + 1, leftRem, rightRem, expression);
            expression.deleteCharAt(expression.length() - 1);
        } else {
            expression.append(character);
            recurse(s, index + 1, leftCount, rightCount, leftRem, rightRem, expression);
            expression.deleteCharAt(expression.length() - 1);
        }
    }
}
